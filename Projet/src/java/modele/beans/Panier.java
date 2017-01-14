/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author p1402690
 */
public class Panier implements Serializable {
    private List<Produit> produits;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    public void ajouterProduit(Produit p)
    {
        produits.add(p);
    }
    
    public Produit getProduit(int numProduit)
    {
        for (Produit tmp : produits) {
            if(tmp.getNumProduit() == numProduit) return tmp;
        }
        return null;
    }
}
