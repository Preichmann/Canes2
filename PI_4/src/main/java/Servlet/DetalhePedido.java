/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
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
 * @author nik_r
 */
@WebServlet(name = "DetalhePedido", urlPatterns = {"/DetalhePedido"})
public class DetalhePedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
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

        String pedidoId = request.getParameter("idPedido");
        int idPedido = Integer.parseInt(pedidoId);
        Pedido p = new Controller.ControllerItemPedido().getPedido(idPedido);
        request.setAttribute("numPedido", p.getIdPedido());
        request.setAttribute("horaAcesso", p.getHoraPedido());
        request.setAttribute("pagamento", p.getMetodoPagamento());
        request.setAttribute("SubTotal", p.getValorPedido());

        Endereco_Entrega listaEndereco = new Controller.Controller_Cliente().getEntrega(p.getIdEntrega());
        request.setAttribute("listaEndereco", listaEndereco);

        ArrayList<ItemPedidoVendido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedidoVenda(p.getIdPedido());
        request.setAttribute("listaItemPedido", listaItemPedido);

        request.getRequestDispatcher("/WEB-INF/DetalhePedido.jsp")
                .forward(request, response);
    }

}
