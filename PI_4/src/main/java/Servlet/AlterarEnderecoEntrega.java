package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlterarEnderecoEntrega", urlPatterns = {"/AlterarEnderecoEntrega"})
public class AlterarEnderecoEntrega extends HttpServlet {

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
        boolean CadastroEntregaCompl = false;
        boolean CadastroEntrega = false;
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
        String Entrega = request.getParameter("idEntrega");
        int idEntrega = Integer.parseInt(Entrega);
        String cepValidar = request.getParameter("cepValidar");
        if (cepValidar.equals("falha")) {
            request.setAttribute("RetornoCepVal", false);
            request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                    .forward(request, response);
        }
        if (clienteCep.equals("")) {
            request.setAttribute("RetornoCep", false);
            request.setAttribute("retornoCadastrarEntrega", false);
            Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
            request.setAttribute("cep", entrega.getCep());
            request.setAttribute("rua", entrega.getRua());
            request.setAttribute("numero", entrega.getNumero());
            request.setAttribute("bairro", entrega.getBairro());
            request.setAttribute("complemento", entrega.getComplemento());
            request.setAttribute("cidade", entrega.getCidade());
            request.setAttribute("estado", entrega.getEstado());
            request.setAttribute("idEntrega", entrega.getId_entrega());
            request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                    .forward(request, response);
        } else {
            if (clienteRua.equals("")) {
                request.setAttribute("RetornoRua", false);
                request.setAttribute("retornoCadastrarEntrega", false);
                Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
                request.setAttribute("cep", entrega.getCep());
                request.setAttribute("rua", entrega.getRua());
                request.setAttribute("numero", entrega.getNumero());
                request.setAttribute("bairro", entrega.getBairro());
                request.setAttribute("complemento", entrega.getComplemento());
                request.setAttribute("cidade", entrega.getCidade());
                request.setAttribute("estado", entrega.getEstado());
                request.setAttribute("idEntrega", entrega.getId_entrega());
                request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                        .forward(request, response);
            } else {
                if (clienteNum.equals("")) {
                    request.setAttribute("RetornoNum", false);
                    request.setAttribute("retornoCadastrarEntrega", false);

                    Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
                    request.setAttribute("cep", entrega.getCep());
                    request.setAttribute("rua", entrega.getRua());
                    request.setAttribute("numero", entrega.getNumero());
                    request.setAttribute("bairro", entrega.getBairro());
                    request.setAttribute("complemento", entrega.getComplemento());
                    request.setAttribute("cidade", entrega.getCidade());
                    request.setAttribute("estado", entrega.getEstado());
                    request.setAttribute("idEntrega", entrega.getId_entrega());
                    request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                            .forward(request, response);
                } else {
                    if (clienteBairro.equals("")) {
                        request.setAttribute("RetornoBairro", false);
                        request.setAttribute("retornoCadastrarEntrega", false);
                        Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
                        request.setAttribute("cep", entrega.getCep());
                        request.setAttribute("rua", entrega.getRua());
                        request.setAttribute("numero", entrega.getNumero());
                        request.setAttribute("bairro", entrega.getBairro());
                        request.setAttribute("complemento", entrega.getComplemento());
                        request.setAttribute("cidade", entrega.getCidade());
                        request.setAttribute("estado", entrega.getEstado());
                        request.setAttribute("idEntrega", entrega.getId_entrega());
                        request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                                .forward(request, response);
                    } else {
                        if (clienteCidade.equals("")) {
                            request.setAttribute("RetornoCidade", false);
                            request.setAttribute("retornoCadastrarEntrega", false);
                            Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
                            request.setAttribute("cep", entrega.getCep());
                            request.setAttribute("rua", entrega.getRua());
                            request.setAttribute("numero", entrega.getNumero());
                            request.setAttribute("bairro", entrega.getBairro());
                            request.setAttribute("complemento", entrega.getComplemento());
                            request.setAttribute("cidade", entrega.getCidade());
                            request.setAttribute("estado", entrega.getEstado());
                            request.setAttribute("idEntrega", entrega.getId_entrega());
                            request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                                    .forward(request, response);
                        } else {
                            if (clienteEstado.equals("")) {
                                request.setAttribute("RetornoEstado", false);
                                request.setAttribute("retornoCadastrarEntrega", false);
                                Endereco_Entrega entrega = new Controller.Controller_Cliente().getEntrega(idEntrega);
                                request.setAttribute("cep", entrega.getCep());
                                request.setAttribute("rua", entrega.getRua());
                                request.setAttribute("numero", entrega.getNumero());
                                request.setAttribute("bairro", entrega.getBairro());
                                request.setAttribute("complemento", entrega.getComplemento());
                                request.setAttribute("cidade", entrega.getCidade());
                                request.setAttribute("estado", entrega.getEstado());
                                request.setAttribute("idEntrega", entrega.getId_entrega());
                                request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
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
                retornoEndereco = new Controller.Controller_Cliente().alterarEnderecoEntregaNoComplemento(idEntrega, clienteCep, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
            } else {
                retornoEndereco = new Controller.Controller_Cliente().alterarEnderecoEntrega(idEntrega, clienteCep, clienteRua, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
            }

        } else {
            request.setAttribute("retornoCadastrarEntrega", false);
            request.setAttribute("retornoCadastrarFaturamento", false);
            request.getRequestDispatcher("/WEB-INF/AlterarDadosEntraga.jsp")
                    .forward(request, response);
        }
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        ArrayList<Endereco_Entrega> listaEndereco = new Controller.Controller_Cliente().ListarEntrega(c.getId_cliente());
        request.setAttribute("ListaEntrega", listaEndereco);
        request.setAttribute("Retorno", retornoEndereco);
        request.getRequestDispatcher("/WEB-INF/ListarDadosEntrega.jsp")
                .forward(request, response);
    }

}
