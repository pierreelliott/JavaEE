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
    private float prix;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
        for(Produit tmp : produits)
        {
            prix += tmp.getPrix();
        }
    }

    public void addProduit(Produit p, int qte) {
        p.setQuantite(qte);
        produits.add(p);
        prix += p.getPrix()*qte;
    }
    
    public void modifProduit(Produit p, int qte) {
        for(Produit tmp : produits)
        {
            if(tmp.equals(p))
            {
                tmp.setQuantite(tmp.getQuantite() + qte);
            }
        }
        prix += p.getPrix()*qte;
    }

    public boolean removeProduit(Produit p) {
        prix -= p.getPrix()*p.getQuantite();
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
