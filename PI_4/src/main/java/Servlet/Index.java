package Servlet;

import Classes.ImagemProduto;
import Classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        for (ImagemProduto img : listaImagens) {
            int IdProd = img.getIdProd();
            for (ImagemProduto imgFirst : listaPrimeiraImagem) {
                if (IdProd != imgFirst.getIdProd()) {
                    listaPrimeiraImagem.add(img);
                } 
            }
        }

        request.setAttribute("listaProdutoAtt", listaProd);
        request.setAttribute("listaImagensAtt", listaPrimeiraImagem);

        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }
}
