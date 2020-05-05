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
            ArrayList<ItemPedido> listaItemPedido = (ArrayList<ItemPedido>) sessao.getAttribute("listaItemPedido");
            if (listaItemPedido != null) {
                //Adicionar a lista vazia no banco de dados
            } else {
                //Adicionar o item no banco de dados pois a lista anonima está vazia
                String produtoId = request.getParameter("idProd");
                int idProd = Integer.parseInt(produtoId);
                ItemPedido validarRepeticao = new Controller.ControllerItemPedido().validarRepeticao(idProd);
                if (validarRepeticao != null) {
                    validarRepeticao.setQuantidade(validarRepeticao.getQuantidade() + 1);
                    validarRepeticao.setValorTotal(validarRepeticao.getQuantidade() * validarRepeticao.getValorUnitario());
                    validarRepeticao.setIdCliente(c.getId_cliente());
                    boolean adicionarItem = new Controller.ControllerItemPedido().adicionarItem(validarRepeticao);
                    ArrayList<ItemPedido> listaItemPedidoBD = new Controller.ControllerItemPedido().getListaItemPedido();
                    request.setAttribute("listaItemPedido", listaItemPedidoBD);
                } else {
                    //Adicionar novo na lista
                    Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
                    ItemPedido item = new ItemPedido();
                    item.setIdProduto(p.getIdProd());
                    item.setQuantidade(1);
                    item.setValorUnitario(p.getPreco());
                    item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                    item.setNomeProduto(p.getNome());
                    item.setIdCliente(c.getId_cliente());
                    boolean adicionarItem = new Controller.ControllerItemPedido().adicionarItem(item);
                    ArrayList<ItemPedido> listaItemPedidoBD = new Controller.ControllerItemPedido().getListaItemPedido();
                    request.setAttribute("listaItemPedido", listaItemPedidoBD);
                }
            }
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
                double subtotal = 0;
                for (ItemPedido item : listaItemPedido) {
                    subtotal = subtotal + item.getValorTotal();
                }
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
            } else {
                Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
                ItemPedido item = new ItemPedido();
                item.setIdProduto(p.getIdProd());
                item.setQuantidade(1);
                item.setValorUnitario(p.getPreco());
                item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                item.setNomeProduto(p.getNome());
                listaItemPedido.add(item);
                if (listaItemPedido == null) {
                    request.setAttribute("listaVazia", true);
                } else {
                    request.setAttribute("listaVazia", false);
                }
                double subtotal = 0;
                for (ItemPedido items : listaItemPedido) {
                    subtotal = subtotal + items.getValorTotal();
                }
                subtotal = subtotal + 10;
                request.setAttribute("SubTotal", subtotal);
                request.setAttribute("listaItemPedido", listaItemPedido);
            }
        }

        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);

    }
}
