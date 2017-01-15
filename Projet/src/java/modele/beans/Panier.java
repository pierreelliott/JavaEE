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

    private Map<Produit,Integer> produits;
    private List<Produit> prods;

    public List<Produit> getProds() {
        return prods;
    }

    public void setProds(List<Produit> prods) {
        this.prods = prods;
    }

    public Map<Produit,Integer> getProduits() {
        return produits;
    }

    public void setProduits(Map<Produit,Integer> produits) {
        this.produits = produits;
        
        this.prods = new ArrayList<>();
        for(Produit p : produits.keySet()) {
            prods.add(p);
        }
    }

    public void addProduit(Produit p, int qte) {
        produits.put(p,qte);
        prods.add(p);
    }
    
    public void modifProduit(Produit p, int qte) {
        produits.replace(p, qte);
    }

    public boolean removeProduit(Produit p) {
        return (produits.remove(p) != 0);
    }

    public Produit getProduit(int numProduit) {
        for (Produit tmp : produits.keySet()) {
            if (tmp.getNumProduit() == numProduit) {
                return tmp;
            }
        }
        return null;
    }
    
    public Produit getProduit(Produit p) {
        for (Produit tmp : produits.keySet()) {
            if (tmp.equals(p)) {
                return tmp;
            }
        }
        return null;
    }
}
