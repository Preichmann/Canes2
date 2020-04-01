/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import Classes.ValidarEmail;
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
@WebServlet(name = "FuncionarioAlterar", urlPatterns = {"/FuncionarioAlterar"})
public class FuncionarioAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFunci = request.getParameter("idFunci");
        String user = request.getParameter("funcionarioUser");
        String userSenha = request.getParameter("funcionarioSenha");
        String userTipo = request.getParameter("tipo");
        String userNome = request.getParameter("funcionarioNome");
        String userEmail = request.getParameter("funcionarioEmail");
        String userStatus = request.getParameter("FuncionarioDisponivel");
        int tamanhoUser = user.length();
        int senha = userSenha.length();
        int idFuncionario = Integer.parseInt(idFunci);

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
            boolean falhanome = false;
                request.setAttribute("NomeFalha", falhanome);
                request.setAttribute("idFunc", idFuncionario);
                Funcionario func = new Controller.Controller_Funcionario().getFuncionarioId(idFuncionario);
                request.setAttribute("FuncionarioAtt", func);
                if (func.getTipo().equals("Administrador")) {
                    request.setAttribute("TipoAtt", 0);
                } else {
                    request.setAttribute("TipoAtt", 1);

                }

            request.getRequestDispatcher("/WEB-INF/FuncionarioAlterar.jsp")
                    .forward(request, response);
        } else {
            ValidarEmail validar = new ValidarEmail();
            boolean emailValidar = validar.validarEmail(userEmail);
            int tamanhoNome = userNome.length();
            if (tamanhoNome < 5) {
                boolean falhanome = false;
                request.setAttribute("NomeFalha", falhanome);
                request.setAttribute("idFunc", idFuncionario);
                Funcionario func = new Controller.Controller_Funcionario().getFuncionarioId(idFuncionario);
                request.setAttribute("FuncionarioAtt", func);
                if (func.getTipo().equals("Administrador")) {
                    request.setAttribute("TipoAtt", 0);
                } else {
                    request.setAttribute("TipoAtt", 1);

                }
                request.getRequestDispatcher("/WEB-INF/FuncionarioAlterar.jsp")
                        .forward(request, response);
            } else if (emailValidar) {

                boolean validador = false;
                if (userStatus == null) {
                    validador = false;
                } else {
                    validador = true;
                }
                Funcionario func = new Funcionario(idFuncionario, user, userSenha, userTipo, userNome, userEmail, validador);
                boolean retorno = new Controller.Controller_Funcionario().alterarFuncionario(func);
                request.setAttribute("retornoAlterar", retorno);

                request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                        .forward(request, response);
            } else {
                boolean falhaEmail = false;
                request.setAttribute("EmailFalha", falhaEmail);
                
                boolean falhanome = false;
                request.setAttribute("NomeFalha", falhanome);
                request.setAttribute("idFunc", idFuncionario);
                Funcionario func = new Controller.Controller_Funcionario().getFuncionarioId(idFuncionario);
                request.setAttribute("FuncionarioAtt", func);
                if (func.getTipo().equals("Administrador")) {
                    request.setAttribute("TipoAtt", 0);
                } else {
                    request.setAttribute("TipoAtt", 1);

                }
                
                request.getRequestDispatcher("/WEB-INF/FuncionarioAlterar.jsp")
                        .forward(request, response);
            }
        }
    }

}
