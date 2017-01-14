/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.ConnexionBD;

/**
 *
 * @author p1402690
 */
public class ServletConnexion extends HttpServlet {

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
        ConnexionBD bdd = new ConnexionBD();
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        bdd.setLogin("p1503940");
        bdd.setPassword("241638");
        bdd.setHostname("localhost");
        bdd.setPort("");
        bdd.setNomDeLaBase("p1503940");
        
        HttpSession session = request.getSession(true);
        
        //Si la session contient un objet utilisateur, on déconnecte cet utilisateur
        if(session.getAttribute("utilisateur") != null)
        {
            //Supprimer la session et déconnecter l'utilisateur
        }
        else
        {
            String pseudo = getChamp(request,"pseudo");
            String mdp = getChamp(request,"mdp");
            if(pseudo != null && mdp != null)
            {
                cnx = bdd.getConnexion();
                try
                {
                    ps = cnx.prepareStatement("select numUser, pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, typeUser, dateInscription"
                            + "from utilisateur where pseudo = ? and mdp = ?");
                    ps.setString(1, pseudo);
                    ps.setString(2, mdp);
                    
                    rs = ps.executeQuery();
                    
                    // Faut trouver le nombre de lignes renvoyées mais je sais plus comment faire
                    //rs.
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(ServletConnexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                //Tester les logins
                boolean login = false;
                if(login) //si logs valides
                {
                    /*
                        Utilisateur utilisateur = new Utilisateur();
                        
                        utilisateur.charger(pseudo); //On récupère les informations liées à l'utilisateur
                        //À voir comment on implémente ça
                    
                        session.setAttribute("utilisateur",utilisateur);
                    */
                    this.getServletContext().getRequestDispatcher( "accueil" ).forward( request, response );
                }
                else
                {
                    request.setAttribute("message", "Votre pseudo ou votre mot de passe est incorrect");
                    request.setAttribute("titrePage", "Connexion");
                    request.setAttribute("afficherPage", "pages/connexion.jsp");
                    this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
                }
            }
            else
            {
                request.setAttribute("titrePage", "Connexion");
                request.setAttribute("afficherPage", "pages/connexion.jsp");
                this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
            }
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
