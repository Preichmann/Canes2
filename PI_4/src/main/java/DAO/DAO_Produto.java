/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Beneficios;
import Classes.ImagemProduto;
import Classes.Produto;
import Controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class DAO_Produto {

    public boolean daoSalvarProduto(Produto produto) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO CANESSUPLEMENTO.PRODUTO(NOME,DESCRICAO,STATUS,VALOR_UNIT,QUANTIDADE)\n"
                    + "VALUES (?,?,?,?,?)");

            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setString(2, produto.getDescricao());
            comandoSQL.setBoolean(3, produto.isStatus());
            comandoSQL.setDouble(4, produto.getPreco());
            comandoSQL.setInt(5, produto.getQuantidade());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean salvarBeneficios(ArrayList<Beneficios> bene, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO CANESSUPLEMENTO.BENEFICIO(NOME,ID_PRODUTO)\n"
                    + "VALUES (?,?)");
            for(Beneficios ben : bene){
            comandoSQL.setString(1, ben.getNome());
            comandoSQL.setInt(2, idProd);
            }

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public int UltimoID() {
        int idProd = 0;
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select max(ID_PRODUTO) from CANESSUPLEMENTO.PRODUTO;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                idProd = rs.getInt("ID_PRODUTO");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            idProd = 0;
            ex.printStackTrace();
        }
        return idProd;
    }
    
    public boolean salvarImgs(ArrayList<ImagemProduto> imagens,int idProd){
         boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO CANESSUPLEMENTO.IMAGEMPRODUTO(NOME,CAMINHO,STATUS,ID_PRODUTO)\n"
                    + "VALUES (?,?,?,?)");
            for(ImagemProduto img : imagens){
            comandoSQL.setString(1, img.getNome());
            comandoSQL.setString(2, img.getCaminho());
            comandoSQL.setBoolean(3, img.isStatus());
            comandoSQL.setInt(4, idProd);
            }

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
}
