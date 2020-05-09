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
            <div class="container">
                <h3>Validar Pedido</h3>
                <hr>
            </div>
            <div class="container" id="lista">
                <div class="row">
                    <div class="col">
                        <h4>Endereço de Entrega</h4>
                        <article class="card mt-3">
                            <div class="card-body justify-content-between">
                                <div class="d-flex flex-row" disabled>
                                    <input type="hidden" value="${idEntrega}" name="idEntrega" id="idEntrega" />
                                    <h5 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getCep()}" /></h5>
                                    <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getRua()}" /></h6>
                                </div>
                            </div>
                        </article>
                    </div>
                </div>
                <br>
                <h4>Metodo de pagamento</h4>
                <c:out value="${pagamento}"></c:out>
                    <div class="row">
                        <div class="mt-5" style="width:100%">
                            <ul class="cart-label-row">
                                <li class="cart-label __large">Produto</li>
                                <li class="cart-label __small">Preço</li>
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
                </div>
                <div class="row">
                    <div class="col">
                        <label>Frete: R$ 10,00</label>
                    </div>
                    <div class="col">
                        <label>TOTAL: </label>
                        <label> ${SubTotal}</label>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <form name="QuantidadeDiminuir" method="post"
                              action="${pageContext.request.contextPath}/FinalizarCompras" novalidate>
                            <button type="submit" class="btn btn-success">Concluir Compra</button>
                        </form>
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