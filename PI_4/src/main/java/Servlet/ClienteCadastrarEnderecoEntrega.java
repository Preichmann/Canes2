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
import javax.servlet.http.HttpSession;

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
        boolean retornoEnderecoFat = false;
        boolean retornoEndereco = false;
        boolean CadastroEntregaCompl = false;
        boolean CadastroEntrega = false;
        boolean CadastroFaturamentoComple = false;
        boolean CadastroFaturamento = false;

        String cepValidar = request.getParameter("cepValidar");
        String cepValidar2 = request.getParameter("cepValidar2");
        String clienteCep = request.getParameter("cep");
        String clienteRua = request.getParameter("logradouro");
        String clienteNum = request.getParameter("numero");
        String clienteBairro = request.getParameter("bairro");
        String clienteCidade = request.getParameter("cidade");
        String clienteEstado = request.getParameter("estado");
        String clienteComplemento = request.getParameter("complemento");
        String clienteCep2 = request.getParameter("cep2");
        String clienteRua2 = request.getParameter("logradouro2");
        String clienteNum2 = request.getParameter("numero2");
        String clienteBairro2 = request.getParameter("bairro2");
        String clienteCidade2 = request.getParameter("cidade2");
        String clienteEstado2 = request.getParameter("estado2");
        String clienteComplemento2 = request.getParameter("complemento2");
        String clienteID = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(clienteID);
        if (cepValidar.equals("falha") || cepValidar2.equals("falha")) {
            request.setAttribute("RetornoCepVal", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                    .forward(request, response);
        }
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
                request.setAttribute("idCliente", idCliente);
                request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                    request.setAttribute("idCliente", idCliente);
                    request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                        request.setAttribute("idCliente", idCliente);
                        request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                            request.setAttribute("idCliente", idCliente);
                            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                                request.setAttribute("idCliente", idCliente);
                                request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
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
        if (clienteCep2.equals("")) {
            request.setAttribute("RetornoCep2", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua2.equals("")) {
                request.setAttribute("RetornoRua2", false);
                request.setAttribute("idCliente", idCliente);
                request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum2.equals("")) {
                    request.setAttribute("RetornoNum2", false);
                    request.setAttribute("idCliente", idCliente);
                    request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro2.equals("")) {
                        request.setAttribute("RetornoBairro2", false);
                        request.setAttribute("idCliente", idCliente);
                        request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade2.equals("")) {
                            request.setAttribute("RetornoCidade2", false);
                            request.setAttribute("idCliente", idCliente);
                            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado2.equals("")) {
                                request.setAttribute("RetornoEstado2", false);
                                request.setAttribute("idCliente", idCliente);
                                request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                                        .forward(request, response);
                            } else {
                                if (clienteComplemento2.equals("")) {
                                    CadastroFaturamento = true;
                                    CadastroFaturamentoComple = false;

                                } else {
                                    CadastroFaturamento = false;
                                    CadastroFaturamentoComple = true;

                                }
                            }
                        }
                    }
                }
            }
        }
        if (CadastroEntrega || CadastroEntregaCompl && CadastroFaturamento || CadastroFaturamentoComple) {
            if (CadastroEntrega) {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntregaNoComplemento(idCliente, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
            } else {
                retornoEndereco = new Controller.Controller_Cliente().cadastrarEnderecoEntrega(idCliente, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
            }
            if (CadastroFaturamento) {
                retornoEnderecoFat = new Controller.Controller_Cliente().cadastrarEnderecoFaturamentoNoComplemento(idCliente, clienteCep2, clienteRua2, clienteNum2, clienteBairro2, clienteCidade2, clienteEstado2);
            } else {
                retornoEnderecoFat = new Controller.Controller_Cliente().cadastrarEnderecoFaturamento(idCliente, clienteCep2, clienteRua2, clienteNum2, clienteComplemento2, clienteBairro2, clienteCidade2, clienteEstado2);
            }
        } else {
            request.setAttribute("retornoCadastrarEntrega", false);
            request.setAttribute("retornoCadastrarFaturamento", false);
            request.setAttribute("idCliente", idCliente);
            request.getRequestDispatcher("/WEB-INF/ClienteEnderecoEntregaCadastrar.jsp")
                    .forward(request, response);
        }
        request.setAttribute("retornoCadastroEntrega", retornoEndereco);
        request.setAttribute("retornoCadastroFat", retornoEnderecoFat);

        request.getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(request, response);
    }

}
