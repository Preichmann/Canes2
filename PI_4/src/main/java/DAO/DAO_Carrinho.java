package DAO;

import Classes.ItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Carrinho {

    public boolean adicionarItem(ItemPedido item) {
        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ITEM_PEDIDO (ID_PRODUTO,QUANTIDADE,VALOR_UNITARIO,VALOR_TOTAL,NOME_PRODUTO,ID_CLIENTE) \n"
                    + "VALUES (?,?,?,?,?,?);");

            comandoSQL.setInt(1, item.getIdProduto());
            comandoSQL.setInt(2, item.getQuantidade());
            comandoSQL.setDouble(3, item.getValorUnitario());
            comandoSQL.setDouble(4, item.getValorTotal());
            comandoSQL.setString(5, item.getNomeProduto());
            comandoSQL.setInt(6, item.getIdCliente());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return retorno;
    }

    public ArrayList<ItemPedido> getListaItemPedido(int idCliente) {
        ArrayList<ItemPedido> listaItemPedido = new ArrayList<>();
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ITEM_PEDIDO WHERE ITEM_PEDIDO.ID_CLIENTE = ?;");

            comandoSQL.setInt(1, idCliente);
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ItemPedido item = new ItemPedido();
                    item.setIdItemPedido(rs.getInt("ID_ITEM_PEDIDO"));
                    item.setIdProduto(rs.getInt("ID_PRODUTO"));
                    item.setQuantidade(rs.getInt("QUANTIDADE"));
                    item.setValorUnitario(rs.getDouble("VALOR_UNITARIO"));
                    item.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    item.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    item.setIdCliente(rs.getInt("ID_CLIENTE"));
                    listaItemPedido.add(item);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaItemPedido;
    }

    public ItemPedido validarRepeticao(int idProd) {
        Conexao conec = new Conexao();
        ItemPedido item = new ItemPedido();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ITEM_PEDIDO WHERE ID_ITEM_PEDIDO = ?");

            comandoSQL.setInt(1, idProd);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    item.setIdItemPedido(rs.getInt("ID_ITEM_PEDIDO"));
                    item.setIdProduto(rs.getInt("ID_PRODUTO"));
                    item.setQuantidade(rs.getInt("QUANTIDADE"));
                    item.setValorUnitario(rs.getDouble("VALOR_UNITARIO"));
                    item.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    item.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    item.setIdCliente(rs.getInt("ID_CLIENTE"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return item;
    }

    public boolean atualizarQuantidade(ItemPedido item) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ITEM_PEDIDO SET QUANTIDADE = ? WHERE ITEM_PEDIDO.ID_PRODUTO = ?;");

            comandoSQL.setInt(1, item.getQuantidade());
            comandoSQL.setInt(2, item.getIdProduto());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean diminuirQuantidade(ItemPedido item) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM SUPLEMENTOS.ITEM_PEDIDO WHERE ITEM_PEDIDO.ID_ITEM_PEDIDO = ?;");

            comandoSQL.setInt(1, item.getIdItemPedido());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
}
