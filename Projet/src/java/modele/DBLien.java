/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.sql.*;

public class DBLien implements Serializable {
//Définition des propriétés

    private Statement lien = null;
//Methodes d'acces en lecture

    public Statement getLien(Connection cnx) {
        if (construireStatement(cnx)) {
            return lien;
        } else {
            return null;
        }
    }
//Methodes invisibles

    private boolean construireStatement(Connection cnx) {
        boolean statusStatement = false;
        try {
            lien = cnx.createStatement();
            statusStatement = true;
        } catch (Exception e) {
            statusStatement = false;
            System.out.println(e);
        }
        return statusStatement;
    }
}
