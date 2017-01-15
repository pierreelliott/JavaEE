/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Manager;
import modele.beans.Carte;
import modele.beans.Panier;
import modele.beans.Produit;

/**
 *
 * @author p1402690
 */
public class ServletPanier extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        String action = request.getParameter("action");
        if(action == null) action ="";
        out.println(action);
        
        Panier panier = (Panier)session.getAttribute("panier");
        if(panier == null){
            panier = new Panier();
            panier.setProduits(new ArrayList<>());
        }
        else panier = (Panier)session.getAttribute("panier");
        
        int numP;
        int qte;
        
        switch(action)
        {
            case "ajout":
                if(request.getParameter("numProduit") == null)
                {
                    out.println("erreur numProduit");
                }
                numP = 1;
                if(request.getParameter("qte") == null)
                {
                   out.println("erreur qte");
                }
                qte = 1;
                if(qte < 1) qte = 1;
                Manager man = new Manager();
                Carte carte;
                out.println("Allo1");
                try {
                    carte = man.recupererCarte();
                    Produit p = carte.getProduit(numP);
                    if(p == null)
                    {
                        out.println("Allo2");
                        //System.out.println("Produit : "+p+", libelle :"+p.getLibelle());
                        panier.addProduit(p,1);
                    }
                    else
                    {
                        out.println("Allo3");
                        panier.modifProduit(p, 1);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ServletPanier.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.println("Allo4");
                session.setAttribute("panier", panier);
                out.println("Allo5");
                this.getServletContext().getRequestDispatcher( "/carte" ).forward( request, response );
                break;
                
            case "modification":
                numP = Integer.parseInt(request.getParameter("numProduit"));
                qte = Integer.parseInt(request.getParameter("qte"));
                Produit p = panier.getProduit(numP);
                panier.modifProduit(p, qte);                
                break;
            
            case "suppression":
                numP = Integer.parseInt(request.getParameter("numProduit"));
                Produit prod = panier.getProduit(numP);
                panier.removeProduit(prod);
                break;
            case "afficher":
            default:
                if(panier.getProduits() == null || panier.getProduits().isEmpty()) {
                    request.setAttribute("panierVide", true);
                }
                else
                    request.setAttribute("panier", panier);
                request.setAttribute("titrePage", "Panier");
                request.setAttribute("afficherPage", "pages/panier.jsp");
                this.getServletContext().getRequestDispatcher( "/WEB-INF/layout.jsp" ).forward( request, response );
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
