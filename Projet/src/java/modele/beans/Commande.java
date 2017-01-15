/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pierre-Elliott
 */
public class Commande implements Serializable {
    private int numCommande;
    private String typeCommande;
    private Date date;
    
    private int nbProduits;
    private int prix = 0;
    private List<Produit> produits;
    private int numRue;
    private String rue;
    private String ville;
    private String codePostal;

    public int getPrix() {
        return prix;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;

        for(Produit p : produits)
        {
            prix += p.getPrix()*p.getQuantite();
        }
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
