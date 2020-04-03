/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nik_r
 */
@WebServlet(name = "FuncionarioListar", urlPatterns = {"/FuncionarioListar"})
public class FuncionarioListar extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Funcionario> listaFunc = new Controller.Controller_Funcionario().getFuncionario();
        request.setAttribute("listaFuncAtt", listaFunc);
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());

        request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idFuncionario = request.getParameter("idFunc");
        int idFunc = Integer.parseInt(idFuncionario);
        request.setAttribute("idFunc", idFunc);
        Funcionario func = new Controller.Controller_Funcionario().getFuncionarioId(idFunc);
        request.setAttribute("FuncionarioAtt", func);
        if(func.getTipo().equals("Administrador")){
            request.setAttribute("TipoAtt", 0);
        }else{
            request.setAttribute("TipoAtt", 1);
            
        }
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        
        request.getRequestDispatcher("/WEB-INF/FuncionarioAlterar.jsp")
                .forward(request, response);
    }

}
