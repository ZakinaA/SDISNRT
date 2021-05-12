/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.PompierDAO.requete;
import Modele.Caserne;
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
public class CaserneDAO {
    Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    public static ArrayList<Caserne> getCaserneNom(Connection cnt){
        
        ArrayList<Caserne> lesCasernes = new ArrayList<Caserne>();
        try
        {
            requete=cnt.prepareStatement("SELECT * FROM caserne ");
            rs=requete.executeQuery();
            while(rs.next()){
                        Caserne uneCaserne = new Caserne();
                        uneCaserne.setIdcas(rs.getInt("CAS_ID"));
                        uneCaserne.setNomCas(rs.getString("CAS_NOM"));
                        
                        lesCasernes.add(uneCaserne);
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(Exception e){
                System.out.println("Error " + e.getMessage());
        }
        
        return lesCasernes;
    }
    
    public static Caserne afficheInfo(Connection cnt , String list){
        Caserne uneCaserne= new Caserne();
        try{
            requete=cnt.prepareStatement("SELECT * FROM caserne WHERE CAS_NOm=? ");
            requete.setString(1, list);
            rs=requete.executeQuery();
            if(rs.next()){
               uneCaserne.setIdcas(rs.getInt("cas_id"));
               uneCaserne.setNomCas(rs.getString("cas_nom"));
               uneCaserne.setVilleCas(rs.getString("cas_ville"));
               uneCaserne.setCpCas(rs.getInt("cas_cp"));
               uneCaserne.setRueCas(rs.getString("cas_adrRue"));
               
                
              
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return uneCaserne;
       
        
        }
}
