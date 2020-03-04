/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Pergunta;
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
        
        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        
        request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                .forward(request, response);
     //*   RequestDispatcher dispatcher
                //= request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp");
 //       dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        
        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        
         request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                .forward(request, response);
    }

}
