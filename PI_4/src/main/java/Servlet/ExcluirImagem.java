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

        request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aux = request.getParameter("aux");
        int auxiliar = Integer.parseInt(aux);
        String idProd = request.getParameter("idProd"+auxiliar);
        String idImg = request.getParameter("idImagem"+auxiliar);
        String nomeImg = request.getParameter("nomeImg"+auxiliar);
        int idProduto = Integer.parseInt(idProd);
        int idimagem = Integer.parseInt(idImg);
        boolean retorno = new Controller.ControllerAlterarProduto().excluirImagem(nomeImg,idimagem);
        request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                .forward(request, response);
    }
}
