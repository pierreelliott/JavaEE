/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pierre-Elliott
 */
public class Commande implements Serializable {
    private int numCommande;
    private String typeCommande;
    private Date date;
    
    private int nbProduits;
    private List<Produit> produits; //Key => produit //Value => quantité
                                            // Mettre seulement le numProduit ?
    private int numRue;
    private String rue;
    private String ville;
    private String codePostal;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public void setTypeCommande(String typeCommande) {
        this.typeCommande = typeCommande;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
    public int getNbProduits() {
        return nbProduits;
    }

    public void setNbProduits(int nbProduits) {
        this.nbProduits = nbProduits;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public String getTypeCommande() {
        return typeCommande;
    }

    public Date getDate() {
        return date;
    }

    public int getNumRue() {
        return numRue;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }    
}
