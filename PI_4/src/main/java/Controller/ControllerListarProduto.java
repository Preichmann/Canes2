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
        return new DAO.DAO_Produto().getProdutosTotal();
    }

    public ArrayList<Produto> getProdutosCliente() {
        return new DAO.DAO_Produto().getProdutosDisponiveis();
    }
    
    public ArrayList<Produto> getProdutosClientePerdaPeso() {
        return new DAO.DAO_Produto().getProdutosClientePerdaPeso();
    }

    public ArrayList<Produto> getProdutosClientePreTreino() {
        return new DAO.DAO_Produto().getProdutosClientePreTreino();
    }

    public ArrayList<Produto> getProdutosClienteGanharMassa() {
        return new DAO.DAO_Produto().getProdutosClienteGanharMassa();
    }

    public ArrayList<ImagemProduto> getImagens(int idProduto) {
        return new DAO.DAO_Produto().getImagem(idProduto);
    }

    public ArrayList<ImagemProduto> getImagensTotal() {
        return new DAO.DAO_Produto().getImagensTotal();
    }
}
