/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Manager;
import modele.beans.Utilisateur;

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
        HttpSession session = request.getSession(true);
        
        //Si la session contient un objet utilisateur, on déconnecte cet utilisateur
        if(session.getAttribute("utilisateur") != null)
        {
            session.removeAttribute("utilisateur");
            session.invalidate();
        }
        else
        {
            Manager man = new Manager();
            
            String pseudo = getChamp(request,"pseudo");
            String mdp = getChamp(request,"mdp");
            if(pseudo != null && mdp != null)
            {
                Utilisateur user = null;
                try
                {
                    user = man.connexion(pseudo, mdp);
                }
                catch (SQLException ex)
                {
                    request.setAttribute("message", "Votre pseudo ou votre mot de passe est incorrect");
                    request.setAttribute("titrePage", "Connexion");
                    request.setAttribute("afficherPage", "pages/connexion.jsp");
                    this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
                }
                
                if(user != null) //si logs valides
                {
                    session.setAttribute("utilisateur",user);
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
        String valeur;
        if((boolean)request.getAttribute("redirection"))
            valeur = request.getParameter( nomChamp );
        else
            valeur = (String)request.getAttribute( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
}
