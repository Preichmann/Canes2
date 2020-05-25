/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Funcionario;
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
 * @author Gabriel R Vital
 */
@WebServlet(name = "ListarPedidosEstoque", urlPatterns = {"/ListarPedidosEstoque"})
public class ListarPedidosEstoque extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/ListarPedidosEstoque.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        ArrayList<Pedido> listaPedidos = new Controller.ControllerItemPedido().getListaPedidosEstoque();
        Collections.reverse(listaPedidos);
        request.setAttribute("ListaPedidos", listaPedidos);
        request.getRequestDispatcher("/WEB-INF/ListarPedidosEstoque.jsp")
                .forward(request, response);

    }

}
