/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Classe na quale
 * @author Gabriel Ribeiro Vital
 */
public class Objetivo {
    private int idObjetivo;
    private String descricaoObj;

    public Objetivo() {
    }

    public Objetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Objetivo(int idObjetivo, String descricaoObj) {
        this.idObjetivo = idObjetivo;
        this.descricaoObj = descricaoObj;
    }

    public int getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getDescricaoObj() {
        return descricaoObj;
    }

    public void setDescricaoObj(String descricaoObj) {
        this.descricaoObj = descricaoObj;
    }
}
