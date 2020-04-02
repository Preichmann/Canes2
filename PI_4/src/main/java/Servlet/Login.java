/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beatriz.silva19
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("usuarioLogado") != null){
            
            response.sendRedirect(request.getContextPath() + "/Index");
            return;
        }
        
        request.getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        Funcionario funcionario = new Controller.Controller_Funcionario().getFuncionarioLogin(login);
                
        if(funcionario != null){
            
            if(funcionario.validarSenha(senha)){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuarioLogado", funcionario);
                response.sendRedirect(request.getContextPath() + "/Index");
                return;                
            } else {
                request.setAttribute("senhaAtt", true);
                request.getRequestDispatcher("/WEB-INF/Login.jsp")
                        .forward(request, response);
           }         
        } else {
            request.setAttribute("usuarioAtt", true);
            request.getRequestDispatcher("/WEB-INF/Login.jsp")
                        .forward(request, response);

        }
    }
}
