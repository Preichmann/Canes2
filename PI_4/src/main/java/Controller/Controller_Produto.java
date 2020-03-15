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

    public int cadastrarProduto(Produto p, ArrayList<Resposta> Respostas, ArrayList<Objetivo> objetivos, ArrayList<Categorias> categoria) {
        int idProduto = 0;
        boolean salvarCategoria = false;
        boolean salvarImg = false;
        boolean salvarRespostas = false;
        boolean salvarObjetivos = false;

        idProduto = new DAO.DAO_Produto().daoSalvarProduto(p);
        if (idProduto == 0) {
            return 0;
        } else {
            for (Resposta r : Respostas) {
                salvarRespostas = new DAO.DAO_Produto().salvarRespostas(r, idProduto);
            }
            for (Objetivo o : objetivos) {
                salvarObjetivos = new DAO.DAO_Produto().salvarObjetivo(o.getIdObjetivo(), idProduto);
            }
            for (Categorias c : categoria) {
                salvarCategoria = new DAO.DAO_Produto().salvarCategorias(c.getIdCategoria(), idProduto);
            }
        }

        if (idProduto > 0 && salvarRespostas && salvarObjetivos && salvarCategoria) {
            return idProduto;
        } else {
            return 0;
        }
    }
    
    public boolean alterarProduto(Produto p, ArrayList<Resposta> Respostas, ArrayList<Objetivo> objetivos, ArrayList<Categorias> categoria) {
        boolean retorno = false;
        boolean salvarCategoria = false;
        boolean salvarImg = false;
        boolean salvarRespostas = false;
        boolean salvarObjetivos = false;
        boolean delObjetivos = false;
        boolean delCategoria = false;

        retorno = new DAO.DAO_Produto().daoAlterarProduto(p);
        
        if (retorno) {
            for (Resposta r : Respostas) {
                salvarRespostas = new DAO.DAO_Produto().alterarRespostas(r, p.getIdProd());
            }
            delObjetivos = new DAO.DAO_Produto().deletarObjetivos(p.getIdProd());
            for (Objetivo o : objetivos) {
                salvarObjetivos = new DAO.DAO_Produto().salvarObjetivo(o.getIdObjetivo(), p.getIdProd());
            }
            delObjetivos = new DAO.DAO_Produto().deletarCategorias(p.getIdProd());
            for (Categorias c : categoria) {
                salvarCategoria = new DAO.DAO_Produto().salvarCategorias(c.getIdCategoria(), p.getIdProd());
            }
        } else {
            return false;
        }

        if (retorno && salvarRespostas && salvarObjetivos && salvarCategoria) {
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

    public boolean SalvarImagem(String fileName, int idProd) {
        return new DAO.DAO_Produto().salvarImagem(fileName,idProd);
    }
    public boolean disableProduto(int idProd){
        return new DAO.DAO_Produto().disableProduto(idProd);
    }

}
