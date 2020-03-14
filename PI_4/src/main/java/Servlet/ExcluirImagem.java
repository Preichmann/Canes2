/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.ImagemProduto;
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
 * @author gabriel.rvital
 */
@WebServlet(name = "ExcluirImagem", urlPatterns = {"/ExcluirImagem"})
public class ExcluirImagem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProd = request.getParameter("resultAtt");
        int prodId = Integer.parseInt(idProd);
        ArrayList<ImagemProduto> imagens = new Controller.ControllerListarProduto().getImagens(prodId);
        request.setAttribute("listaImagensAtt", imagens);
        request.setAttribute("resultAtt", prodId);

        request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameImagem = request.getParameter("nomeImg");
        String idImagem = request.getParameter("idImagem");
        String idProd = request.getParameter("idProd");
        int idproduto = Integer.parseInt(idProd);
        request.setAttribute("resultAtt", idproduto);
        int idimagem = Integer.parseInt(idImagem);
        boolean retorno = new Controller.ControllerAlterarProduto().excluirImagem(nameImagem, idimagem);
        request.getRequestDispatcher("/WEB-INF/AlterarImagemProd.jsp")
                .forward(request, response);
    }
}
