/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "FuncionarioExcluir", urlPatterns = {"/FuncionarioExcluir"})
public class FuncionarioExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Funcionario> listaFunc = new Controller.Controller_Funcionario().getFuncionario();
        request.setAttribute("listaFuncAtt", listaFunc);

        request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idConfirma = request.getParameter("idConfirma");
        int confirmaExclusao = Integer.parseInt(idConfirma);
        String idFuncionario = request.getParameter("idFunc");
        int idfunc = Integer.parseInt(idFuncionario);

        if (confirmaExclusao == 1) {
            boolean retorno = new Controller.Controller_Funcionario().disableFuncionario(idfunc);
            ArrayList<Funcionario> listaFunc = new Controller.Controller_Funcionario().getFuncionario();
            request.setAttribute("listaFuncAtt", listaFunc);

            request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                    .forward(request, response);
        } else {
            ArrayList<Funcionario> listaFunc = new Controller.Controller_Funcionario().getFuncionario();
            request.setAttribute("listaFuncAtt", listaFunc);

            request.getRequestDispatcher("/WEB-INF/FuncionarioListar.jsp")
                    .forward(request, response);

        }
    }
}
