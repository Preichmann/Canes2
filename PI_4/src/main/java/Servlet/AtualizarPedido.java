/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.Funcionario;
import Classes.ItemPedidoVendido;
import Classes.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
@WebServlet(name = "AtualizarPedido", urlPatterns = {"/AtualizarPedido"})
public class AtualizarPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        String pedidoId = request.getParameter("idPedido");
        int idPedido = Integer.parseInt(pedidoId);
        Pedido p = new Controller.ControllerItemPedido().getPedido(idPedido);
        request.setAttribute("numPedido", p.getIdPedido());
        request.setAttribute("horaAcesso", p.getHoraPedido());
        request.setAttribute("pagamento", p.getMetodoPagamento());
        request.setAttribute("SubTotal", p.getValorPedido());
        if (p.getStatus().equals("Aguardando Pagamento")) {
            request.setAttribute("status", "Aguardando Pagamento");
        } else if (p.getStatus().equals("Pagamento Rejeitado")) {
            request.setAttribute("status", "Pagamento Rejeitado");
        } else if (p.getStatus().equals("Pagamento com sucesso")) {
            request.setAttribute("status", "Pagamento com sucesso");
        } else if (p.getStatus().equals("Aguardando Retirada")) {
            request.setAttribute("status", "Aguardando Retirada");
        } else if (p.getStatus().equals("Em Transito")) {
            request.setAttribute("status", "Em Transito");
        } else if (p.getStatus().equals("Entregue")) {
            request.setAttribute("status", "Entregue");
        }

        Endereco_Entrega listaEndereco = new Controller.Controller_Cliente().getEntrega(p.getIdEntrega());
        request.setAttribute("listaEndereco", listaEndereco);

        ArrayList<ItemPedidoVendido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedidoVenda(p.getIdPedido());
        request.setAttribute("listaItemPedido", listaItemPedido);

        request.getRequestDispatcher("/WEB-INF/AtualizarPedido.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        String pedidoId = request.getParameter("idPedido");
        int idPedido = Integer.parseInt(pedidoId);
        String status = request.getParameter("Status");
        String StatusAtt = null;
        switch (status) {
            case "Aguardando Pagamento":
                StatusAtt = "Aguardando Pagamento";
                break;
            case "Pagamento Rejeitado":
                StatusAtt = "Pagamento Rejeitado";
                break;
            case "Pagamento com sucesso":
                StatusAtt = "Pagamento com sucesso";
                break;
            case "Aguardando Retirada":
                StatusAtt = "Aguardando Retirada";
                break;
            case "Em Transito":
                StatusAtt = "Em Transito";
                break;
            case "Entregue":
                StatusAtt = "Entregue";
                break;
            default:
                break;
        }
        boolean result = new Controller.ControllerItemPedido().alterarPedido(idPedido, StatusAtt);
        request.setAttribute("result", result);
        ArrayList<Pedido> listaPedidos = new Controller.ControllerItemPedido().getListaPedidosEstoque();
        Collections.reverse(listaPedidos);
        request.setAttribute("ListaPedidos", listaPedidos);
        request.getRequestDispatcher("/WEB-INF/ListarPedidosEstoque.jsp")
                .forward(request, response);
    }

}
