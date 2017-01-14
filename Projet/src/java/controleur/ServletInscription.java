/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            //Vérifier si pseudo n'est pas déjà pris
            if(true) message += "Ce pseudonyme n'est pas disponible<br>";
            
            //Vérifier si les mdp sont identiques
            if(!mdp.equals(mdpConfirm)) message += "Les mots de passe ne sont pas identiques";
            
            //Si il y a eu une erreur, on redirige vers la page d'inscription en affichant le(s) message(s) d'erreur
            if(message.equalsIgnoreCase(""))
            {
                request.setAttribute("message", message);
                request.setAttribute("titrePage", "Inscription");
                request.setAttribute("afficherPage", "pages/inscription.jsp");
                this.getServletContext().getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
            }
            
            if(numRue != null && rue != null && codePostal != null && ville != null)
            {
                //Ajouter utilisateur avec une adresse
            }
            else
            {
                //Ajouter utilisateur sans adresse
            }
            
            //session.setAttribute("utilisateur",utilisateur);
            //Connecter l'utilisateur
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

    
    /*
    private void validationNom(String nom) throws Exception {
        if (nom != null) {
            if (nom.length() < 2) {
                throw new Exception("Le nom d'utilisateur doit contenir au moins 2 caractères.");
            }
        } else {
            throw new Exception("Merci d'entrer un nom d'utilisateur.");
        }
    }
    
    private void validationPseudo(String pseudo) throws Exception {
        if (pseudo != null) {
            if (pseudo.length() < 2) {
                throw new Exception("Le nom d'utilisateur doit contenir au moins 2 caractères.");
            }
        } else {
            throw new Exception("Merci d'entrer un pseudo.");
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if (prenom != null && prenom.length() < 2) {
            throw new Exception("Le prénom d'utilisateur doit contenir au moins 2 caractères.");
        }
    }

    private void validationAdresse(String adresse) throws Exception {
        if (adresse != null) {
            if (adresse.length() < 10) {
                throw new Exception("L'adresse de livraison doit contenir au moins 10 caractères.");
            }
        } else {
            throw new Exception("Merci d'entrer une adresse de livraison.");
        }
    }

    private void validationTelephone(String telephone) throws Exception {
        if (telephone != null) {
            if (!telephone.matches("^\\d+$")) {
                throw new Exception("Le numéro de téléphone doit uniquement contenir des chiffres.");
            } else if (telephone.length() < 4) {
                throw new Exception("Le numéro de téléphone doit contenir au moins 4 chiffres.");
            }
        } else {
            throw new Exception("Merci d'entrer un numéro de téléphone.");
        }
    }*/
    
    private static String getChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}
