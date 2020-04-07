/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.ValidaCPF;
import Classes.ValidarEmail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteCadastrar", urlPatterns = {"/ClienteCadastrar"})
public class ClienteCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/ClienteCadastrar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeCliente = request.getParameter("clienteNome");
        boolean validarnome = validarNome(nomeCliente);
        if (!validarnome) {
            request.setAttribute("retornoNome", false);
        } else {
            String clienteEmail = request.getParameter("clienteEmail");
            ValidarEmail validar = new ValidarEmail();
            boolean emailValidar = validar.validarEmail(clienteEmail);
            if(!emailValidar){
                request.setAttribute("retornoEmail", false);
            }else{
                String senhaCliente = request.getParameter("clienteSenha");
                if(senhaCliente.equals("")){
                    request.setAttribute("retornoSenha", false);
                }else{
                    String CpfCliente = request.getParameter("clienteCPF");
                    ValidaCPF validarCpf = new ValidaCPF();
                    boolean validarCPF = validarCpf.isCPF(CpfCliente);
                    if(!validarCPF){
                        request.setAttribute("retornoCPF", false);
                    }else{
                        
                    }
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/ClienteCadastrar.jsp")
                .forward(request, response);
    }

    public boolean validarNome(String nome) {
        int contarLetra = 0;
        int contarPalavra = 0;
        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);
            if (contarPalavra >= 2) {
                return true;
            } else if (letra != ' ') {
                contarLetra++;
            } else if (contarLetra < 3) {
                return false;
            } else {
                contarPalavra++;
                contarLetra = 0;
            }
        }
        return false;
    }
}
