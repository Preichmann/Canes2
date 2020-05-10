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
@WebServlet(name = "CheckOutPagamento", urlPatterns = {"/CheckOutPagamento"})
public class CheckOutPagamento extends HttpServlet {

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
        int idEntrega = (int) sessao.getAttribute("idEntrega");
        request.setAttribute("idEntrega", idEntrega);
        String metodoPagamento = request.getParameter("paymentMethod");
        if (metodoPagamento.equals("boleto")) {
            //Seguir para o fluxo com a confimaçao do pedido e mandar a informacao de metodo pela sessao.
            ArrayList<ItemPedido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
            Endereco_Entrega listaEndereco = new Controller.Controller_Cliente().getEntrega(idEntrega);
            if (listaItemPedido != null) {
                double subtotal = 0;
                for (ItemPedido item : listaItemPedido) {
                    subtotal = subtotal + item.getValorTotal();
                }
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
                request.setAttribute("listaItemPedido", listaItemPedido);
            } else {
                double subtotal = 0;
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
            }
            request.setAttribute("listaEndereco", listaEndereco);
            request.setAttribute("pagamento", "Boleto");
            sessao.setAttribute("pagamento", "Boleto");
            sessao.setAttribute("dadosBoleto", "Boleto");
            request.getRequestDispatcher("/WEB-INF/ValidarPedido.jsp")
                    .forward(request, response);
        } else {
            //salvar em um objeto do tipo cartao as informaçoes obtidas e mandar pora a tela de confirmaçao
            String nomeCartao = request.getParameter("cc-name");
            String numeroCartao = request.getParameter("cc-number");
            String vencimento = request.getParameter("cc-expiration");
            String cvv = request.getParameter("cc-cvv");
            String parcelas = request.getParameter("cc-parcelas");
            if (nomeCartao.isEmpty()) {
                request.setAttribute("msgName", true);
                request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp").forward(request, response);
            } else if (numeroCartao.isEmpty()) {
                request.setAttribute("msgNumCartao", true);
                request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp").forward(request, response);
            } else if (vencimento.isEmpty()) {
                request.setAttribute("msgVenci", true);
                request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp").forward(request, response);
            } else if (cvv.isEmpty()) {
                request.setAttribute("msgCVV", true);
                request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp").forward(request, response);
            } else if (parcelas == null) {
                request.setAttribute("msgParcelas", true);
                request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp").forward(request, response);
            } else {
                ArrayList<ItemPedido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
                Endereco_Entrega listaEndereco = new Controller.Controller_Cliente().getEntrega(idEntrega);
                int qtdParcelas = Integer.parseInt(parcelas);
                Cartao cartao = new Cartao(nomeCartao, numeroCartao, cvv, vencimento, qtdParcelas);
                if (listaItemPedido != null) {
                    double subtotal = 0;
                    for (ItemPedido item : listaItemPedido) {
                        subtotal = subtotal + item.getValorTotal();
                    }
                    subtotal = subtotal + 10;
                    request.setAttribute("SubTotal", subtotal);
                    request.setAttribute("listaItemPedido", listaItemPedido);
                } else {
                    double subtotal = 0;
                    subtotal = subtotal + 10;
                    request.setAttribute("SubTotal", subtotal);
                }
                request.setAttribute("listaEndereco", listaEndereco);
                sessao.setAttribute("dadosBoleto", "False");
                request.setAttribute("pagamento", "Cartão");
                sessao.setAttribute("pagamento", "Cartão");
                sessao.setAttribute("DadosCartao", cartao);
                request.getRequestDispatcher("/WEB-INF/ValidarPedido.jsp")
                        .forward(request, response);
            }
        }
    }

}
