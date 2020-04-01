/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Produto;
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
@WebServlet(name = "ProdutoExcluir", urlPatterns = {"/ProdutoExcluir"})
public class ProdutoExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String confirmaExclusao = request.getParameter("idConfirma");
        int idConfirma = Integer.parseInt(confirmaExclusao);
        String prodId = request.getParameter("idProd");
        int idProd = Integer.parseInt(prodId);
        
        if (idConfirma == 1) {
            boolean retorno = new Controller.Controller_Produto().disableProduto(idProd);
            ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutos();
            request.setAttribute("ListaProdAtt", listaProd);

            request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                    .forward(request, response);
        }
    }
}
