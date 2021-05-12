/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modele.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class GradeDAO {
     Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
  
     public static ArrayList<Grade> getGradeLibelle(Connection cnt){
        
        ArrayList<Grade> lesGrades = new ArrayList<Grade>();
        try
        {
            requete=cnt.prepareStatement("SELECT * FROM grade ");
            rs=requete.executeQuery();
            while(rs.next()){
                        Grade unGrade = new Grade();
                        unGrade.setId(rs.getInt("Gra_ID"));
                        unGrade.setLibelle(rs.getString("gra_libelle"));
                        
                        lesGrades.add(unGrade);
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(Exception e){
                System.out.println("Error " + e.getMessage());
        }
        
        return lesGrades;
    }
    
}
