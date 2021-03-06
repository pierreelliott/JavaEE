/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pierre-Elliott
 */
public class Utilisateur implements Serializable {
    private int numUser;
    
    private String nom;
    private String prenom;
    private String mail;
    private String pseudo;
    private String telephone;
    private String dateInscription;
    
    private int numRue;
    private String rue;
    private String ville;
    private String codePostal;
    
    private List<Commande> commandes;

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }
    
    public void addCommande(Commande commande) {
        if(this.commandes == null)
            this.commandes = new ArrayList<>();
        this.commandes.add(commande);
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}