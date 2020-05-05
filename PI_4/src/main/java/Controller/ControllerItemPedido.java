package Controller;

import Classes.ItemPedido;
import java.util.ArrayList;

public class ControllerItemPedido {

    public ItemPedido validarRepeticao(int idProd) {
        return new DAO.DAO_Carrinho().validarRepeticao(idProd);
    }

    public boolean adicionarItem(ItemPedido item) {
        return new DAO.DAO_Carrinho().adicionarItem(item);
    }

    public ArrayList<ItemPedido> getListaItemPedido(int idCliente) {
        return new DAO.DAO_Carrinho().getListaItemPedido(idCliente);
    }
}
