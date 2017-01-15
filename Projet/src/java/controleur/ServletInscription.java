/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Manager;

/**
 *
 * @author p1402690
 */
public class ServletInscription extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String nom = getChamp(request,"nom");
        String prenom = getChamp(request,"prenom");
        String pseudo = getChamp(request,"pseudo");

        String numRue = getChamp(request,"numRue");
        String rue = getChamp(request,"rue");
        String codePostal = getChamp(request,"codePostal");
        String ville = getChamp(request,"ville");

        String mail = getChamp(request,"email");
        String telephone = getChamp(request,"tel");

        String mdp = getChamp(request,"mdp");
        String mdpConfirm = getChamp(request,"mdpConfirm");
        
        String message = "";

        if (nom != null && prenom != null && pseudo != null && mail != null && telephone != null && mdp != null && mdpConfirm != null)
        {
            Manager man = new Manager();
            
            //Vérifier si les mdp sont identiques
            if(!mdp.equals(mdpConfirm)) message += "Les mots de passe ne sont pas identiques";
            
            try {
                //Vérifier si pseudo n'est pas déjà pris
                if(man.existe(pseudo)) message += "Ce pseudonyme n'est pas disponible<br>";
            } catch (SQLException ex) {
                message += "Erreur lors de l'inscription. Veuillez réessayer. (1)";
            }
            
            //Si il y a eu une erreur, on redirige vers la page d'inscription en affichant le(s) message(s) d'erreur
            if(!message.equalsIgnoreCase(""))
            {
                request.setAttribute("message", message);
                request.setAttribute("titrePage", "Inscription");
                request.setAttribute("afficherPage", "pages/inscription.jsp");
                this.getServletContext().getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
            }
            
            boolean statut;
            
            try {
                if(numRue != null && rue != null && codePostal != null && ville != null)
                {
                    //Ajouter utilisateur avec une adresse
                    statut = man.inscription(pseudo, mdp, nom, prenom, mail, telephone, Integer.parseInt(numRue), rue, ville, codePostal);
                }
                else
                {
                    //Ajouter utilisateur sans adresse
                    statut = man.inscription(pseudo, mdp, nom, prenom, mail, telephone);
                }
            } catch (SQLException e) {
                System.out.println("Erreur inscription");
                statut = false;
            }
            
            if(statut == false)
            {
                request.setAttribute("message", "Erreur lors de l'inscription. Veuillez réessayer. (2)");
                request.setAttribute("titrePage", "Inscription");
                request.setAttribute("afficherPage", "pages/inscription.jsp");
                this.getServletContext().getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
            }
            
            request.setAttribute("redirection", true);
            request.setAttribute("pseudo", pseudo);
            request.setAttribute("mdp", mdp);
            
            this.getServletContext().getRequestDispatcher("/connexion").forward(request, response);
        }
        else
        {
            request.setAttribute("titrePage", "Inscription");
            request.setAttribute("afficherPage", "pages/inscription.jsp");
            this.getServletContext().getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        
    private static String getChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}
