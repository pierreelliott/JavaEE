/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.beans;

/**
 *
 * @author Axel
 */
import java.io.Serializable;
import java.sql.*;

// Je crois que l'objet Connnection n'est pas serializable (à voir)
public class Modele implements Serializable {
//Définitiondespropriétés

    private String login;
    private String password;
    private String hostname;
    private String port;
    private String nomDeLaBase;
    private Connection cnx;
//Methodes d'accès en écriture
//Enregistre le nom de login

    public void setLogin(String valeur) {
        login = valeur;
    }

//Enregistrelemotdepasse
    public void setPassword(String valeur) {
        password = valeur;
    }

//EnregistrelenomduHost
    public void setHostname(String valeur) {
        hostname = valeur;
    }

//Enregistrelenumérodeport
    public void setPort(String valeur) {
        port = valeur;
    }
//Enregistrelenomdelabasededonnées

    public void setNomDeLaBase(String valeur) {
        nomDeLaBase = valeur;
    }
//Methodesd'accesenlecture

    public Connection getCnx() {
        if (etablirConnexion()) {
            return cnx;
        } else {
            return null;
        }
    }
//Méthodesinvisibles(métier)
//Construitl'URL

    private String construireUrlJdbc() {
        String urlJdbc;
        urlJdbc = "jdbc:mysql://" + hostname + ":" + port + "/" + nomDeLaBase;
        urlJdbc = urlJdbc + "?user=" + login + "&password=" + password;
        return urlJdbc;
    }
}
