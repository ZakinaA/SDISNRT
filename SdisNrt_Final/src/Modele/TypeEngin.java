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
 * classe objet TypeEngin
 */
public class TypeEngin {
    private Integer id;
    private String typeLibelle;
    
    public TypeEngin(){
    }

    public TypeEngin(Integer id, String typeLibelle) {
        this.id = id;
        this.typeLibelle = typeLibelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeLibelle() {
        return typeLibelle;
    }

    public void setTypeLibelle(String typeLibelle) {
        this.typeLibelle = typeLibelle;
    }
    
    
}
