/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.Endereco_Fatura;
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
@WebServlet(name = "ListarDadosFaturamento", urlPatterns = {"/ListarDadosFaturamento"})
public class ListarDadosFaturamento extends HttpServlet {

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
        ArrayList<Endereco_Fatura> listaFatu = new Controller.Controller_Cliente().ListarFatura(c.getId_cliente());
        request.setAttribute("ListaFaturamento", listaFatu);

        request.getRequestDispatcher("/WEB-INF/ListarDadosFaturamento.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
