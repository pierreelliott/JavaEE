/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import modele.ConnexionBD;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Pierre-Elliott
 */
public class Carte implements Serializable {
    private ConnexionBD bdd;
    private ArrayList<Produit> produits;

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    
    
}
