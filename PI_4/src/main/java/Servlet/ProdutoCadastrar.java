/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Categorias;
import Classes.Funcionario;
import Classes.Objetivo;
import Classes.Pergunta;
import Classes.Produto;
import Classes.Resposta;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import Classes.Upload;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.rvital
 */
@WebServlet(name = "ProdutoCadastrar", urlPatterns = {"/ProdutoCadastrar"})
public class ProdutoCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
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
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        ArrayList<Objetivo> listaObjetivo = new Controller.Controller_Produto().getObjetivo();
        ArrayList<Categorias> listaCategoria = new Controller.Controller_Produto().getCategoria();
        ArrayList<Resposta> Resposta = new ArrayList<>();
        ArrayList<Objetivo> Objetivos = new ArrayList<>();
        ArrayList<Categorias> Categoria = new ArrayList<>();
        boolean validador = false;

        request.setCharacterEncoding("UTF-8");
        String produtoNom = request.getParameter("produtoNome");
        String produtoPreco = request.getParameter("produtoValorUnitario");
        String produtoDesc = request.getParameter("produtoDescricao");
        String quantidadeStr = request.getParameter("produtoQuantidadeEstoque");
        String produtoDisp = request.getParameter("produtoDisponivel");

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

        Produto P = new Produto(produtoNom, precoProduto, produtoDesc, quantidadeProduto, validador);
        int result = new Controller.Controller_Produto().cadastrarProduto(P, Resposta, Objetivos, Categoria);
        if (result == 0) {
            request.setAttribute("resultAtt", false);
            request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("resultAtt", result);
            request.getRequestDispatcher("/WEB-INF/SalvarImagemProd.jsp")
                    .forward(request, response);
        }

    }

}
