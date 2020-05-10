package Servlet;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.ImagemProduto;
import Classes.ItemPedido;
import Classes.Produto;
import java.io.IOException;
import java.util.ArrayList;
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
            if (c != null) {
                request.setAttribute("NomeLogadoAtt", c.getNome());
            } else {
                request.setAttribute("NomeLogadoAtt", "false");
            }
            ArrayList<ItemPedido> listaItemPedido = new Controller.ControllerItemPedido().getListaItemPedido(c.getId_cliente());
            if (listaItemPedido != null) {
                //Redirecionar para a tela de escolher o endereco de faturamento
                request.setAttribute("idCliente", c.getId_cliente());
                ArrayList<Endereco_Entrega> listaEndereco = new Controller.Controller_Cliente().ListarEntrega(c.getId_cliente());
                request.setAttribute("ListaEntrega", listaEndereco);
                request.getRequestDispatcher("/WEB-INF/CheckOutEntrega.jsp")
                        .forward(request, response);
            } else {
                ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutosCliente();
                ArrayList<ImagemProduto> listaImagens = new Controller.ControllerListarProduto().getImagensTotal();
                ArrayList<ImagemProduto> listaPrimeiraImagem = new ArrayList<>();
                for (ImagemProduto img : listaImagens) {
                    int IdProd = img.getIdProd();
                    if (listaPrimeiraImagem.isEmpty()) {
                        listaPrimeiraImagem.add(img);
                    } else {
                        int validar = 0;
                        for (ImagemProduto imgFirst : listaPrimeiraImagem) {
                            if (IdProd == imgFirst.getIdProd()) {
                                validar++;
                            }
                        }
                        if (validar == 0) {
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
                request.setAttribute("msg", false);
                request.setAttribute("msgCarrinhoVazio", true);
            }
            request.getRequestDispatcher("/WEB-INF/Index.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("MsgCarrinho", true);
            request.getRequestDispatcher("/WEB-INF/Login.jsp")
                    .forward(request, response);
        }
    }

}
