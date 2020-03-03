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
    private int idProd;

    public Objetivo(int idObjetivo, String descricaoObj, int idProd) {
        this.idObjetivo = idObjetivo;
        this.descricaoObj = descricaoObj;
        this.idProd = idProd;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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
