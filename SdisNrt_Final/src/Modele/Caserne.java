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
 * classe objet Caserne
 */
public class Caserne {
    private Integer idcas ;
    private String nomCas;
    private String rueCas;
    private String villeCas;
    private Integer cpCas;
    
    
    public Caserne(){
    }
    
    public Caserne(Integer idcas ,String nomCas, String rueCas, String villeCas, Integer cpCas) {
        this.nomCas = nomCas;
        this.rueCas = rueCas;
        this.villeCas = villeCas;
        this.cpCas = cpCas;
    }

    public Integer getIdcas() {
        return idcas;
    }

    public void setIdcas(Integer idcas) {
        this.idcas = idcas;
    }

    
    public String getNomCas() {
        return nomCas;
    }

    public void setNomCas(String nomCas) {
        this.nomCas = nomCas;
    }

    public String getRueCas() {
        return rueCas;
    }

    public void setRueCas(String rueCas) {
        this.rueCas = rueCas;
    }

    public String getVilleCas() {
        return villeCas;
    }

    public void setVilleCas(String villeCas) {
        this.villeCas = villeCas;
    }

    public Integer getCpCas() {
        return cpCas;
    }

    public void setCpCas(Integer cpCas) {
        this.cpCas = cpCas;
    }
    
}
