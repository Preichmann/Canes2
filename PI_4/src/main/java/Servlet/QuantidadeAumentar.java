/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author nik_r
 */
@WebServlet(name = "QuantidadeAumentar", urlPatterns = {"/QuantidadeAumentar"})
public class QuantidadeAumentar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/Index.jsp")
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
            for (ItemPedido item : listaItemPedido) {
                if (item.getIdProduto() == idProd) {
                    item.setQuantidade(item.getQuantidade() + 1);
                    item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
                }
            }
            request.setAttribute("listaItemPedido", listaItemPedido);
            
        }
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp")
                .forward(request, response);
        
    }
    
}
