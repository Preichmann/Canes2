package DAO;

import Classes.ItemPedido;
import Classes.ItemPedidoVendido;
import Classes.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Carrinho {

    public boolean AtrelarItemVendido(ItemPedidoVendido item) {
        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ITEM_PEDIDO_VENDIDO (ID_PRODUTO,QUANTIDADE,VALOR_UNITARIO,VALOR_TOTAL,NOME_PRODUTO,ID_CLIENTE,ID_PEDIDO) \n"
                    + "VALUES (?,?,?,?,?,?,?);");

            comandoSQL.setInt(1, item.getIdProduto());
            comandoSQL.setInt(2, item.getQuantidade());
            comandoSQL.setDouble(3, item.getValorUnitario());
            comandoSQL.setDouble(4, item.getValorTotal());
            comandoSQL.setString(5, item.getNomeProduto());
            comandoSQL.setInt(6, item.getIdCliente());
            comandoSQL.setInt(7, item.getIdPedido());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return retorno;
    }

    public int salvarPedido(Pedido p) {
        int idPedido = 0;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.PEDIDO(ID_PEDIDO,ID_CLIENTE,ID_ENTREGA,METODO_PAGAMENTO,STATUS,DATA_DE_COMPRA,VALOR_TOTAL)\n"
                    + "VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setInt(1, p.getIdPedido());
            comandoSQL.setInt(2, p.getIdCliente());
            comandoSQL.setInt(3, p.getIdEntrega());
            comandoSQL.setString(4, p.getMetodoPagamento());
            comandoSQL.setString(5, p.getStatus());
            comandoSQL.setString(6, p.getHoraPedido());
            comandoSQL.setDouble(7, p.getValorPedido());

            comandoSQL.executeUpdate();
            ResultSet getId = comandoSQL.getGeneratedKeys();
            while (getId.next()) {
                idPedido = Integer.parseInt(getId.getString(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            idPedido = 0;
        }
        return idPedido;
    }

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

    public ArrayList<ItemPedidoVendido> getListaItemPedidoVendidos(int idPedido) {
        ArrayList<ItemPedidoVendido> listaItemPedido = new ArrayList<>();
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ITEM_PEDIDO_VENDIDO WHERE ITEM_PEDIDO_VENDIDO.ID_PEDIDO = ?;");

            comandoSQL.setInt(1, idPedido);
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ItemPedidoVendido item = new ItemPedidoVendido();
                    item.setIdItemPedido(rs.getInt("ID_ITEM_PEDIDO"));
                    item.setIdProduto(rs.getInt("ID_PRODUTO"));
                    item.setQuantidade(rs.getInt("QUANTIDADE"));
                    item.setValorUnitario(rs.getDouble("VALOR_UNITARIO"));
                    item.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    item.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    item.setIdCliente(rs.getInt("ID_CLIENTE"));
                    item.setIdPedido(rs.getInt("ID_PEDIDO"));
                    listaItemPedido.add(item);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaItemPedido;
    }

    public ArrayList<Pedido> getListaPedidos(int idCliente) {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.PEDIDO WHERE PEDIDO.ID_CLIENTE = ?;");

            comandoSQL.setInt(1, idCliente);
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pedido p = new Pedido();
                    p.setIdPedido(rs.getInt("ID_PEDIDO"));
                    p.setIdCliente(rs.getInt("ID_CLIENTE"));
                    p.setIdEntrega(rs.getInt("ID_ENTREGA"));
                    p.setMetodoPagamento(rs.getString("METODO_PAGAMENTO"));
                    p.setStatus(rs.getString("STATUS"));
                    p.setHoraPedido(rs.getString("DATA_DE_COMPRA"));
                    p.setValorPedido(rs.getDouble("VALOR_TOTAL"));
                    listaPedidos.add(p);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaPedidos;
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

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ITEM_PEDIDO SET QUANTIDADE = ?, VALOR_TOTAL = ? WHERE ITEM_PEDIDO.ID_PRODUTO = ?;");

            comandoSQL.setInt(1, item.getQuantidade());
            comandoSQL.setDouble(2, item.getValorTotal());
            comandoSQL.setInt(3, item.getIdProduto());

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

    public boolean excluirItem(ItemPedidoVendido item) {
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
