/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import Classes.ValidarEmail;
import java.io.IOException;
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
        int tamanhoUser = user.length();
        int senha = userSenha.length();
        
        if (tamanhoUser == 0 || senha == 0 || userTipo == null) {
            boolean falhaUser = false;
            boolean falhaSenha = false;
            boolean falhaTipo = false;
            if (tamanhoUser == 0) {
                request.setAttribute("UserFalha", falhaUser);
            }
            if (senha == 0) {
                request.setAttribute("senhaFalha", falhaSenha);
            }
            if (userTipo == null) {
                request.setAttribute("tipoFalha", falhaTipo);
            }

            request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                    .forward(request, response);
        } else {
            ValidarEmail validar = new ValidarEmail();
            boolean emailValidar = validar.validarEmail(userEmail);
            int tamanhoNome = userNome.length();
            if (tamanhoNome < 5) {
                boolean falhanome = false;
                request.setAttribute("NomeFalha", falhanome);
                request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                        .forward(request, response);
            } else if (emailValidar) {

                boolean validador = false;
                if (userStatus == null) {
                    validador = false;
                } else {
                    validador = true;
                }
                Funcionario func = new Funcionario(user, userSenha, userTipo, userNome, userEmail, validador);
                func.setSenhaHash(userSenha);
                boolean retorno = new Controller.Controller_Funcionario().cadastrarFuncionario(func);
                request.setAttribute("retorno", retorno);
                request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                        .forward(request, response);
            } else {
                boolean falhaEmail = false;
                request.setAttribute("EmailFalha", falhaEmail);

                request.getRequestDispatcher("/WEB-INF/FuncionarioCadastrar.jsp")
                        .forward(request, response);
            }
        }
    }
}
