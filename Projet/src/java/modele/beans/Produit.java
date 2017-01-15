/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.io.Serializable;

/**
 *
 * @author Pierre-Elliott
 */
public class Produit implements Serializable {
    private int numProduit;
    private String typeProduit;
    
    private String libelle;
    private float prix;
    private String description;
    
    private String image;
    
    private int quantite;
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public int getNumProduit() {
        return numProduit;
    }

    public void setNumProduit(int numProduit) {
        this.numProduit = numProduit;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(int qte) {
        this.quantite = qte;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        return this.numProduit == other.numProduit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.numProduit;
        return hash;
    }
    
    
}
