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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/Index">
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
                            <input type="submit" value="Pr� Treino" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ganhoDeMassa" class="nav-item" novalidate>
                            <input type="submit" value="Ganho de Massa" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/recuperacaoMuscular" class="nav-item"
                              novalidate>
                            <input type="submit" value="Recupera��o Muscular" class="nav-link">
                        </form>
                    </div>

                    <div class="d-flex user-options">
                        <form method="get" action="${pageContext.request.contextPath}/Login" class="nav-item "
                              novalidate>
                            <input type="submit" id="LoginCliente" value="Login " class="nav-link">
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                            <input type="submit" value="Carrinho" class="nav-link">
                        </form>

                        <div class="nav-item dropdown" id="menuUsuario">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${NomeLogadoAtt}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterarDados" class="nav-item" novalidate>
                                    <input type="submit" value="Alterar Dados Pessoais" class="nav-link">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterarDados" class="nav-item" novalidate>
                                    <input type="submit" value="Gerenciar dados de Entrega" class="nav-link">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterarDados" class="nav-item" novalidate>
                                    <input type="submit" value="Gerenciar dados de Faturamento" class="nav-link">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/Logout" class="nav-item" novalidate>
                                    <input type="submit" value="Sair" class="nav-link">
                                </form>
                            </div>
                        </div>
                        <script>
                            var usuario = "${NomeLogadoAtt}";
                            if (usuario === "false") {
                                document.getElementById('menuUsuario').classList.add('d-none');
                            } else {
                                document.getElementById('LoginCliente').hidden = true;
                            }
                        </script>
                    </div>          
                </div>
            </nav>
        </header>

        <main>
            <div class="container">
                <div class="row">
                    <div id="carouselExampleControls" class="carousel slide col-md-6" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${ActiveImgAtt.getCaminho()}" class="d-block w-100" alt="...">
                            </div>
                            <c:forEach items="${ImagensAddAtt}" var="imagensAdicionais" varStatus="theCounters">
                                <div class="carousel-item">
                                    <img src="${imagensAdicionais.getCaminho()}" class="d-block w-100" alt="...">
                                </div>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>                

                    <div class="col-md-6">
                        <div class="row">
                            <!-- Colocar vari�vel pra receber dados do produto do banco -->
                            <h3>${ProdutoAtt.getNome()}</h3>
                        </div>
                        <div class="row">
                            <h4>R$ ${ProdutoAtt.getPreco()}</h4>
                        </div>
                        <div class="row">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle mt-2 mb-2" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Escolha o Sabor
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">Sabor 1</a>
                                    <a class="dropdown-item" href="#">Sabor 2</a>
                                    <a class="dropdown-item" href="#">Sabor 3</a>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <form method="post" action="${pageContext.request.contextPath}/carrinho" novalidate>
                                <input type="submit" value="Comprar" class="btn btn-cor-especial" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
                                
            <div class="container">
                <c:forEach items="${ListaPerguntaAtt}" var="listaPergunta" varStatus="theCount">
                    <input type="hidden" value="${listaPergunta.getIdPergunta()}" name="idPergunta${theCount.index}" id="idPergunta${theCount.index}" />
                    <label>${listaPergunta.getPergunta()}</label>
                    <textarea class="form-control" name="resposta${theCount.index}" id="resposta${theCount.index}" rows="3" readonly="true"></textarea>
                    <c:forEach items="${ListaRespostaProd}" var="listaResposta" varStatus="theCountResp">
                        <input type="hidden" value="${listaResposta.getIdPergunta()}" name="idPergunta${theCountResp.index}" id="idPergunta${theCountResp.index}" />
                        <script>
                            var r1 = document.getElementById("idPergunta${theCount.index}").value;
                            var r2 = document.getElementById("idPergunta${theCountResp.index}").value;
                            getResposta(r1, r2);
                            function getResposta(r1, r2) {
                                try {
                                    if (r1 === r2) {
                                        document.getElementById("resposta${theCount.index}").value = "${listaResposta.getResposta()}";
                                    }
                                } catch (err) {
                                    alert(err);
                                }
                            }
                        </script>
                    </c:forEach>
                </c:forEach>
            </div>
        </main>

        <footer class="text-center footer p-2">
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