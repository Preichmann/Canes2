/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.ImagemProduto;
import Classes.Produto;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class ControllerListarProduto {

    public ArrayList<Produto> getProdutos() {
        return new DAO.DAO_Produto().getProdutos();
    }
    
    public ArrayList<ImagemProduto> getImagens(int idProduto) {
        return new DAO.DAO_Produto().getImagem(idProduto);
    }
}
