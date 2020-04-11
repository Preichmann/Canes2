/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
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

        request.getRequestDispatcher("/WEB-INF/ClienteCadastrarr.jsp")
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
            boolean emailCadastrado = new Controller.Controller_Cliente().validarEmail(clienteEmail);

            if (!emailValidar) {
                request.setAttribute("retornoEmail", false);
            } else if (!emailCadastrado) {
                request.setAttribute("retornoEmailCadastrado", false);
            } else {
                String senhaCliente = request.getParameter("clienteSenha");
                if (senhaCliente.equals("")) {
                    request.setAttribute("retornoSenha", false);
                } else {
                    String CpfCliente = request.getParameter("clienteCPF");
                    ValidaCPF validarCpf = new ValidaCPF();
                    boolean validarCPF = validarCpf.isCPF(CpfCliente);
                    boolean validarCPFExistente = new Controller.Controller_Cliente().validarCPF(CpfCliente);

                    if (!validarCPF) {
                        request.setAttribute("retornoCPF", false);
                    } else if (!validarCPFExistente) {
                        request.setAttribute("retornoCPFCadastrado", false);
                    } else {
                        Cliente c = new Cliente(senhaCliente, nomeCliente, clienteEmail, CpfCliente);
                        c.setSenhaHash(senhaCliente);
                        int retornoCadastro = new Controller.Controller_Cliente().cadastrarCliente(c);
                        if (retornoCadastro == 0) {
                            request.setAttribute("retornoCadastro", false);
                        } else {
                            request.setAttribute("idCliente", retornoCadastro);
                            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                    .forward(request, response);
                        }
                    }
                }
            }
        }

        request.getRequestDispatcher(
                "/WEB-INF/ClienteCadastrarr.jsp")
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
        return true;
    }
}
