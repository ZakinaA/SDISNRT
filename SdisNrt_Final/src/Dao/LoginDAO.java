/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modele.Caserne;
import Modele.Compte;
import Modele.Grade;
import Modele.Pompier;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ts1sio
 */
public class LoginDAO {
    Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    public static Compte getLogin(Connection cnt ,String user , String pass){
        
        try{
           
         
           requete =cnt.prepareStatement("SELECT * FROM compte c, pompier p,grade g,caserne ca \n"
                   + "WHERE c.pom_id=p.pom_id \n"
                   + "AND p.gra_id=g.gra_id\n"
                   + "AND p.cas_id=ca.cas_id\n"
                   + "AND com_nom=?"
                   + "AND com_mdp=?");
           Compte unCompte = new Compte();
           requete.setString(1,user);
           requete.setString(2,pass);  
            
           rs=requete.executeQuery();
           
              if(rs.next()){
                  
                unCompte.setNom(rs.getString("COM_NOM")) ;
                unCompte.setMdp(rs.getString("COM_MDP"));
                unCompte.setRole(rs.getString("COM_ROLE"));
                
                
                
                
                Pompier unPompier= new Pompier();
                unPompier.setId(rs.getInt("pom_id"));
                unPompier.setNom(rs.getString("POM_NOM"));
                unPompier.setPrenom(rs.getString("POM_PRENOM"));
                unPompier.setSexe(rs.getString("POM_SEXE"));
                unPompier.setDteNaissance(rs.getString("POM_dtNaissance"));
                unPompier.setTel(rs.getString("POM_TEL"));
                unPompier.setMatricule(rs.getString("POM_MAT"));
                unPompier.setBip(rs.getString("pom_numBip"));
                
                Grade unGrade = new Grade();
                unGrade.setId(rs.getInt("gra_id"));
                unGrade.setLibelle(rs.getString("gra_libelle"));
                
                Caserne uneCaserne =new Caserne();
                uneCaserne.setNomCas(rs.getString("cas_nom"));
                
                unPompier.setUneCaserne(uneCaserne);
                unPompier.setUnGrade(unGrade);
                unCompte.setUnPompier(unPompier);
                
                
                return unCompte ;
              }
           
           else{
               return null;
              
        
        
        }
                } catch(Exception e){
                e.printStackTrace();
                return null ;
                        }
        
        
    }
}
