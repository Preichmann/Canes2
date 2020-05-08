package Servlet;

import Classes.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FinalizarCompras", urlPatterns = {"/FinalizarCompras"})
public class FinalizarCompras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            
        } else {
            request.setAttribute("MsgCarrinho", "Para finalizar as compras é necessário estar logado no site!\n"
                    + "Por favor faça o cadastro ou o login para seguir com as compras.");
            request.getRequestDispatcher("/WEB-INF/Login.jsp")
                    .forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);
    }

}
