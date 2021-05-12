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
 * classe objet Engin
 */
public class Engin {
    private Integer id;
    private String libelle;
    private String numOrdre;

    public Engin(Integer id, String libelle, String numOrdre) {
        this.id = id;
        this.libelle = libelle;
        this.numOrdre = numOrdre;
    }
    
    public Engin(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(String numOrdre) {
        this.numOrdre = numOrdre;
    }
    
    
}
