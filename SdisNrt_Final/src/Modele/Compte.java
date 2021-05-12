/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 * @author Dylan Aumond
 * dte debut: 10/03/2021
 * dte last modif: 10/03/2021
 * classe objet compte
 */
public class Compte {
    private String id;
    private String nom;
    private String mdp;
    private String role;
    private Pompier unPompier;

    public Compte() {
    }

    public Compte(String id, String nom ,String mdp, String role) {
        this.id = id;
        
        this.nom=nom ;
        this.mdp = mdp;
        this.role=role ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Pompier getUnPompier() {
        return unPompier;
    }

    public void setUnPompier(Pompier unPompier) {
        this.unPompier = unPompier;
    }
    
    
    
}
