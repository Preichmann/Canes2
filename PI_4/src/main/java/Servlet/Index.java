package Servlet;

import Classes.Cliente;
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

/*
 * @author Beatriz
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutosCliente();
        ArrayList<ImagemProduto> listaImagens = new Controller.ControllerListarProduto().getImagensTotal();
        ArrayList<ImagemProduto> listaPrimeiraImagem = new ArrayList<>();
        HttpSession sessao = request.getSession();
        ArrayList<ItemPedido> listaItemPedido = (ArrayList<ItemPedido>) sessao.getAttribute("listaItemPedido");
        if (listaItemPedido != null) {
            sessao.setAttribute("listaItemPedido", listaItemPedido);
        } else {
            listaItemPedido = new ArrayList<>();
            sessao.setAttribute("listaItemPedido", listaItemPedido);
        }
            Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
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
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg", false);
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }
}
