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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteAlterarDados", urlPatterns = {"/ClienteAlterarDados"})
public class ClienteAlterarDados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", c.getNome());
        request.setAttribute("Cliente", c);
        request.getRequestDispatcher("/WEB-INF/ClienteAlterarDadosPessoais.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        String nomeCliente = request.getParameter("clienteNome");
        boolean validarnome = validarNome(nomeCliente);
        if (!validarnome) {
            request.setAttribute("retornoNome", false);
        } else {
            String senhaCliente = request.getParameter("clienteSenha");
            if (senhaCliente.equals("")) {
                request.setAttribute("retornoSenha", false);
            } else {
                Cliente cliente = new Cliente(c.getId_cliente(), senhaCliente, nomeCliente);
                Cliente ClienteValidarSenha = new Controller.Controller_Cliente().getClienteLogin(c.getEmail());
                if (!ClienteValidarSenha.getSenha().equals(cliente.getSenha())) {
                    cliente.setSenhaHash(senhaCliente);
                }
                boolean retornoAlterar = new Controller.Controller_Cliente().AlterarCliente(cliente);
                if (retornoAlterar == false) {
                    request.setAttribute("retornoAlterar", false);
                } else {
                    request.setAttribute("retornoAlterar", true);
                    Cliente clien = new Controller.Controller_Cliente().getClienteLogin(c.getEmail());
                    sessao.setAttribute("usuarioLogado", clien);
                    Cliente ci = (Cliente) sessao.getAttribute("usuarioLogado");
                    request.setAttribute("NomeLogadoAtt", ci.getNome());
                    request.getRequestDispatcher("/WEB-INF/Index.jsp")
                            .forward(request, response);
                }
            }
        }
        request.setAttribute("NomeLogadoAtt", c.getNome());
        request.getRequestDispatcher("/WEB-INF/ClienteAlterarDadosPessoais.jsp")
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
