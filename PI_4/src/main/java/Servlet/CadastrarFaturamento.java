/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Fatura;
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
@WebServlet(name = "CadastrarFaturamento", urlPatterns = {"/CadastrarFaturamento"})
public class CadastrarFaturamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        request.setAttribute("idCliente", c.getId_cliente());

        request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean retornoEndereco = false;
        boolean CadastroFaturamentoCompl = false;
        boolean CadastroFaturamento = false;
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        int idCliente = c.getId_cliente();
        String cepValidar = request.getParameter("cepValidar");
        String clienteCep = request.getParameter("cep");
        String clienteRua = request.getParameter("logradouro");
        String clienteNum = request.getParameter("numero");
        String clienteBairro = request.getParameter("bairro");
        String clienteCidade = request.getParameter("cidade");
        String clienteEstado = request.getParameter("estado");
        String clienteComplemento = request.getParameter("complemento");
        if (cepValidar.equals("falha")) {
            request.setAttribute("RetornoCepVal", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                    .forward(request, response);
        }
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
            request.setAttribute("retornoCadastrarFaturamento", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
                request.setAttribute("retornoCadastrarFaturamento", false);
                request.setAttribute("idCliente", idCliente);
                request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                    request.setAttribute("retornoCadastrarFaturamento", false);
                    request.setAttribute("idCliente", idCliente);
                    request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                        request.setAttribute("retornoCadastrarFaturamento", false);
                        request.setAttribute("idCliente", idCliente);
                        request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                            request.setAttribute("retornoCadastrarFaturamento", false);
                            request.setAttribute("idCliente", idCliente);
                            request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                                request.setAttribute("retornoCadastrarFaturamento", false);
                                request.setAttribute("idCliente", idCliente);
                                request.getRequestDispatcher("/WEB-INF/CadastrarFaturamento.jsp")
                                        .forward(request, response);
                            } else {
                                if (clienteComplemento.equals("")) {
                                    CadastroFaturamento = true;
                                    CadastroFaturamentoCompl = false;

                                } else {
                                    CadastroFaturamentoCompl = true;
                                    CadastroFaturamento = false;

                                }
                            }
                        }
                    }
                }
            }
        }
        if (CadastroFaturamento || CadastroFaturamentoCompl) {
            if (CadastroFaturamento) {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoFaturamentoNoComplemento(idCliente, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
            } else {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoFaturamento(idCliente, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/Index.jsp")
                    .forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }

}
