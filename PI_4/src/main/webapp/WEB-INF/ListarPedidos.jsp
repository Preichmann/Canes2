<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Canes Suplementos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <%@ include file="./Components/Header.jspf" %>

        <main>
            <div class="container mt-5" id="produtos">
                <h3 class="title-default mb-5">Meus Pedidos</h3>
                <article>
                        <div class="d-flex flex-row">
                            <h6 class="cart-label"><c:out value="ID Pedido" /></h6>
                            <h6 class="cart-label"><c:out value="Horario da Compra" /></h6>
                            <h6 class="cart-label"><c:out value="Valor Pedido" /></h6>
                            <h6 class="cart-label"><c:out value="Status" /></h6>
                        </div>
                </article>
                <c:forEach items="${ListaPedidos}" var="listaPedidos">
                    <article class="mb-5">
                        <div class="card-body justify-content-between">
                            <div class="d-flex flex-row">
                                <form class="d-flex flex-row justify-content-between" style="width: 100%;" name="DetalhePedido" method="post"
                                      action="${pageContext.request.contextPath}/DetalhePedido" novalidate>
                                    <input type="hidden" name="idPedido" value="${listaPedidos.getIdPedido()}">
                                    <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaPedidos.getIdPedido()}" /></h6>
                                    <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaPedidos.getHoraPedido()}" /></h6>
                                    <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaPedidos.getValorPedido()}" /></h6>
                                    <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaPedidos.getStatus()}" /></h6>
                                    <input type="submit" class="btn btn-primary" value="Detalhe" class="btn btn-cor-especial">
                                </form>
                            </div>
                        </div>
                    </article>
                </c:forEach>
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
