/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
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
@WebServlet(name = "AlterarEnderecoFaturamento", urlPatterns = {"/AlterarEnderecoFaturamento"})
public class AlterarEnderecoFaturamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean retornoEndereco = false;
        boolean CadastroFaturaCompl = false;
        boolean CadastroFatura = false;
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        String clienteCep = request.getParameter("cep");
        String clienteRua = request.getParameter("logradouro");
        String clienteNum = request.getParameter("numero");
        String clienteBairro = request.getParameter("bairro");
        String clienteCidade = request.getParameter("cidade");
        String clienteEstado = request.getParameter("estado");
        String clienteComplemento = request.getParameter("complemento");
        String fatura = request.getParameter("idFatura");
        int idFatura = Integer.parseInt(fatura);
        String cepValidar = request.getParameter("cepValidar");
        if (cepValidar.equals("falha")) {
            request.setAttribute("RetornoCepVal", false);
            request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                    .forward(request, response);
        }
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
            request.setAttribute("retornoCadastrarFaturamento", false);
            Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
            request.setAttribute("cep", faturaObj.getCep());
            request.setAttribute("rua", faturaObj.getRua());
            request.setAttribute("numero", faturaObj.getNumero());
            request.setAttribute("bairro", faturaObj.getBairro());
            request.setAttribute("complemento", faturaObj.getComplemento());
            request.setAttribute("cidade", faturaObj.getCidade());
            request.setAttribute("estado", faturaObj.getEstado());
            request.setAttribute("idFatura", faturaObj.getId_faturamento());
            request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
                request.setAttribute("retornoCadastrarFaturamento", false);
                Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
                request.setAttribute("cep", faturaObj.getCep());
                request.setAttribute("rua", faturaObj.getRua());
                request.setAttribute("numero", faturaObj.getNumero());
                request.setAttribute("bairro", faturaObj.getBairro());
                request.setAttribute("complemento", faturaObj.getComplemento());
                request.setAttribute("cidade", faturaObj.getCidade());
                request.setAttribute("estado", faturaObj.getEstado());
                request.setAttribute("idFatura", faturaObj.getId_faturamento());
                request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                    request.setAttribute("retornoCadastrarFaturamento", false);
                    Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
                    request.setAttribute("cep", faturaObj.getCep());
                    request.setAttribute("rua", faturaObj.getRua());
                    request.setAttribute("numero", faturaObj.getNumero());
                    request.setAttribute("bairro", faturaObj.getBairro());
                    request.setAttribute("complemento", faturaObj.getComplemento());
                    request.setAttribute("cidade", faturaObj.getCidade());
                    request.setAttribute("estado", faturaObj.getEstado());
                    request.setAttribute("idFatura", faturaObj.getId_faturamento());
                    request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                        request.setAttribute("retornoCadastrarFaturamento", false);
                        Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
                        request.setAttribute("cep", faturaObj.getCep());
                        request.setAttribute("rua", faturaObj.getRua());
                        request.setAttribute("numero", faturaObj.getNumero());
                        request.setAttribute("bairro", faturaObj.getBairro());
                        request.setAttribute("complemento", faturaObj.getComplemento());
                        request.setAttribute("cidade", faturaObj.getCidade());
                        request.setAttribute("estado", faturaObj.getEstado());
                        request.setAttribute("idFatura", faturaObj.getId_faturamento());
                        request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                            request.setAttribute("retornoCadastrarFaturamento", false);
                            Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
                            request.setAttribute("cep", faturaObj.getCep());
                            request.setAttribute("rua", faturaObj.getRua());
                            request.setAttribute("numero", faturaObj.getNumero());
                            request.setAttribute("bairro", faturaObj.getBairro());
                            request.setAttribute("complemento", faturaObj.getComplemento());
                            request.setAttribute("cidade", faturaObj.getCidade());
                            request.setAttribute("estado", faturaObj.getEstado());
                            request.setAttribute("idFatura", faturaObj.getId_faturamento());
                            request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                                request.setAttribute("retornoCadastrarFaturamento", false);
                                Endereco_Fatura faturaObj = new Controller.Controller_Cliente().getFatura(idFatura);
                                request.setAttribute("cep", faturaObj.getCep());
                                request.setAttribute("rua", faturaObj.getRua());
                                request.setAttribute("numero", faturaObj.getNumero());
                                request.setAttribute("bairro", faturaObj.getBairro());
                                request.setAttribute("complemento", faturaObj.getComplemento());
                                request.setAttribute("cidade", faturaObj.getCidade());
                                request.setAttribute("estado", faturaObj.getEstado());
                                request.setAttribute("idFatura", faturaObj.getId_faturamento());
                                request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                                        .forward(request, response);
                            } else {
                                if (clienteComplemento.equals("")) {
                                    CadastroFatura = true;
                                    CadastroFaturaCompl = false;

                                } else {
                                    CadastroFaturaCompl = true;
                                    CadastroFatura = false;

                                }
                            }
                        }
                    }
                }
            }
        }
        if (CadastroFatura || CadastroFaturaCompl) {
            if (CadastroFatura) {
                retornoEndereco = new Controller.Controller_Cliente().alterarEnderecoFaturaNoComplemento(idFatura, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
            } else {
                retornoEndereco = new Controller.Controller_Cliente().alterarEnderecoFatura(idFatura, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
            }

        } else {
            request.setAttribute("retornoCadastrarFaturamento", false);
            request.getRequestDispatcher("/WEB-INF/AlterarDadosFaturamento.jsp")
                    .forward(request, response);
        }
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        ArrayList<Endereco_Fatura> listaFatu = new Controller.Controller_Cliente().ListarFatura(c.getId_cliente());
        request.setAttribute("Retorno", retornoEndereco);
        request.setAttribute("ListaFaturamento", listaFatu);

        request.getRequestDispatcher("/WEB-INF/ListarDadosFaturamento.jsp")
                .forward(request, response);
    }

}
