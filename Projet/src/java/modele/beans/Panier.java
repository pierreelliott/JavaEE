/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void addProduit(Produit p, int qte) {
        p.setQuantite(qte);
        produits.add(p);
    }
    
    public void modifProduit(Produit p, int qte) {
        for(Produit tmp : produits)
        {
            if(tmp.equals(p))
            {
                tmp.setQuantite(tmp.getQuantite() + qte);
            }
        }
    }

    public boolean removeProduit(Produit p) {
        return (produits.remove(p) != false);
    }

    public Produit getProduit(int numProduit) {
        for (Produit tmp : produits) {
            if (tmp.getNumProduit() == numProduit) {
                return tmp;
            }
        }
        return null;
    }
    
    public Produit getProduit(Produit p) {
        for (Produit tmp : produits) {
            if (tmp.equals(p)) {
                return tmp;
            }
        }
        return null;
    }
}
