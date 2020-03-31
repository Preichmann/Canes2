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
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="src/img/logoCanesBlack.png" width="150" height="90" class="d-inline-block align-top" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="navbar-nav mr-auto">
                        <form method="get" action="${pageContext.request.contextPath}/top-10" class="nav-item active" novalidate>
                            <input type="submit" value="Top 10" class="nav-link active">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/perdaDePeso" class="nav-item" novalidate>
                            <input type="submit" value="Perda de Peso" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/preTreino" class="nav-item" novalidate>
                            <input type="submit" value="Pré Treino" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ganhoDeMassa" class="nav-item" novalidate>
                            <input type="submit" value="Ganho de Massa" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/recuperacaoMuscular" class="nav-item"
                              novalidate>
                            <input type="submit" value="Recuperação Muscular" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ProdutoCadastrar" class="nav-item active" novalidate>
                            <input type="submit" value="Cadastrar Produto" class="nav-link active">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" class="nav-item" novalidate>
                            <input type="submit" value="Listar Produtos" class="nav-link">
                        </form>	
                        <form method="get" action="${pageContext.request.contextPath}/FuncionarioCadastrar" class="nav-item" novalidate>
                            <input type="submit" value="Cadastrar Funcionario" class="nav-link">
                        </form>
                    </div>

                    <div class="d-flex user-options">
                        <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                            <input type="submit" value="Carrinho" class="nav-link">
                        </form>

                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Nome do Usuário
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Trocar Senha</a>
                                <a class="dropdown-item" href="#">Sair</a>
                            </div>
                        </div>
                    </div>          
                </div>
            </nav>
        </header>

        <main>
            <section id="carrossel">
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="3000">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="src/img/carrossel-img1.jpg" class="imagem-carrossel d-block w-100"
                                 alt="barraca de frutas e verduras em uma feira livre">
                            <div class="carousel-caption h-50 d-none d-md-block">
                                <h2 class="fonte-titulo display-4"></h2> <!-- Frase 1 -->
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="src/img/carrossel-img2.jpg" class="imagem-carrossel d-block w-100"
                                 alt="tigelas com ingredientes culinários sendo manuseadas por pessoas, vistas de cima">
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
                    <h1 class="fonte-titulo texto-cor-especial">O suplemento ideal para seu esporte</h1>
                    <p class="text-secondary"></p> <!-- Frase secundária -->
                </div>
            </section>

            <section id="produtos" class="pb-5">
                <div class="container d-flex flex-wrap justify-content-md-around justify-content-center">
                    <c:forEach items="${listaProdutoAtt}" var="listaProd" varStatus="theCounter">
                        <article class="card borda-cor-especial card-largura p-0 m-2 col-12 col-md-3"> 

                            <!-- card borda-cor-especial card-largura  -->

                            <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd${theCounter.index}" />
                            <img src="${listaProd.getCaminho()}" class="card-img-top card-imagem-posicao" alt="" id="imgProd${theCounterImg.index}">

                            <div class="card-body">
                                <form name="ProdutoDetalhar" method="post"
                                      action="${pageContext.request.contextPath}/ProdutoDetalhar" novalidate>
                                    <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd${theCounter.index}" />
                                    <h5 class="card-title">${listaProd.getNome()}</h5>
                                    <p class="card-text">R$ ${listaProd.getPreco()}</p>
                                    <input type="submit" class="btn btn-danger" value="Detalhes" class="btn btn-cor-especial">
                                </form>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </section>
        </main>

        <footer class="fixed-bottom text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>

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