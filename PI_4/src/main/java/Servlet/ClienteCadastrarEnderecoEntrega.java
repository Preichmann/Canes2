/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Endereco_Entrega;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteCadastrarEnderecoEntrega", urlPatterns = {"/ClienteCadastrarEnderecoEntrega"})
public class ClienteCadastrarEnderecoEntrega extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clienteCep = request.getParameter("cep");
        String clienteRua = request.getParameter("logradouro");
        String clienteNum = request.getParameter("numero");
        String clienteBairro = request.getParameter("bairro");
        String clienteCidade = request.getParameter("cidade");
        String clienteEstado = request.getParameter("estado");
        String clienteComplemento = request.getParameter("complemento");
        String clienteID = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(clienteID);
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                            } else {
                                if (clienteComplemento.equals("")) {
                                    Endereco_Entrega endereco = new Endereco_Entrega();
                                    boolean retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntregaNoComplemento(idCliente, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
                                    request.setAttribute("retornoCadastrarEntrega", retornoEndereco);
                                } else {
                                    boolean retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntrega(idCliente, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
                                    request.setAttribute("retornoCadastrarEntrega", retornoEndereco);
                                }
                            }
                        }
                    }
                }
            }
        }

        request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                .forward(request, response);
    }

}
