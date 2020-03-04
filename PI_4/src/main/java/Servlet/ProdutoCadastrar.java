/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Categorias;
import Classes.Objetivo;
import Classes.Pergunta;
import Classes.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.rvital
 */
@WebServlet(name = "ProdutoCadastrar", urlPatterns = {"/ProdutoCadastrar"})
public class ProdutoCadastrar extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        ArrayList<Objetivo> listaObjetivo = new Controller.Controller_Produto().getObjetivo();
        ArrayList<Categorias> listaCategoria = new Controller.Controller_Produto().getCategoria();
        
        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        request.setAttribute("ListaObjetivoAtt", listaObjetivo);
        request.setAttribute("ListaCategoriaAtt", listaCategoria);
        
        request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                .forward(request, response);
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String produtoNom = request.getParameter("produtoNome");
        String produtoPreco = request.getParameter("produtoValorUnitario");
        String produtoDesc = request.getParameter("produtoDescricao");
        String quantidadeStr = request.getParameter("produtoQuantidadeEstoque");
        String produtoDisp = request.getParameter("produtoDisponivel");
        
        double precoProduto = Double.parseDouble(produtoPreco);
        int quantidadeProduto = Integer.parseInt(quantidadeStr);
        boolean validador = Boolean.parseBoolean(produtoDisp);
        
        Produto P = new Produto(produtoNom, precoProduto, produtoDesc, quantidadeProduto, validador);
         request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                .forward(request, response);
    }

}
