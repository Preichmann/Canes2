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
        <nav class="navbar navbar-expand-lg header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/Index">
                <img src="src/img/logoCanesWhite.png" width="150" height=90" style="padding:10px" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav mr-auto">
                    <form method="get" action="${pageContext.request.contextPath}/EstoquistaListar" class="nav-item" novalidate>
                        <input type="submit" value="Listar Produtos" class="nav-link">
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/ListarPedidosEstoque" class="nav-item" novalidate>
                        <input type="submit" value="Listar Pedidos" class="nav-link">
                    </form>
                </div>

                <div class="d-flex user-options">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${NomeLogadoAtt}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <form method="get" action="${pageContext.request.contextPath}/Logout" class="nav-item" novalidate>
                                <input type="submit" value="Sair" class="nav-link">
                            </form>
                        </div>
                    </div>
                </div>
            </div>             
        </nav>

        <main>
            <div class="container mt-5 mb-5" id="produtos">
                <h3 class="title-default mb-5">Produtos</h3>
                <c:forEach items="${ListaProdAtt}" var="listaProd">
                    <article class="card mt-3">
                        <div class="card-body justify-content-between">
                            <div class="d-flex flex-row">
                                <form class="d-flex flex-row justify-content-between" style="width: 100%;"
                                      name="ProdutoListar" method="post"
                                      action="${pageContext.request.contextPath}/EstoquistaListar" novalidate>
                                    <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                                    <h5 class="card-title" style="width:550px;margin: 0;display: flex;align-items: center;">
                                        <c:out value="${listaProd.getNome()}" />
                                    </h5>
                                    <p class="card-text" style="margin: 0;display: flex;align-items: center;">
                                        <span>Qtd </span>
                                        <c:out value="${listaProd.getQuantidade()}" />
                                    </p>
                                    <input type="submit" value="Atualizar estoque" class="btn btn-cor-especial">
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