/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioCadastrar", urlPatterns = {"/FuncionarioCadastrar"})
public class FuncionarioCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("funcionarioUser");
        String userSenha = request.getParameter("funcionarioSenha");
        String userTipo = request.getParameter("tipo");
        String userNome = request.getParameter("funcionarioNome");
        String userEmail = request.getParameter("funcionarioEmail");
        String userStatus = request.getParameter("FuncionarioDisponivel");
        boolean validador = false;
        if (userStatus == null) {
            validador = false;
        } else {
            validador = true;
        }
        Funcionario func = new Funcionario(user, userSenha, userTipo, userNome, userEmail, validador);
        request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                .forward(request, response);
    }

}
