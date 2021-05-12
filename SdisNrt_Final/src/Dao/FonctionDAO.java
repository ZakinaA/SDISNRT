/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.PompierDAO.requete;
import Modele.Fonction;
import Modele.Pompier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class FonctionDAO {
      //Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
     public static ArrayList<Fonction> getLesFoncs(Connection cnt, int id){
        
        
         ArrayList<Fonction> lesFonctions = new ArrayList<Fonction>();
        
       
        
         try{
            requete=cnt.prepareStatement("SELECT * FROM  fonction f,pompier p,occuper o WHERE p.pom_id=o.pom_id AND o.fonc_code=f.fonc_code AND p.pom_id=? ");
            
            requete.setInt(1, id);
            System.out.println(requete);
            rs=requete.executeQuery();

            while(rs.next()){
                    Fonction unefonction = new Fonction();

              unefonction.setLibelle(rs.getString("fonc_libelle"));   
 
              lesFonctions.add(unefonction);
            }
                   
               
             
        
                     
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return lesFonctions;
        
    }
    
    
}


