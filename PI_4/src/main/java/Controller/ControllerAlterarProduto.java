/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Produto;

/**
 *
 * @author nik_r
 */
public class ControllerAlterarProduto {

    public Produto getProduto(int idProd) {
        return new DAO.DAO_Produto().getProduto(idProd);
    }
}
