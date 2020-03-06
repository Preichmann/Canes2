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
        request.getRequestDispatcher("/WEB-INF/ListaProdutoAlterar.jsp")
                .forward(request, response);

    }

}
