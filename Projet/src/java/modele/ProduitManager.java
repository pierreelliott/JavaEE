/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modele.beans.Produit;

/**
 *
 * @author Axel
 */
public class ProduitManager
{
    private ConnexionBD bdd;
    
    public boolean ajouterProduit(Produit produit)
    {
        Connection cnx = null;
        PreparedStatement ps = null;
        
        /*$resultat = $this->executerRequete('insert into image values(?, ?, ?)', array($sourcePetit, $sourceMoyen, $sourceGrand));
        $image = $this->executerRequete('select numImage from image where sourcePetit')*/
        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
        /* !!!!! Comment ajouter les images pour un produit (contraintes clefs étrangères) ? !!!!! */
        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */

        /* ===== J'ai une idée ===== */
        // À voir, parce que c'est très moche...
        //ArrayList<String> imagefactice = new ArrayList<>(produit.getLibelle() + "allo1", produit.getLibelle() + "allo2", produit.getLibelle() + "allo3");
        
        try
        {
            cnx = bdd.getConnexion();
            ps = cnx.prepareStatement("insert into image (sourcePetit, sourceMoyen, sourceGrand) values (?,?,?)");
            ps.setString(1, produit.getSourcePetit());
            ps.setString(2, produit.getSourceMoyen());
            ps.setString(3, produit.getSourceGrand());
        
            ps.executeUpdate();
            
            /*$image = $this->executerRequete('insert into image (sourcePetit, sourceMoyen, sourceGrand) values (?,?,?)', $imagefactice);
            $image = $this->executerRequete('select numImage from image where sourcePetit = ? and sourceMoyen = ? and sourceGrand = ?', $imagefactice);
            $numImage = $image->fetch();*/


            //Si le produit est gratuit (Contrainte)
            if(produit.getPrix() == 0.f)
            {
                // On considère qu'on a le $numImage
                ps = cnx.prepareStatement("insert into produit (libelle,description,typeProduit,prix,numImage) values(?,?,?,?,?)");
                ps.setString(1, produit.getLibelle());
                ps.setString(2, produit.getDescription());
                ps.setString(3, produit.getTypeProduit());
                ps.setFloat(4, produit.getPrix());
                ps.setInt(1, 0);
                /*$resultat = $this->executerRequete('insert into produit (libelle,description,typeProduit,prix,numImage)
                                                    values (?,?,?,?,?)', array($libelle, $description, $typeProduit, $prix, $numImage));*/
            }

            /*if($compatibilite == null) // Je sais plus du tout à quoi ça sert....
            {

            }*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }
}
