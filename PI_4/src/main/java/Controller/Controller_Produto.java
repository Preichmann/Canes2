/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Categorias;
import Classes.ImagemProduto;
import Classes.Objetivo;
import Classes.Pergunta;
import Classes.Produto;
import Classes.Resposta;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Vital
 */
public class Controller_Produto {

    public boolean cadastrarProduto(Produto p, ArrayList<Resposta> Respostas) {
        int idProduto = 0;
        boolean salvarCategoria = false;
        boolean salvarImg = false;
        boolean salvarRespostas = false;

        idProduto = new DAO.DAO_Produto().daoSalvarProduto(p);
        if (idProduto == 0) {
            return false;
        } else {
            for (Resposta r : Respostas) {
                salvarRespostas = new DAO.DAO_Produto().salvarRespostas(r, idProduto);
            }
        }

        /**
         * '' salvarCategoria = new
         * DAO.DAO_Produto().salvarCategorias(Categorias, idProd1); salvarImg =
         * new DAO.DAO_Produto().salvarImgs(imagens, idProd1);
         *
         *
         */
        if (salvarRespostas && idProduto > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Pergunta> getPergunta() {
        return new DAO.DAO_Produto().getPergunta();
    }

    public ArrayList<Objetivo> getObjetivo() {
        return new DAO.DAO_Produto().getObjetivo();
    }

    public ArrayList<Categorias> getCategoria() {
        return new DAO.DAO_Produto().getCategoria();
    }

}
