/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Categorias;
import Classes.Objetivo;
import Classes.Produto;
import Classes.Resposta;
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
}
