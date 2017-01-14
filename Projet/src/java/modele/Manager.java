/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.beans.*;

/**
 *
 * @author Axel
 */
public class Manager
{
    private Connection bdd;
    private DBLien lien;
    
    public Manager() {
        bdd = MariaDBDriverManager.creerConnexion();
        lien = new DBLien();
    }
    
    /* ###################################################################### */
    /* ============================= Carte ================================== */
    
    public Carte recupererCarte() throws SQLException
    {
        ResultSet resultat;
        String requete = "select numProduit, libelle, description, prix, image from produit";
        
        List<Produit> carte = new ArrayList<>();
        
        resultat = lien.getLien(bdd).executeQuery(requete);
        while(resultat.next())
        {
            int numProduit = resultat.getInt("numProduit");
            String libelle = resultat.getString("libelle");
            String description = resultat.getString("description");
            int prix = resultat.getInt("prix");
            String image = resultat.getString("image");
            
            Produit prod = new Produit();
            
            prod.setNumProduit(numProduit);
            prod.setLibelle(libelle);
            prod.setDescription(description);
            prod.setPrix(prix);
            prod.setImage(image);
            
            carte.add(prod);
        }
        
        Carte c = new Carte();
        c.setProduits(carte);

        return c;
    }
    
    /* ###################################################################### */
    /* ========================== Utilisateur =============================== */
    
    public boolean existe(String pseudo) throws SQLException {
        ResultSet resultat;
        String requete = "select numUser from utilisateur where pseudo = "+pseudo;
        resultat = lien.getLien(bdd).executeQuery(requete);
        
        return resultat.next();
    }
    
    public boolean inscription(String pseudo, String mdp, String nom, String prenom, String mail, String tel, int numRue, String rue, String ville, String codePostal) throws SQLException
    {
        String requete;
        if(existe(pseudo))
        {
            return false;
        }
        else
        {
            requete = "insert into utilisateur(pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, typeUser, dateInscription)"+
                        "values("+pseudo+", "+mdp+", "+nom+", "+prenom+", "+mail+", "+tel+", "+numRue+", "+rue+", "+ville+", "+codePostal+", 'USER', CURDATE())";
            lien.getLien(bdd).executeUpdate(requete);
            
            return true;
        }
    }
    
    public Utilisateur connexion(String pseudo, String mdp) throws SQLException
    {
        ResultSet res;
        String requete = "select numUser, pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, dateInscription from utilisateur where pseudo = "+pseudo+" and mdp = "+mdp;
        
        res = lien.getLien(bdd).executeQuery(requete);
        
        while(res.next())
        {
            int numUser = res.getInt("numUser");
            String nom = res.getString("nom");
            String prenom = res.getString("prenom");
            String mail = res.getString("mail");
            String tel = res.getString("telephone");
            int numRue = res.getInt("numRue");
            String rue = getChamp(res.getString("rue"));
            String ville = getChamp(res.getString("ville"));
            String codePostal = getChamp(res.getString("codePostal"));
            
            Utilisateur user = new Utilisateur();
            user.setCodePostal(codePostal);
            user.setMail(mail);
            user.setNom(nom);
            user.setNumRue(numRue);
            user.setNumUser(numUser);
            user.setPrenom(prenom);
            user.setPseudo(pseudo);
            user.setRue(rue);
            user.setTelephone(tel);
            user.setVille(ville);
            
            return user;
        }
        
        return null;
    }
    
    /* ###################################################################### */
    /* ============================ Commande ================================ */
    
    public void ajouterCommande(Commande commande)
    {
        
    }
    
    public void recupererCommandes(String pseudo) throws SQLException
    {
        ResultSet resultat;
        String requete = "select numCommande, numUser, typeCommande, numRue, rue, ville, codePostal, date from commande";
        
        List<Produit> commandes = new ArrayList<>();
        
        resultat = lien.getLien(bdd).executeQuery(requete);
        while(resultat.next())
        {
            int numProduit = resultat.getInt("numProduit");
            String libelle = resultat.getString("libelle");
            String description = resultat.getString("description");
            int prix = resultat.getInt("prix");
            String image = resultat.getString("image");
            
            Produit prod = new Produit();
            
            prod.setNumProduit(numProduit);
            prod.setLibelle(libelle);
            prod.setDescription(description);
            prod.setPrix(prix);
            prod.setImage(image);
            
            carte.add(prod);
        }
        
        Carte c = new Carte();
        c.setProduits(carte);
    }
    
    /* ########################### Méthodes statiques ################################ */
    
    private static String getChamp( String nomChamp ) {
        String valeur = nomChamp;
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
