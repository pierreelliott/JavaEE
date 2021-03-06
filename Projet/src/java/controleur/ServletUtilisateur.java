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
import modele.beans.Utilisateur;

/**
 *
 * @author p1402690
 */
public class ServletUtilisateur extends HttpServlet {

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
        Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");
        
        if(user != null)
        {
            int numRue = user.getNumRue();
            String rue = user.getRue();
            String codePostal = user.getCodePostal();
            String ville = user.getVille();
            
            if(numRue == 0 || rue.equalsIgnoreCase("") || codePostal.equalsIgnoreCase("") || ville.equalsIgnoreCase(""))
            {
                boolean adr = false;
                request.setAttribute("adresse", adr);
            }
            else
            {
                boolean adr = true;
                request.setAttribute("adresse", adr);
            }
            
            request.setAttribute("titrePage", "Mon compte");
            request.setAttribute("afficherPage", "pages/utilisateur.jsp");
            this.getServletContext().getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("titrePage", "Accueil");
            request.setAttribute("afficherPage", "pages/accueil.jsp");
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

}
