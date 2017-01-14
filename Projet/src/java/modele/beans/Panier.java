/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author p1402690
 */
public class Panier {
    private ArrayList<Produit> produits;

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    
    public void ajouterProduit(Produit p)
    {
        
    }
    
    public Produit getProduit(int numProduit)
    {
        for (Produit tmp : produits) {
            if(tmp.getNumProduit() == numProduit) return tmp;
        }
        return null;
    }
}
