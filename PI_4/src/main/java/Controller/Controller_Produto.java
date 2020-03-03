/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Categorias;
import Classes.ImagemProduto;
import Classes.Produto;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Vital
 */
public class Controller_Produto {
    public boolean cadastrarProduto(int idProd, String nome, double preco, String descricao, int quantidade, boolean status, ArrayList<Categorias> befenicios, int idObjetivo, String descricaoObj,ArrayList<ImagemProduto> imagens){
        boolean salvaProd = false;
        boolean salvarBene = false;
        boolean salvarImg = false;
        
        Produto produto = new Produto(idProd, nome, preco, descricao, quantidade, status);
        
        salvaProd = new DAO.DAO_Produto().daoSalvarProduto(produto);
        int idProd1 =  new DAO.DAO_Produto().UltimoID();
        salvarBene = new DAO.DAO_Produto().salvarBeneficios(befenicios, idProd1);
        salvarImg = new DAO.DAO_Produto().salvarImgs(imagens,idProd1);
        if(salvaProd && salvarBene && salvarImg){
            return true;
        }else{
            return false;
        }
    }
}
