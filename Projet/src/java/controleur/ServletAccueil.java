/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pierre-Elliott
 */
public class ServletAccueil extends HttpServlet {

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
        HttpSession session = request.getSession();
        //if(session.isNew()) session.setAttribute("estConnecte", false);
        
        request.setAttribute("titrePage", "Accueil");
        request.setAttribute("afficherPage", "pages/accueil.jsp");
        this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
        
        /*
        String page = request.getParameter("page");
        if(page == null || page.equals("index"))
        {
            page = "accueil";
        }
        switch(page)
        {
            case "carte": case "Carte":
                this.getServletContext().getRequestDispatcher( "/carte" ).forward( request, response );
                break;
            case "produit": case "Produit":
                this.getServletContext().getRequestDispatcher( "/produit" ).forward( request, response );
                break;
            case "connexion":
                this.getServletContext().getRequestDispatcher( "/connexion" ).forward( request, response );
                break;
            case "utilisateur":
                this.getServletContext().getRequestDispatcher( "/utilisateur" ).forward( request, response );
                break;
            case "deconnexion":
                //
                break;
            case "inscription":			
                this.getServletContext().getRequestDispatcher( "/inscription" ).forward( request, response );
                break;
            case "panier":
                this.getServletContext().getRequestDispatcher( "/panier" ).forward( request, response );
                break;
            case "accueil":
            default:
                request.setAttribute("titrePage", "Accueil");
                request.setAttribute("afficherPage", "pages/accueil.jsp");
                this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
                break;
        }*/
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

}
