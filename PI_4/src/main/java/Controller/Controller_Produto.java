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

    public boolean cadastrarProduto(Produto p, ArrayList<Resposta> Respostas, ArrayList<Categorias> Categoria) {
        boolean salvaProd = false;
        boolean salvarCategoria = false;
        boolean salvarImg = false;
        boolean salvarRespostas = false;

        salvaProd = new DAO.DAO_Produto().daoSalvarProduto(p);
        int idProd1 = new DAO.DAO_Produto().UltimoID();
        salvarRespostas = new DAO.DAO_Produto().salvarRespostas(Respostas,idProd1);
        /**''
         * salvarCategoria = new DAO.DAO_Produto().salvarCategorias(Categorias,
         * idProd1); salvarImg = new DAO.DAO_Produto().salvarImgs(imagens,
         * idProd1);
         *
         *
         */
        if (salvarRespostas) {
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
