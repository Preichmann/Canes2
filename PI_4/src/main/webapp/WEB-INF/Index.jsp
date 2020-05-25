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
        <script>
            if (${ msg }) {
                alert('Você saiu do Sistema!');
            }
        </script>
        <script>
            if (${ msgCarrinhoVazio }) {
                alert('Adicione Produtos a sua lista para Finalizar a Compra');
            }
        </script>
        <script>
            if (${ retornoAlterar } === true) {
                alert('Dados Pessoais alterados com sucesso');
            }
        </script>
        <script>
            if (${ msgFimCompra } === false) {
                alert('Falha ao concluir a inclusao do Pedido no Banco de dados');
            }else{
                alert('Numero do pedido ' + ${numPedido} + ' ' + 'Valor Total da Compra: ' + ${valorTotal});
            }
        </script>

        <%@ include file="./Components/Header.jspf" %>

        <main>
            <section id="carrossel">
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="3000">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="src/img/carrossel-img1.jpg" class="imagem-carrossel d-block w-100">
                            <div class="carousel-caption h-50 d-none d-md-block">
                                <h2 class="fonte-titulo display-4"></h2> <!-- Frase 1 -->
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="src/img/carrossel-img2.jpg" class="imagem-carrossel d-block w-100">
                            <div class="carousel-caption h-50 d-none d-md-block">
                                <h2 class="fonte-titulo display-4"></h2> <!-- Frase 2 -->
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </section>

            <section id="titulo">
                <div class="bg-light text-center py-5 px-2 mb-4">
                    <h2 class="fonte-titulo">O suplemento ideal para seu esporte</h2>
                </div>
            </section>

            <section id="produtos" class="pb-5">
                <div class="container d-flex flex-wrap">
                    <c:forEach items="${listaProdutoAtt}" var="listaProd" varStatus="theCounter"> 
                        <form name="ProdutoDetalhar" method="post" class="card-produto" action="${pageContext.request.contextPath}/ProdutoDetalhar" novalidate>
                            <input type="hidden" value="${listaProd.getIdProd()}" name="idProd"
                                   id="idProd${theCounter.index}" />
                            
                            <div class="card-image">
                                <img src="${listaProd.getCaminho()}" alt="${listaProd.getNome()}"
                                     id="imgProd${theCounterImg.index}">
                            </div>
                            
                            <div class="card-body">
                                <p class="product-name">
                                    ${listaProd.getNome()}
                                </p>
                                <p class="product-price">R$ 
                                    ${listaProd.getPreco()}
                                </p>
                            </div>
                            
                            <input type="submit" class="card-cta" value="Comprar">
                        </form>
                    </c:forEach>
                </div>
            </section>
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