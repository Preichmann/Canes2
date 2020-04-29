package Servlet;

import Classes.Cliente;
import Classes.ItemPedido;
import Classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdicionarItemCarrinho", urlPatterns = {"/AdicionarItemCarrinho"})
public class AdicionarItemCarrinho extends HttpServlet {

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
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
            ArrayList<ItemPedido> listaItemPedido = (ArrayList<ItemPedido>) sessao.getAttribute("listaItemPedido");
            String produtoId = request.getParameter("idProd");
            int idProd = Integer.parseInt(produtoId);
            boolean existir = false;
            for (ItemPedido item : listaItemPedido) {
                if (item.getIdProduto() == idProd) {
                    existir = true;
                }
            }
            if (existir) {
                for (ItemPedido item : listaItemPedido) {
                    if (item.getIdProduto() == idProd) {
                        item.setQuantidade(item.getQuantidade() + 1);
                        item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                        request.setAttribute("listaItemPedido", listaItemPedido);
                    }
                }
            } else {
                Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
                ItemPedido item = new ItemPedido();
                item.setIdProduto(p.getIdProd());
                item.setQuantidade(1);
                item.setValorUnitario(p.getPreco());
                item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                item.setNomeProduto(p.getNome());
                listaItemPedido.add(item);
                request.setAttribute("listaItemPedido", listaItemPedido);
            }
        }
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);

    }
}
