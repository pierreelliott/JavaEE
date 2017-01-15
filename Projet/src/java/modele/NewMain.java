/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.beans.Utilisateur;

/**
 *
 * @author Pierre-Elliott
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager man = new Manager();
        String pseudo = "gmenvu";
        String mdp = "1234";
        Utilisateur user;
        DBLien lien = new DBLien();
        Connection bdd = MariaDBDriverManager.creerConnexion();
        Statement stat;

        try {
            System.out.println("Connexion");
            user = man.connexion(pseudo, mdp);
        } catch (SQLException ex) {
            System.out.println("Erreur connexion");
            user = null;
        }

        System.out.println("User : " + user);
        
        ResultSet res;
        String requete = "select numUser, pseudo, mdp, nom, prenom, mail, telephone, numRue, rue, ville, codePostal, dateInscription from utilisateur where pseudo like "+pseudo+" and mdp like "+mdp;
        
        stat = lien.getLien(bdd);
        try {
            res = stat.executeQuery(requete);
        } catch (SQLException ex) {
            System.out.println("Erreur requete");
        }
    }
    
}
