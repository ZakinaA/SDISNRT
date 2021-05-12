/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modele.Engin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class EnginDAO {
    Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    //get engins' list 
    public static ArrayList<Engin> getAllEngin(Connection cnt){
        ArrayList<Engin> lesEngins = new ArrayList<Engin>();
        try
        {
            requete=cnt.prepareStatement("SELECT * FROM engin,type_engin WHERE engin.typ_engId=type_engin.typEng_id");
            rs=requete.executeQuery();
            while(rs.next()){
                        Engin unEngin = new Engin();
                        unEngin.setLibelle(rs.getString("typEng_libelle"));
                        
                        lesEngins.add(unEngin);
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(Exception e){
                System.out.println("Error " + e.getMessage());
        }
        
        return lesEngins;
    }
    
}
