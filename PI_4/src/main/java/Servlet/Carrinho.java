package Servlet;

import Classes.Cliente;
import Classes.ItemPedido;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Carrinho
 */
@WebServlet("/Carrinho")
public class Carrinho extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
            ArrayList<ItemPedido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
            if (listaItemPedido != null) {
                double subtotal = 0;
                for (ItemPedido item : listaItemPedido) {
                    subtotal = subtotal + item.getValorTotal();
                }
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
                request.setAttribute("listaItemPedido", listaItemPedido);
            } else {
                double subtotal = 0;
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
            }

        } else {
            request.setAttribute("NomeLogadoAtt", "false");
            ArrayList<ItemPedido> listaItemPedido = (ArrayList<ItemPedido>) sessao.getAttribute("listaItemPedido");
            if (listaItemPedido.isEmpty()) {
                request.setAttribute("listaVazia", true);
            } else {
                request.setAttribute("listaVazia", false);
            }
            double subtotal = 0;
            for (ItemPedido item : listaItemPedido) {
                subtotal = subtotal + item.getValorTotal();
            }
            subtotal = subtotal + 10;
            request.setAttribute("SubTotal", subtotal);
            request.setAttribute("listaItemPedido", listaItemPedido);
        }
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);
    }

}
