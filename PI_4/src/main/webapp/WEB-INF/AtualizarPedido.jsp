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
</head>
<body>
    <main>
        <div class="container">
            <h3>Pedido: ${numPedido}</h3>
            <hr>
        </div>
        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/AtualizarPedido" class="nav-item" novalidate>
                <input type="hidden" value="${numPedido}" name="idPedido" id="idPedido" />
                <label for="Status">Status:</label>
                <select class="custom-select" name="Status" id="Status">
                    <option>Aguardando Pagamento</option>
                    <option>Pagamento Rejeitado</option>
                    <option>Pagamento com sucesso</option>
                    <option>Aguardando Retirada</option>
                    <option>Em Transito</option>
                    <option>Entregue</option>
                </select>
                <script>
                    //Get select object
                    var objSelect = document.getElementById("Status");

                    //Set selected
                    setSelectedValue(objSelect, '${status}');

                    function setSelectedValue(selectObj, valueToSet) {
                        for (var i = 0; i < selectObj.options.length; i++) {
                            if (selectObj.options[i].text=== valueToSet) {
                                selectObj.value = valueToSet;
                                return;
                            }
                        }
                    }
                </script>
                <input type="submit" value="Alterar Status" class="btn btn-primary">
            </form>
            <hr>
        </div>
        <div class="container" id="lista">
            <div class="row">
                <div class="col">
                    <h4>Endereço de Entrega</h4>
                    <article class="card mt-3">
                        <div class="card-body justify-content-between">
                            <div class="d-flex flex-row" disabled>
                                <h5 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getCep()}" /></h5>
                                <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getRua()}" /></h6>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
            <br>
            <div>
                <h5>Hora da Solicitação : ${horaAcesso}</h5>
            </div>
            <h5>Metodo de pagamento : ${pagamento}</h5>
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