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
import Classes.Resposta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nik_r
 */
@WebServlet(name = "ProdutoListar", urlPatterns = {"/ProdutoListar"})
public class ProdutoListar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutos();
        request.setAttribute("ListaProdAtt", listaProd);

        request.getRequestDispatcher("/WEB-INF/ListaProdutoAlterar.jsp")
                .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProd = request.getParameter("idProd");
        int idProduto = Integer.parseInt(idProd);
        Produto p = new Controller.ControllerAlterarProduto().getProduto(idProduto);
        ArrayList<Resposta> listaResposta = new Controller.ControllerAlterarProduto().getRespostasProduto(idProduto);
        ArrayList<Categorias> listaCategoriaa = new Controller.ControllerAlterarProduto().getCategoriasProduto(idProduto);
        ArrayList<Objetivo> listaObjetivoa = new Controller.ControllerAlterarProduto().getObjetivoProduto(idProduto);

        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        ArrayList<Objetivo> listaObjetivo = new Controller.Controller_Produto().getObjetivo();
        ArrayList<Categorias> listaCategoria = new Controller.Controller_Produto().getCategoria();

        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        request.setAttribute("listaObjetivoAtt", listaObjetivo);
        request.setAttribute("listaCategoriaAtt", listaCategoria);
        request.setAttribute("idProdAtt", idProduto);
        request.setAttribute("ProdutoAtt", p);

        request.setAttribute("ListaRespostaAtt", listaResposta);
        request.setAttribute("ListaCategoriasAtt", listaCategoria);
        request.setAttribute("ListaObjetivoAtt", listaObjetivo);

        request.getRequestDispatcher("/WEB-INF/ProdutoAlterar.jsp")
                .forward(request, response);

    }

}
