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
            if (listaItemPedido.isEmpty()) {
                //Adicionar o item no banco de dados pois a lista anonima está vazia e o cliente esta logado
                String produtoId = request.getParameter("idProd");
                int idProd = Integer.parseInt(produtoId);
                //obtem a lista de itens atrelada ao cliente
                ArrayList<ItemPedido> ListaItens = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
                //caso a lista não tenha nenhum item ele adiciona o item ao BD
                if (ListaItens != null) {
                    //varrer a lista e caso ja exista o produto na lista alterar a quantidade se nao adicionar a BD o novo item
                    boolean existe = false;
                    for (ItemPedido item : ListaItens) {
                        if (idProd == item.getIdProduto()) {
                            existe = true;
                        }
                    }
                    //Caso ja exista esse produto no banco de dados adicionar mais 1 a quantidade
                    if (existe) {
                        for (ItemPedido item : ListaItens) {
                            if (idProd == item.getIdProduto()) {
                                item.setQuantidade(item.getQuantidade() + 1);
                                item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                                new Controller.ControllerItemPedido().atualizarQuantidade(item);
                                ArrayList<ItemPedido> listaItemPedidoBD = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
                                request.setAttribute("listaItemPedido", listaItemPedidoBD);
                            }
                        }
                    } else {
                        //caso nao exista esse item na lista do cliente adicionar o item
                        Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
                        ItemPedido item = new ItemPedido();
                        item.setIdProduto(p.getIdProd());
                        item.setQuantidade(1);
                        item.setValorUnitario(p.getPreco());
                        item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                        item.setNomeProduto(p.getNome());
                        item.setIdCliente(c.getId_cliente());
                        boolean adicionarItem = new Controller.ControllerItemPedido().adicionarItem(item);
                        ArrayList<ItemPedido> listaItemPedidoBD = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
                        request.setAttribute("listaItemPedido", listaItemPedidoBD);
                    }

                } else {
                    //O BD nao possui registro de itens para esse cliente
                    //Adicionar novo ao BD
                    Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
                    ItemPedido item = new ItemPedido();
                    item.setIdProduto(p.getIdProd());
                    item.setQuantidade(1);
                    item.setValorUnitario(p.getPreco());
                    item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                    item.setNomeProduto(p.getNome());
                    item.setIdCliente(c.getId_cliente());
                    boolean adicionarItem = new Controller.ControllerItemPedido().adicionarItem(item);
                    ArrayList<ItemPedido> listaItemPedidoBD = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
                    request.setAttribute("listaItemPedido", listaItemPedidoBD);
                }
            }
        } else {
            //Caso nao tenha ninguem logado ele adiciona ao um arrayList em uma sessão.
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
            //Caso já exista um produto igual a lista ele incrementa na quantidade
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
                //Caso a lista nao tenha esse produto na lista ele adiciona
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
