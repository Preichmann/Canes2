package Controller;

import Classes.ItemPedido;
import Classes.ItemPedidoVendido;
import Classes.Pedido;
import Classes.Produto;
import java.util.ArrayList;

public class ControllerItemPedido {

    public boolean alterarPedido(int idPedido, String status) {
       return new DAO.DAO_Carrinho().AtualizarStatus(idPedido,status);
    }

    public ItemPedido validarRepeticao(int idProd) {
        return new DAO.DAO_Carrinho().validarRepeticao(idProd);
    }

    public boolean adicionarItem(ItemPedido item) {
        return new DAO.DAO_Carrinho().adicionarItem(item);
    }

    public Pedido getPedido(int idPedido) {
        return new DAO.DAO_Carrinho().getPedido(idPedido);
    }

    public ArrayList<ItemPedido> getListaItemPedido(int idCliente) {
        return new DAO.DAO_Carrinho().getListaItemPedido(idCliente);
    }

    public ArrayList<ItemPedidoVendido> getListaItemPedidoVenda(int idPedido) {
        return new DAO.DAO_Carrinho().getListaItemPedidoVendidos(idPedido);
    }

    public ArrayList<Pedido> getListaPedidos(int idCliente) {
        return new DAO.DAO_Carrinho().getListaPedidos(idCliente);
    }

    public ArrayList<Pedido> getListaPedidosEstoque() {
        return new DAO.DAO_Carrinho().getListaPedidosEstoque();
    }

    public void atualizarQuantidade(ItemPedido item) {
        new DAO.DAO_Carrinho().atualizarQuantidade(item);
    }

    public void diminuirQuantidade(ItemPedido item) {
        new DAO.DAO_Carrinho().diminuirQuantidade(item);

    }

    public int salvarPedido(Pedido p) {
        return new DAO.DAO_Carrinho().salvarPedido(p);
    }

    public boolean AtrelarItemsAoPedido(ItemPedidoVendido i) {
        boolean atrelar = new DAO.DAO_Carrinho().AtrelarItemVendido(i);
        if (atrelar) {
            Produto p = new Controller.ControllerAlterarProduto().getProduto(i.getIdProduto());
            p.setQuantidade(p.getQuantidade() - i.getQuantidade());
            boolean atualizarEstoque = new Controller.ControllerAlterarProduto().AlterarQtd(p.getIdProd(), p.getQuantidade());
            if (atualizarEstoque) {
                boolean AtualizarLista = new Controller.ControllerItemPedido().excluirItem(i);
                if (AtualizarLista) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean excluirItem(ItemPedidoVendido i) {
        return new DAO.DAO_Carrinho().excluirItem(i);
    }
}
