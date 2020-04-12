/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Cliente;
import Classes.ImagemProduto;
import Classes.Pergunta;
import Classes.Produto;
import Classes.Resposta;
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
 * @author nik_r
 */
@WebServlet(name = "ProdutoDetalhar", urlPatterns = {"/ProdutoDetalhar"})
public class ProdutoDetalhar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/ProdutoDetalhe.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Cliente c = (Cliente) sessao.getAttribute("usuarioLogado");
        if (c != null) {
            request.setAttribute("NomeLogadoAtt", c.getNome());
        }else {
            request.setAttribute("NomeLogadoAtt", "false");
        }
        ImagemProduto firtImg = new ImagemProduto();
        String ProdId = request.getParameter("idProd");
        int idProd = Integer.parseInt(ProdId);
        ArrayList<ImagemProduto> imagens = new Controller.ControllerListarProduto().getImagens(idProd);
        ArrayList<ImagemProduto> imagensAdicionais = new ArrayList<>();
        for (ImagemProduto img : imagens) {
            img.setCaminho("https://storage.cloud.google.com/imagedb/" + img.getNome());
        }

        for (ImagemProduto img : imagens) {
            firtImg.setIdProd(img.getIdProd());
            firtImg.setIdImg(img.getIdImg());
            firtImg.setNome(img.getNome());
            firtImg.setCaminho(img.getCaminho());
            break;
        }
        for (ImagemProduto img : imagens) {
            if (img.getIdImg() != firtImg.getIdImg()) {
                imagensAdicionais.add(img);
            }
        }
        Produto p = new Controller.ControllerAlterarProduto().getProduto(idProd);
        ArrayList<Resposta> listaResposta = new Controller.ControllerAlterarProduto().getRespostasProduto(idProd);
        ArrayList<Pergunta> listaPergunta = new Controller.Controller_Produto().getPergunta();
        request.setAttribute("ListaPerguntaAtt", listaPergunta);
        request.setAttribute("ImagensAddAtt", imagensAdicionais);
        request.setAttribute("ActiveImgAtt", firtImg);
        request.setAttribute("ProdutoAtt", p);
        request.setAttribute("ListaRespostaProd", listaResposta);
        request.getRequestDispatcher("/WEB-INF/ProdutoDetalhe.jsp")
                .forward(request, response);
    }

}
