/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Funcionario;
import Classes.ImagemProduto;
import Classes.Produto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author nik_r
 */
@WebServlet(name = "SalvarImagem", urlPatterns = {"/SalvarImagem"})
public class SalvarImagem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        request.getRequestDispatcher("/WEB-INF/ProdutoCadastrar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("usuarioLogado");
        request.setAttribute("NomeLogadoAtt", f.getNome());
        boolean retorno = false;
        String name = null;
        String idProd = null;
        int counterImg = 1;

        try {
            List<FileItem> multiparts = new ServletFileUpload(
                    new DiskFileItemFactory()).parseRequest(request);

            for (FileItem item : multiparts) {
                if (item.isFormField()) {
                    if (item.getFieldName().equals("idProd")) {
                        idProd = item.getString();
                    }

                } else {

                    int idProduto = Integer.parseInt(idProd);
                    String lastName = new Controller.ControllerAlterarProduto().getImagemName(idProduto);
                    if (lastName == null) {
                        new Classes.Upload().uploadFile(idProduto + "_" + counterImg, item.get());
                        retorno = new Controller.Controller_Produto().SalvarImagem(idProduto + "_" + counterImg, idProduto);
                        counterImg++;
                    } else {
                        int ultimoId = Integer.parseInt(lastName);
                        ultimoId++;
                        new Classes.Upload().uploadFile(idProduto + "_" + ultimoId, item.get());
                        retorno = new Controller.Controller_Produto().SalvarImagem(idProduto + "_" + ultimoId, idProduto);
                    }
                }
            }

            //File uploaded successfully
            request.setAttribute("message", "File Uploaded Successfully");
        } catch (Exception ex) {
            request.setAttribute("message", "File Upload Failed due to " + ex);
        }
        if (retorno) {
            request.setAttribute("SalvarIMGAtt", retorno);
            ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutos();
            request.setAttribute("ListaProdAtt", listaProd);
            request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("SalvarIMGAtt", retorno);
            ArrayList<Produto> listaProd = new Controller.ControllerListarProduto().getProdutos();
            request.setAttribute("ListaProdAtt", listaProd);
            request.getRequestDispatcher("/WEB-INF/ProdutoListarBackoffice.jsp")
                    .forward(request, response);
        }

    }

}
