/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Categorias;
import Classes.ImagemProduto;
import Classes.Objetivo;
import Classes.Pergunta;
import Classes.Produto;
import Classes.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class DAO_Produto {

    public int daoSalvarProduto(Produto produto) {
        int idProd = 0;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PRODUTO(NOME,DESCRICAO,STATUS,VALOR_UNIT,QUANTIDADE,FK_ID_USUARIO)\n"
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setString(2, produto.getDescricao());
            comandoSQL.setBoolean(3, produto.isStatus());
            comandoSQL.setDouble(4, produto.getPreco());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, 1);

            comandoSQL.executeUpdate();
            ResultSet getId = comandoSQL.getGeneratedKeys();
            while (getId.next()) {
                idProd = Integer.parseInt(getId.getString(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            idProd = 0;
        }
        return idProd;
    }

    public boolean salvarRespostas(Resposta r, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.RESPOSTA_PROD_PERG(RESPOSTA,FK_ID_PRODUTO,FK_ID_PERGUNTA)\n"
                    + "VALUES (?,?,?)");

            comandoSQL.setString(1, r.getResposta());
            comandoSQL.setInt(2, idProd);
            comandoSQL.setInt(3, r.getIdPergunta());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean salvarCategorias(ArrayList<Categorias> cate, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO CANESSUPLEMENTO.BENEFICIO(NOME,ID_PRODUTO)\n"
                    + "VALUES (?,?)");
            for (Categorias ben : cate) {
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

    public boolean salvarImgs(ArrayList<ImagemProduto> imagens, int idProd) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTO.IMAGEMPRODUTO(NOME,CAMINHO,STATUS,ID_PRODUTO)\n"
                    + "VALUES (?,?,?,?)");
            for (ImagemProduto img : imagens) {
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

    public ArrayList<Pergunta> getPergunta() {
        Conexao conec = new Conexao();
        ArrayList<Pergunta> listaPergunta = new ArrayList<Pergunta>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_PERGUNTA, PERGUNTA from SUPLEMENTOS.PERGUNTA;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pergunta p = new Pergunta();
                    p.setIdPergunta(rs.getInt("ID_PERGUNTA"));
                    p.setPergunta(rs.getString("PERGUNTA"));
                    listaPergunta.add(p);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaPergunta;
    }

    public ArrayList<Objetivo> getObjetivo() {
        Conexao conec = new Conexao();
        ArrayList<Objetivo> listaObjetivo = new ArrayList<Objetivo>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_OBJETIVO, NOME from SUPLEMENTOS.OBJETIVO;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Objetivo o = new Objetivo();
                    o.setIdObjetivo(rs.getInt("ID_OBJETIVO"));
                    o.setDescricaoObj(rs.getString("NOME"));
                    listaObjetivo.add(o);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaObjetivo;
    }

    public ArrayList<Categorias> getCategoria() {
        Conexao conec = new Conexao();
        ArrayList<Categorias> listaCategorias = new ArrayList<Categorias>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("select ID_CATEGORIA, NOME  from SUPLEMENTOS.CATEGORIA;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Categorias c = new Categorias();
                    c.setIdCategoria(rs.getInt("ID_CATEGORIA"));
                    c.setNome(rs.getString("NOME"));
                    listaCategorias.add(c);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaCategorias;
    }
}
