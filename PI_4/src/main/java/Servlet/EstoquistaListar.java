/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import Classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EstoquistaListar", urlPatterns = {"/EstoquistaListar"})
public class EstoquistaListar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutosCliente();
        request.setAttribute("ListaProdAtt", listaProd);
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        request.getRequestDispatcher("/WEB-INF/ProdutoListarEstoquista.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        String produtoId = request.getParameter("idProd");
        int idProd = Integer.parseInt(produtoId);
        Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
        request.setAttribute("ProdutoAtt", p);
        
        request.getRequestDispatcher("/WEB-INF/EstoquistaAlterar.jsp")
                .forward(request, response);

    }

}
