/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Classes.Funcionario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@WebFilter(filterName = "UsuarioLogado", servletNames = {"Carrinho", "EstoquistaAlterar", "EstoquistaListar", "Creditos", "ExcluirImagem", "FuncionarioAlterar", "FuncionarioCadastrar", "FuncionarioExcluir", "FuncionarioListar", "ProdutoAlterar", "ProdutoCadastrar", "ProdutoExcluir", "ProdutoListarBackoffice", "SalvarImagem"})
public class UsuarioLogado implements Filter {

    private String contextPath;

    public UsuarioLogado() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("usuarioLogado") == null) {
            session.invalidate();
            res.sendRedirect(req.getContextPath() + "/Login");
            return;
        }

        Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");

        if (verificaAutorizacao(funcionario, req)) {
            chain.doFilter(request, response);
        } else {
            //Criar uma página de retorno informando que não tem acesso
            res.sendRedirect(req.getContextPath() + "/Login");
        }

    }

    private boolean verificaAutorizacao(
            Funcionario funcionario,
            HttpServletRequest httpRequest) {

        String urlAcessada = httpRequest.getRequestURI();

        if (urlAcessada.endsWith("/Login") || urlAcessada.endsWith("/Creditos") || urlAcessada.endsWith("/Index")
                || urlAcessada.endsWith("/Carrinho")) {
            return true;
        } else if ((urlAcessada.endsWith("/ExcluirMensagem")
                || urlAcessada.endsWith("/FuncionarioAlterar")
                || urlAcessada.endsWith("/FuncionarioCadastrar")
                || urlAcessada.endsWith("/FuncionarioExcluir")
                || urlAcessada.endsWith("/FuncionarioListar")
                || urlAcessada.endsWith("/ProdutoAlterar")
                || urlAcessada.endsWith("/ProdutoCadastrar")
                || urlAcessada.endsWith("/ProdutoDetalhar")
                || urlAcessada.endsWith("/ProdutoExcluir")
                || urlAcessada.endsWith("/ProdutoListarBackoffice")
                || urlAcessada.endsWith("/SalvarImagem"))
                && funcionario.getTipo().equals("Administrador")) {
            return true;
        } else if (urlAcessada.endsWith("/EstoquistaListar")
                || urlAcessada.endsWith("EstoquistaAlterar")
                && funcionario.getTipo().equals("Estoquista")) {
            return true;
        }
        return false;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }

}
