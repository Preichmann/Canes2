/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
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
@WebServlet(name = "CadastrarEntrega", urlPatterns = {"/CadastrarEntrega"})
public class CadastrarEntrega extends HttpServlet {

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

        request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean retornoEndereco = false;
        boolean CadastroEntregaCompl = false;
        boolean CadastroEntrega = false;
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        int idCliente = c.getId_cliente();
        String clienteCep = request.getParameter("cep");
        String clienteRua = request.getParameter("logradouro");
        String clienteNum = request.getParameter("numero");
        String clienteBairro = request.getParameter("bairro");
        String clienteCidade = request.getParameter("cidade");
        String clienteEstado = request.getParameter("estado");
        String clienteComplemento = request.getParameter("complemento");
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
            request.setAttribute("retornoCadastrarEntrega", false);
            request.setAttribute("retornoCadastrarFaturamento", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
                request.setAttribute("retornoCadastrarEntrega", false);
                request.setAttribute("retornoCadastrarFaturamento", false);
                request.setAttribute("idCliente", idCliente);
                request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                    request.setAttribute("retornoCadastrarEntrega", false);
                    request.setAttribute("retornoCadastrarFaturamento", false);
                    request.setAttribute("idCliente", idCliente);
                    request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                        request.setAttribute("retornoCadastrarEntrega", false);
                        request.setAttribute("retornoCadastrarFaturamento", false);
                        request.setAttribute("idCliente", idCliente);
                        request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                            request.setAttribute("retornoCadastrarEntrega", false);
                            request.setAttribute("retornoCadastrarFaturamento", false);
                            request.setAttribute("idCliente", idCliente);
                            request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                                request.setAttribute("retornoCadastrarEntrega", false);
                                request.setAttribute("retornoCadastrarFaturamento", false);
                                request.setAttribute("idCliente", idCliente);
                                request.getRequestDispatcher("/WEB-INF/CadastrarEntrega.jsp")
                                        .forward(request, response);
                            } else {
                                if (clienteComplemento.equals("")) {
                                    CadastroEntrega = true;
                                    CadastroEntregaCompl = false;

                                } else {
                                    CadastroEntregaCompl = true;
                                    CadastroEntrega = false;

                                }
                            }
                        }
                    }
                }
            }
        }
        if (CadastroEntrega || CadastroEntregaCompl) {
            if (CadastroEntrega) {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntregaNoComplemento(idCliente, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
            } else {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntrega(idCliente, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
            }
        } else {
            request.setAttribute("retornoCadastrarEntrega", false);
            request.setAttribute("idCliente", idCliente);
            request.setAttribute("retornoEndereco", retornoEndereco);
            request.getRequestDispatcher("/WEB-INF/ListarDadosEntrega.jsp")
                    .forward(request, response);
        }
        ArrayList<Endereco_Entrega> listaEndereco = new Controller.Controller_Cliente().ListarEntrega(c.getId_cliente());
        request.setAttribute("ListaEntrega", listaEndereco);
        request.setAttribute("retornoEndereco", retornoEndereco);
        request.getRequestDispatcher("/WEB-INF/ListarDadosEntrega.jsp")
                .forward(request, response);
    }

}
