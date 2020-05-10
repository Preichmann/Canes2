/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cartao;
import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.ItemPedido;
import Classes.ItemPedidoVendido;
import Classes.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel Ribeiro Vital
 */
@WebServlet(name = "ValidarPedido", urlPatterns = {"/ValidarPedido"})
public class ValidarPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        int idEntrega = (int) sessao.getAttribute("idEntrega");
        ArrayList<ItemPedido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
        Endereco_Entrega listaEndereco = new Controller.Controller_Cliente().getEntrega(idEntrega);
        String pagamento = (String) sessao.getAttribute("pagamento");
        Pedido p = new Pedido(c.getId_cliente(), idEntrega, pagamento, "Aguardando Pagamento");
        if (!pagamento.isEmpty()) {
            int idPedido = new Controller.ControllerItemPedido().salvarPedido(p);
            if (idPedido != 0) {
                //pedido salvo com sucesso
                for (ItemPedido item : listaItemPedido) {
                    ItemPedidoVendido i = new ItemPedidoVendido(item.getIdItemPedido(), item.getIdProduto(), item.getQuantidade(), item.getValorUnitario(),
                            item.getValorTotal(), item.getNomeProduto(), item.getIdCliente(), idPedido);
                    boolean result = new Controller.ControllerItemPedido().AtrelarItemsAoPedido(i);
                    if (!result) {
                        request.setAttribute("msgFimCompra", false);
                        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                                .forward(request, response);
                    } else {
                        request.setAttribute("msgFimCompra", true);
                        request.setAttribute("numPedido", idPedido);
                        ArrayList<ItemPedidoVendido> listaItensVenda = new Controller.ControllerItemPedido().getListaItemPedidoVenda(idPedido);
                        double valorTotal = 0;
                        for (ItemPedidoVendido it : listaItensVenda) {
                            valorTotal = valorTotal + it.getValorTotal();
                        }
                        request.setAttribute("valorTotal", valorTotal);
                        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                                .forward(request, response);
                    }
                }
            }
        }
    }
}
