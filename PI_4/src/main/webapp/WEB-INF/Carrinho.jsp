<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Carrinho</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="src/style.css">
</head>

<body>

    <%@ include file="./Components/Header.jspf" %>

    <main>
        <div class="container">
            <h3>Meu Carrinho</h3>
            <hr>
        </div>
        <div class="container">
            <div class="mt-5">
                <ul class="cart-label-row">
                    <li class="cart-label __large">Produto</li>
                    <li class="cart-label __small">Preço</li>
                    <li class="cart-label">Quantidade</li>
                    <li class="cart-label">Total</li>
                </ul>
                <div class="product-list">
                    <c:forEach items="${ListaProdAtt}" var="listaProd" style="width:100%">
                        <form class="product" method="post" action="${pageContext.request.contextPath}/"
                            name="ProdutoListar" novalidate>
                            <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                            <div class="product__image">
                                <img src="http://placehold.it/100x100" />
                                <!-- incluir img url -->
                                <p class="product__name">
                                    nome
                                    <!-- incluir c:out para nome do produto  -->
                                </p>
                            </div>
                            <div class="product__price">
                                preco
                                <!-- incluir c:out para preco do produto -->
                            </div>
                            <div class="product__ammount">
                                <!-- incluir c:out para quantidade, e adicionar logica para os botoes de adicao/subtracao -->
                                <div onclick=""><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                        viewBox="0 0 24 24">
                                        <path d="M24 10h-10v-10h-4v10h-10v4h10v10h4v-10h10z" /></svg></div>
                                <input type="text" id="#qtde" value="0" />
                                <div onclick=""><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                        viewBox="0 0 24 24">
                                        <path d="M0 10h24v4h-24z" /></svg></div>
                            </div>
                            <div class="product__total">
                                valor total
                                <!-- incluir c:out para valor do produto -->
                            </div>
                        </form>
                    </c:forEach>
                </div>

            </div>

            <!--<div class="mt-3 mb-3">
                <form>
                    <label for="cep">Entrega</label>
                    <input id="cep" class="" value="" placeholder="Informe seu CEP" maxlength="9">
                    <button type="submit" class="btn btn-secondary">Calcular</button>
                </form>
            </div>-->


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