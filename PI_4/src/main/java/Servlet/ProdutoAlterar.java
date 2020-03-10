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
@WebServlet(name = "ProdutoAlterar", urlPatterns = {"/ProdutoAlterar"})
public class ProdutoAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProd = request.getParameter("idProd");
        int idProduto = Integer.parseInt(idProd);
        Produto p = new Controller.ControllerAlterarProduto().getProduto(idProduto);
        ArrayList<Resposta> listaResposta = new Controller.ControllerAlterarProduto().getRespostasProduto(idProduto);
        ArrayList<Categorias> listaCategoria = new Controller.ControllerAlterarProduto().getCategoriasProduto(idProduto);
        ArrayList<Objetivo> listaObjetivo = new Controller.ControllerAlterarProduto().getObjetivoProduto(idProduto);

        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        ArrayList<Objetivo> listaObjetivoTotal = new Controller.Controller_Produto().getObjetivo();
        ArrayList<Categorias> listaCategoriaTotal = new Controller.Controller_Produto().getCategoria();

        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        request.setAttribute("listaObjetivoAtt", listaObjetivoTotal);
        request.setAttribute("listaCategoriaAtt", listaCategoriaTotal);
        request.setAttribute("idProdAtt", idProduto);
        request.setAttribute("ProdutoAtt", p);
        request.getRequestDispatcher("/WEB-INF/ProdutoAlterar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        ArrayList<Objetivo> listaObjetivo = new Controller.Controller_Produto().getObjetivo();
        ArrayList<Categorias> listaCategoria = new Controller.Controller_Produto().getCategoria();
        ArrayList<Resposta> Resposta = new ArrayList<>();
        ArrayList<Objetivo> Objetivos = new ArrayList<>();
        ArrayList<Categorias> Categoria = new ArrayList<>();
        boolean validador = false;

        request.setCharacterEncoding("UTF-8");
        String produtoId = request.getParameter("idProd");
        String produtoNom = request.getParameter("produtoNome");
        String produtoPreco = request.getParameter("produtoValorUnitario");
        String produtoDesc = request.getParameter("produtoDescricao");
        String quantidadeStr = request.getParameter("produtoQuantidadeEstoque");
        String produtoDisp = request.getParameter("produtoDisponivel");
        int prodId = Integer.parseInt(produtoId);
        
        int counterPergunta = 0;
        for (Pergunta p : listaPergunta) {
            String resp = request.getParameter("resposta" + counterPergunta);
            String idPergunta = request.getParameter("idPergunta" + counterPergunta);
            int idPer = Integer.parseInt(idPergunta);
            Resposta r = new Resposta(resp, idPer);
            Resposta.add(r);
            counterPergunta++;
        }

        int counterObjetivo = 0;
        for (Objetivo o : listaObjetivo) {
            String objetivo = request.getParameter("Objetivo" + counterObjetivo);
            if (objetivo == null) {
            } else {
                String idObj = request.getParameter("idObjetivo" + counterObjetivo);
                int idObjetivo = Integer.parseInt(idObj);
                Objetivo obj = new Objetivo(idObjetivo);
                Objetivos.add(obj);
            }
            counterObjetivo++;
        }

        int counterCategoria = 0;
        for (Categorias c : listaCategoria) {
            String categoria = request.getParameter("Categoria" + counterCategoria);
            if (categoria == null) {
            } else {
                String idCate = request.getParameter("idCategoria" + counterCategoria);
                int idCategoria = Integer.parseInt(idCate);
                Categorias cat = new Categorias(idCategoria);
                Categoria.add(cat);
            }
            counterCategoria++;
        }

        double precoProduto = Double.parseDouble(produtoPreco);
        int quantidadeProduto = Integer.parseInt(quantidadeStr);
        if (produtoDisp == null) {
            validador = false;
        } else {
            validador = true;
        }

        Produto P = new Produto(prodId, produtoNom, precoProduto, produtoDesc, quantidadeProduto, validador);
        boolean result = new Controller.Controller_Produto().alterarProduto(P, Resposta, Objetivos, Categoria);
        if (result) {
            request.setAttribute("resultAtt", result);
            request.getRequestDispatcher("/WEB-INF/AlterarImagemProd.jsp")
                    .forward(request, response);
        }else{
            request.setAttribute("resul2Att", false);
            request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                    .forward(request, response);
        }
        
    	
    }

}
