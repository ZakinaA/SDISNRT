/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 * @author Dylan Aumond
 * dte debut: 10/03/2021
 * dte last modif: 10/03/2021
 * classe objet pompier
 */
public class Pompier {
    private String nom;
    private String prenom;
    private String dteNaissance;
    private String matricule;
    private String bip;
    private int id;
    private String sexe;
    private String tel;
    private Grade unGrade;
    private Caserne uneCaserne;
    private ArrayList<Fonction> lesFonctions ;
    
    public Pompier(){
    }
    
    public Pompier(String nom, String prenom, String dteNaissance, String matricule, String bip, int id, String sexe,String tel ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dteNaissance = dteNaissance;
        this.matricule = matricule;
        this.bip = bip;
        this.id = id;
        this.sexe=sexe;
        this.tel=tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDteNaissance() {
        return dteNaissance;
    }

    public void setDteNaissance(String dteNaissance) {
        this.dteNaissance = dteNaissance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getBip() {
        return bip;
    }

    public void setBip(String bip) {
        this.bip = bip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Grade getUnGrade() {
        return unGrade;
    }

    public void setUnGrade(Grade unGrade) {
        this.unGrade = unGrade;
    }

    public Caserne getUneCaserne() {
        return uneCaserne;
    }

    public void setUneCaserne(Caserne uneCaserne) {
        this.uneCaserne = uneCaserne;
    }
    
    
    
public ArrayList<Fonction> getLesFonctions() {
 return lesFonctions;
 }
 public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
 this.lesFonctions = lesFonctions;
 }
 
 public void addUnSalarie(Fonction pUneFonction){
 if (lesFonctions == null){
 lesFonctions = new ArrayList<Fonction>();
 }
 lesFonctions.add(pUneFonction);
 }
   
}
