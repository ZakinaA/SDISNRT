/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.LoginDAO.rs;
import Modele.Caserne;
import Modele.Fonction;
import Modele.Grade;
import Modele.Intervention;
import Modele.Pompier;
import java.sql.Array;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Donatien 
 */



//sélectionne un pompier en fonction de son ID : 
public class PompierDAO {
    Connection cnt=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static Pompier getPompierbyId(Connection cnt, int id) {
        Pompier unPompier = new Pompier();
        try
        {
            requete=cnt.prepareStatement("SELECT * FROM `pompier` WHERE `pom_id`=?");
            requete.setInt(1, id);
            rs=requete.executeQuery();
            if(rs.next()){
                unPompier.setMatricule(rs.getString("pom_mat"));
                unPompier.setNom(rs.getString("pom_nom"));
                unPompier.setPrenom(rs.getString("pom_prenom"));
                
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return unPompier;
        
    }
   
    
    //sélectionne une liste de pompier grâce aux ID et aux noms :    
    public static ArrayList<Pompier> getPompierByIdEtNom(Connection cnt){
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        try
        {
            requete=cnt.prepareStatement("SELECT * FROM pompier ");
            rs=requete.executeQuery();
            while(rs.next()){
                        Pompier unPompier = new Pompier();
                        unPompier.setNom(rs.getString("POM_NOM"));
                       // unPompier.setId(rs.getInt("POM_ID"));
                        
                        lesPompiers.add(unPompier);
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(Exception e){
                System.out.println("Error " + e.getMessage());
        }
        
        return lesPompiers;
    }
    
    
    //sélectionne un pompier en fonction de son nom :
    public static Pompier getPompierbyNom(Connection cnt) {
        Pompier unPompier = new Pompier();
        
        try{
            requete=cnt.prepareStatement("SELECT POM_NOM FROM `pompier`");
            
            rs=requete.executeQuery();
            
            while(rs.next()){
               
                unPompier.setNom(rs.getString("pom_nom"));
                
                
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return unPompier;
        
    }
    
  
   
    
    //Ajoute un nouveau pompier 
     public static int addPompier(Connection cnt, Pompier p){
         int resultatUpdate= -1;
         try{
             requete=cnt.prepareStatement("INSERT INTO pompier(pom_respId, pom_nom, pom_prenom, pom_sexe, pom_dtNaissance, pom_tel, pom_mat,pom_numBip,gra_id,cas_id )VALUES ('1',?,?,?,?,?,?,?,?,? )");
             System.out.println("req=" + requete);
            
            requete.setString(1,p.getNom());
            requete.setString(2,p.getPrenom());
            requete.setString(3,p.getSexe());
            requete.setString(4,p.getDteNaissance());
            requete.setString(5,p.getTel());
            requete.setString(6,p.getMatricule());
            requete.setString(7,p.getBip());
            requete.setInt(8, p.getUnGrade().getId());
            requete.setInt(9, p.getUneCaserne().getIdcas());
            

           
            resultatUpdate = requete.executeUpdate();  
            
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultatUpdate;
        
    }
        
    //Affiche les informations d'un pompier :
    public static Pompier afficheInfo(Connection cnt , String list){
        Pompier unPompier= new Pompier();
        try{
            requete=cnt.prepareStatement("SELECT * FROM pompier,grade,caserne WHERE POM_NOM=? ");
            requete.setString(1, list);
            rs=requete.executeQuery();
            if(rs.next()){
                unPompier.setNom(rs.getString("POM_NOM"));
                unPompier.setPrenom(rs.getString("POM_PRENOM"));
                unPompier.setSexe(rs.getString("POM_SEXE"));
                unPompier.setDteNaissance(rs.getString("POM_dtNaissance"));
                unPompier.setTel(rs.getString("POM_TEL"));
                unPompier.setMatricule(rs.getString("POM_MAT"));
                unPompier.setBip(rs.getString("pom_numBip"));
                
                Grade unGrade = new Grade();
                unGrade.setLibelle(rs.getString("gra_libelle"));
                
                Caserne uneCaserne =new Caserne();
                uneCaserne.setNomCas(rs.getString("cas_nom"));
                
                unPompier.setUneCaserne(uneCaserne);
                unPompier.setUnGrade(unGrade);
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return unPompier;
       
        
        }
        
       private static ArrayList<Intervention> ArrayList;
      
    
    
    public static ArrayList<Intervention> getMesInterventions(Connection cnt, int idPompier){
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        try{
            requete=cnt.prepareStatement("SELECT * FROM pompier p, intervention i , type_intervention t  WHERE p.pom_id=i.pom_id AND i.typ_id=t.typ_id AND p.pom_id=?");
            requete.setInt(1, idPompier);
            rs=requete.executeQuery();
            while(rs.next()){
                
                Intervention uneIntervention = new Intervention();
                uneIntervention.setVille(rs.getString("int_ville"));
                uneIntervention.setAdresse(rs.getString("int_adr"));
                uneIntervention.setCp(rs.getString("int_cp"));
                uneIntervention.setDate(rs.getString("int_date"));
                uneIntervention.setHappel(rs.getString("int_heureAppel"));
                uneIntervention.setHarrivée(rs.getString("int_heureArrivee"));
                uneIntervention.setHarrivée(rs.getString("int_heureArrivee"));
                uneIntervention.setDurée(rs.getString("int_duree"));
                
                lesInterventions.add(uneIntervention);
                
            }
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return lesInterventions;
        
    }
        
    /*
    
    
    
    
    
                int resultatUpdate = BD.UpdateQuery("INSERT INTO pompier(pom_respId, pom_nom, pom_prenom, pom_sexe, pom_dtNaissance, pom_tel, pom_mat,pom_numBip,gra_id,cas_id,pom_fonc )VALUES (?,?,?,?,?,?,?,?,?,?,? )");

    public static PompierDAO updatePompier(String prenom, String date, String nom,String bip){
       
        try{
            ConnexionBdd BD= new ConnexionBdd();
            int resultatUpdate = BD.UpdateQuery("UPDATE pompier SET POM_PRENOM='"+prenom+"', POM_DTNAISSANCE='"+date+"',POM_NUMBIP='"+bip+"'WHERE POM_NOM='"+nom+"' ");
            if (resultatUpdate == -1){
                 ListePompier liste =new ListePompier();
                 JOptionPane.showMessageDialog(liste,"Modification échoué !");
                
            }
            else if(resultatUpdate == 1){
                ListePompier liste =new ListePompier();            
                JOptionPane.showMessageDialog(liste,"Modification reussie !");
            }
        }
           
       
        catch(Exception e){
             System.out.println("Error " + e.getMessage());
        }
        return null;
    
    
    }  
    
    
    
    public static PompierDAO deletePompier(String list){
    
    try{
            ConnexionBdd BD= new ConnexionBdd();
            int resultatUpdate = BD.UpdateQuery("DELETE FROM pompier WHERE POM_NOM='"+list+"' ");
            if (resultatUpdate == -1){
                ListePompier liste =new ListePompier();            
                JOptionPane.showMessageDialog(liste,"Suppresion échoué !");
                
            }
            else if(resultatUpdate == 1){
                 ListePompier liste =new ListePompier();
                 JOptionPane.showMessageDialog(liste,"Suppresion reussie !");
            }
                 
           
       }
        catch(Exception e){
             System.out.println("Error " + e.getMessage());
        }
     return null;
    }
 */   
}
    