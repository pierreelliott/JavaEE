/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Manager;
import modele.beans.*;

/**
 *
 * @author p1402690
 */
public class ServletCommande extends HttpServlet {

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
        
        String action = request.getParameter("action");
        if(action == null) action ="";
        
        Manager man = new Manager();
        Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");
        
        switch(action)
        {
            case "ajouter":
                if(user != null)
                {
                    Commande comm = new Commande();
                    Panier panier = (Panier)session.getAttribute("panier");
                    
                    if(user.getCodePostal() != null || user.getRue() != null || user.getVille() != null || user.getNumRue() != 0)
                    {
                        comm.setCodePostal(user.getCodePostal());
                        comm.setNumRue(user.getNumRue());
                        comm.setRue(user.getRue());
                        comm.setVille(user.getVille());
                    }
                    comm.setProduits(panier.getProduits());
                    
                    user.addCommande(comm);
                    try {
                        man.ajouterCommande(comm, user);
                    } catch (SQLException ex) {
                        break;
                    }
                    session.removeAttribute("panier");
                    this.getServletContext().getRequestDispatcher( "/accueil" ).forward( request, response );
                }
                else
                    break;
                break;
            case "afficher":
            default:
                if(user != null)
                {
                    try {
                        man.recupererCommandes(user);
                    } catch (SQLException ex) {
                        break;
                    }
                    request.setAttribute("commandes", user.getCommandes());
                    
                    request.setAttribute("titrePage", "Mes commandes");
                    request.setAttribute("afficherPage", "pages/commande.jsp");
                    this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
                }
                else
                    break;
        }
        
        request.setAttribute("titrePage", "Erreur");
        request.setAttribute("afficherPage", "pages/404.jsp");
        this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
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
