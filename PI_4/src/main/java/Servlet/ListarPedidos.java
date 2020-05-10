package Servlet;

import Classes.Cliente;
import Classes.Pedido;
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
 * @author Gabriel Ribeiro Vital
 */
@WebServlet(name = "ListarPedidos", urlPatterns = {"/ListarPedidos"})
public class ListarPedidos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
            ArrayList<Pedido> listaPedidos = new Controller.ControllerItemPedido().getListaPedidos(c.getId_cliente());
            request.setAttribute("ListaPedidos", listaPedidos);
            request.getRequestDispatcher("/WEB-INF/ListarPedidos.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
            request.getRequestDispatcher("/WEB-INF/ListarPedidos.jsp")
                    .forward(request, response);
        }
    }

}
