/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author nik_r
 */
public class ImagemProduto {
    private int idImg;
    private String nome;
    private String caminho;
    private int idProd;
    private boolean status;

    public ImagemProduto(int idImg, String nome, String caminho, int idProd, boolean status) {
        this.idImg = idImg;
        this.nome = nome;
        this.caminho = caminho;
        this.idProd = idProd;
        this.status = status;
    }

    public ImagemProduto() {

    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
