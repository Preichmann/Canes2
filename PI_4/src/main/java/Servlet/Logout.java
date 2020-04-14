/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Cliente;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.rvital
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    private void sair(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        sessao.invalidate();
        sessao = request.getSession(true);
        sessao.setAttribute("msg", true);
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        } else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
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
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

}
