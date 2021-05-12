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
 * classe objet Intervention
 */
public class Intervention {
    private Integer id;
    private String date;
    private String Happel;
    private String Harrivée;
    private String durée;
    private String adresse;
    private String ville;
    private String cp;
    private String desc;
    
    public Intervention(){
    }

    public Intervention(Integer id, String date, String Happel, String Harrivée, String durée, String adresse, String ville, String cp) {
        this.id = id;
        this.date = date;
        this.Happel = Happel;
        this.Harrivée = Harrivée;
        this.durée = durée;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.desc = desc;
    }
    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHappel() {
        return Happel;
    }

    public void setHappel(String Happel) {
        this.Happel = Happel;
    }

    public String getHarrivée() {
        return Harrivée;
    }

    public void setHarrivée(String Harrivée) {
        this.Harrivée = Harrivée;
    }

    public String getDurée() {
        return durée;
    }

    public void setDurée(String durée) {
        this.durée = durée;
    }
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
