/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

/**
 *
 * @author Pierre-Elliott
 */
public class Produit {
    private int numProduit;
    private String typeProduit;
    
    private String libelle;
    private int prix;
    private String description;
    
    private String sourcePetit;
    private String sourceMoyen;
    private String sourceGrand;

    public String getSourcePetit() {
        return sourcePetit;
    }

    public void setSourcePetit(String sourcePetit) {
        this.sourcePetit = sourcePetit;
    }

    public String getSourceMoyen() {
        return sourceMoyen;
    }

    public void setSourceMoyen(String sourceMoyen) {
        this.sourceMoyen = sourceMoyen;
    }

    public String getSourceGrand() {
        return sourceGrand;
    }

    public void setSourceGrand(String sourceGrand) {
        this.sourceGrand = sourceGrand;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
