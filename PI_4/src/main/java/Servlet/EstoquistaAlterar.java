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

/**
 *
 * @author nik_r
 */
@WebServlet(name = "EstoquistaAlterar", urlPatterns = {"/EstoquistaAlterar"})
public class EstoquistaAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        String produtoId = request.getParameter("idProd");
        String quantidade = request.getParameter("quantidade");
        int idProd = Integer.parseInt(produtoId);
        int qtd = Integer.parseInt(quantidade);
        boolean retorno = new Controller.ControllerAlterarProduto().AlterarQtd(idProd, qtd);
        request.setAttribute("retornoAtt", retorno);
        ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutosCliente();
        request.setAttribute("ListaProdAtt", listaProd);
        request.getRequestDispatcher("/WEB-INF/ProdutoListarEstoquista.jsp")
                .forward(request, response);
    }

}
