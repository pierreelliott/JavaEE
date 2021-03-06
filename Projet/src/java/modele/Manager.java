/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String requete = "select numUser from utilisateur where pseudo = '"+pseudo+"'";
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
                        "values('"+pseudo+"', '"+mdp+"', '"+nom+"', '"+prenom+"', '"+mail+"', '"+tel+"', "+numRue+", '"+rue+"', '"+ville+"', '"+codePostal+"', 'USER', CURRENT_DATE)";
            lien.getLien(bdd).executeUpdate(requete);
            
            return true;
        }
    }
    
    public boolean inscription(String pseudo, String mdp, String nom, String prenom, String mail, String tel) throws SQLException
    {
        String requete;
        if(existe(pseudo))
        {
            return false;
        }
        else
        {
            requete = "insert into utilisateur(pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, typeUser, dateInscription)"+
                        "values('"+pseudo+"', '"+mdp+"', '"+nom+"', '"+prenom+"', '"+mail+"', '"+tel+"', null, null, null, null, 'USER', CURRENT_DATE)";
            lien.getLien(bdd).executeUpdate(requete);
            
            return true;
        }
    }
    
    public Utilisateur connexion(String pseudo, String mdp) throws SQLException
    {
        ResultSet res;
        String requete = "select numUser, pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, dateInscription from utilisateur where pseudo like '"+pseudo+"' and mdp like '"+mdp+"'";
        
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
            Date dt = res.getTimestamp("dateInscription");
            String dateInscription = "";
            if( dt != null)
                dateInscription = DateFormat.getDateInstance( DateFormat.MEDIUM ).format(dt);
            
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
            user.setDateInscription(dateInscription);
            
            return user;
        }
        
        return null;
    }
    
    /* ###################################################################### */
    /* ============================ Commande ================================ */
    
    public int recupMaxNumCommande() throws SQLException {
        ResultSet resultat;
        resultat = lien.getLien(bdd).executeQuery("select Max(numCommande) comm from commande");
        while(resultat.next()) {
            return resultat.getInt("comm");
        }
        return 0;
    }
    
    public void ajouterCommande(Commande comm, Utilisateur user) throws SQLException
    {
        String requete;
        if(user.getCodePostal() != null || user.getRue() != null || user.getVille() != null || user.getNumRue() != 0)
        {
            System.out.println("Allo11");
            requete = "insert into commande(numUser, typeCommande, numRue, rue, ville, codePostal, date)"+
                "values("+user.getNumUser()+"'À emporter', "+comm.getNumRue()+", '"+comm.getRue()+"', '"+comm.getVille()+"', '"+comm.getCodePostal()+"', CURRENT_DATE)";
        }
        else {
            System.out.println("Allo12");
            requete = "insert into commande(numUser, typeCommande, numRue, rue, ville, codePostal, date)"+
                "values("+user.getNumUser()+",'À emporter', null, null, null, null, CURRENT_DATE)";
        }
        lien.getLien(bdd).executeUpdate(requete);
        System.out.println("Allo13");
        for(Produit p : comm.getProduits())
        {
            System.out.println(p+" : "+comm.getNumCommande()+" / "+p.getNumProduit()+" / "+p.getQuantite());
            requete = "insert into QUANTITEPRODUIT (numCommande, numProduit, quantite) values("+comm.getNumCommande()+","+p.getNumProduit()+","+p.getQuantite()+")";
            lien.getLien(bdd).executeUpdate(requete);
        }
        System.out.println("Allo14");
    }
    
    public void recupererCommandes(Utilisateur user) throws SQLException
    {
        ResultSet resultat;
        String requete = "select numCommande, typeCommande, numRue, rue, ville, codePostal, date from commande where numUser = "+user.getNumUser();
        List<Commande> commandes = new ArrayList<>();
        resultat = lien.getLien(bdd).executeQuery(requete);
        while(resultat.next())
        {
            int numCommande = resultat.getInt("numCommande");
            String typeCommande = resultat.getString("typeCommande");
            String rue = resultat.getString("rue");
            int numRue = resultat.getInt("numRue");
            String ville = resultat.getString("ville");
            String codePostal = resultat.getString("codePostal");
            
            Commande comm = new Commande();
            comm.setNumCommande(numCommande);
            comm.setTypeCommande(typeCommande);
            comm.setNumRue(numRue);
            comm.setRue(rue);
            comm.setVille(ville);
            comm.setCodePostal(codePostal);
            
            commandes.add(comm);
        }
        //user.setCommandes(commandes);
        List<Commande> comms = new ArrayList<>();
        Carte carte = recupererCarte();
        for(Commande tmp : commandes)
        {
            ArrayList<Produit> produits = new ArrayList<>();
            int nbProduits = 0;
            
            requete = "select numProduit, quantite from quantiteProduit where numCommande = "+tmp.getNumCommande();
            resultat = lien.getLien(bdd).executeQuery(requete);
            while(resultat.next())
            {
                int numProduit = resultat.getInt("numProduit");
                int quantite = resultat.getInt("quantite");
                nbProduits += quantite;
                
                Produit prod = carte.getProduit(numProduit);
                prod.setQuantite(quantite);
                produits.add(prod);
            }
            tmp.setProduits(produits);
            tmp.setNbProduits(nbProduits);
            comms.add(tmp);
        }
        user.setCommandes(comms);
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
