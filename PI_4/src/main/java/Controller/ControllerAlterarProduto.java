/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Categorias;
import Classes.ImagemProduto;
import Classes.Objetivo;
import Classes.Produto;
import Classes.Resposta;
import Classes.Upload;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class ControllerAlterarProduto {

    public Produto getProduto(int idProd) {
        return new DAO.DAO_Produto().getProduto(idProd);
    }

    public ArrayList<Resposta> getRespostasProduto(int idProd) {
        return new DAO.DAO_Produto().getRespostas(idProd);
    }

    public ArrayList<Categorias> getCategoriasProduto(int idProd) {
        return new DAO.DAO_Produto().getCategoriaProduto(idProd);
    }

    public ArrayList<Objetivo> getObjetivoProduto(int idProd) {
        return new DAO.DAO_Produto().getObjetivoProduto(idProd);
    }

    public String getImagemName(int idProd) {
        ArrayList<ImagemProduto> imagens = new DAO.DAO_Produto().getImagem(idProd);
        String LastName = null;
        for (ImagemProduto img : imagens) {
            LastName = new DAO.DAO_Produto().getImagemLastName(img.getIdImg());
        }
        return LastName;
    }

    public boolean excluirImagem(String nomeImg, int idImg) {
        Upload delete = new Upload();
        delete.deleteFile(nomeImg);
        return new DAO.DAO_Produto().excluirImagem(idImg);
    }
}
