/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.Funcionario;
import Classes.ImagemProduto;
import Classes.Produto;
import Classes.ValidarEmail;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beatriz.silva19
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuarioLogado") != null) {

            response.sendRedirect(request.getContextPath() + "/Index");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        ValidarEmail validar = new ValidarEmail();
        boolean emailValidar = validar.validarEmail(login);

        if (!emailValidar) {

            Funcionario funcionario = new Controller.Controller_Funcionario().getFuncionarioLogin(login);

            if (funcionario != null) {

                if (funcionario.validarSenha(senha)) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("usuarioLogado", funcionario);
                    Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
                    if (f.getTipo().equals("Administrador")) {
                        response.sendRedirect(request.getContextPath() + "/ProdutoListarBackoffice");
                    } else if (f.getTipo().equals("Estoquista")) {
                        response.sendRedirect(request.getContextPath() + "/EstoquistaListar");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/Index");
                    }
                } else {
                    request.setAttribute("senhaAtt", true);
                    request.getRequestDispatcher("/WEB-INF/Login.jsp")
                            .forward(request, response);
                }
            } else {
                request.setAttribute("senhaAtt", true);
                request.getRequestDispatcher("/WEB-INF/Login.jsp")
                        .forward(request, response);

            }

        } else {

            Cliente cliente = new Controller.Controller_Cliente().getClienteLogin(login);

            if (cliente != null) {

                if (cliente.validarSenha(senha)) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("usuarioLogado", cliente);
                    request.setAttribute("NomeLogadoAtt", cliente.getNome());
                    ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutosCliente();
                    ArrayList<ImagemProduto> listaImagens = new Controller.ControllerListarProduto().getImagensTotal();
                    ArrayList<ImagemProduto> listaPrimeiraImagem = new ArrayList<>();

                    for (ImagemProduto img : listaImagens) {
                        int IdProd = img.getIdProd();
                        if (listaPrimeiraImagem.isEmpty()) {
                            listaPrimeiraImagem.add(img);
                        } else {
                            int validarImg = 0;
                            for (ImagemProduto imgFirst : listaPrimeiraImagem) {
                                if (IdProd == imgFirst.getIdProd()) {
                                    validarImg++;
                                }
                            }
                            if (validarImg == 0) {
                                listaPrimeiraImagem.add(img);
                            }
                        }
                    }
                    for (Produto p : listaProd) {
                        for (ImagemProduto img : listaPrimeiraImagem) {
                            if (p.getIdProd() == img.getIdProd()) {
                                p.setCaminho("https://storage.cloud.google.com/imagedb/" + img.getNome());
                            }
                        }
                    }

                    request.setAttribute("listaProdutoAtt", listaProd);
                    request.setAttribute("listaImagensAtt", listaPrimeiraImagem);
                    request.setAttribute("senhaAtt", true);
                    request.getRequestDispatcher("/WEB-INF/Index.jsp")
                            .forward(request, response);
                } else {
                    request.setAttribute("senhaAtt", true);
                    request.getRequestDispatcher("/WEB-INF/Login.jsp")
                            .forward(request, response);
                }
            } else {
                request.setAttribute("senhaAtt", true);
                request.getRequestDispatcher("/WEB-INF/Login.jsp")
                        .forward(request, response);
            }
        }
    }
}
