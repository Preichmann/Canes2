<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Validar Pedido</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <%@ include file="./Components/Header.jspf" %>

        <main>
            <div class="container mt-5" id="lista">                                
                <h4>Pedido: ${numPedido}</h4>

                <h5 class="mt-4">Endere�o de Entrega:</h5>
                <p><c:out value="${listaEndereco.getCep()}" /> - <c:out value="${listaEndereco.getRua()}" /></p>

                <h5 class="mt-4">Hora da Solicita��o:</h5>
                <p>${horaAcesso}</p>

                <h5 class="mt-4">Metodo de pagamento:</h5>
                <p>${pagamento}</p>                    

                <div class="mt-5" style="width:100%">
                    <ul class="cart-label-row">
                        <li class="cart-label __large">Produto</li>
                        <li class="cart-label __small">Pre�o</li>
                        <li class="cart-label">Quantidade</li>
                        <li class="cart-label">Total</li>
                    </ul>

                    <c:forEach items="${listaItemPedido}" var="listaItemPedido" >
                        <div class="product-list">
                            <input type="hidden" value="${listaItemPedido.getIdProduto()}" name="idProd" id="idProd" />
                            <div class="product__image">
                                <p class="product__name">
                                    <c:out value = "${listaItemPedido.getNomeProduto()}"/>
                                </p>
                            </div>
                            <div class="product__price">
                                <c:out value = "${listaItemPedido.getValorUnitario()}"/>
                            </div>
                            <div class="product__ammount">
                                <c:out value="${listaItemPedido.getQuantidade()}"/>
                            </div>
                            <div class="product__total">
                                <c:out value = "${listaItemPedido.getValorTotal()}"/>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="row mt-5 mb-5">
                    <div class="col cart-text">
                        <label>FRETE: R$ 10,00</label>
                    </div>
                    <div class="col cart-text">
                        <label>TOTAL: </label>
                        <label> ${SubTotal}</label>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="./Components/Footer.jspf" %>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
                integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>