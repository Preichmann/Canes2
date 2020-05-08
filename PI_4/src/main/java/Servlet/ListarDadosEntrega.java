/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarDadosEntrega", urlPatterns = {"/ListarDadosEntrega"})
public class ListarDadosEntrega extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        request.setAttribute("idCliente", c.getId_cliente());
        ArrayList<Endereco_Entrega> listaEndereco = new Controller.Controller_Cliente().ListarEntrega(c.getId_cliente());
        request.setAttribute("ListaEntrega", listaEndereco);

        request.getRequestDispatcher("/WEB-INF/ListarDadosEntrega.jsp")
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
        String Entrega = request.getParameter("idEntrega");
        int idEntrega = Integer.parseInt(Entrega);
        
        request.setAttribute("idEntrega", idEntrega);

        request.getRequestDispatcher("/WEB-INF/CheckOutPagamento.jsp")
                .forward(request, response);
    }
}
