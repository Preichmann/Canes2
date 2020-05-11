<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar imagens</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <header>            
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
                        <form method="get" action="${pageContext.request.contextPath}/ProdutoCadastrar"
                              class="nav-item active" novalidate>
                            <input type="submit" value="Cadastrar Produto" class="nav-link active">
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice"
                              class="nav-item" novalidate>
                            <input type="submit" value="Listar Produtos" class="nav-link">
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/FuncionarioCadastrar" class="nav-item" novalidate>
                            <input type="submit" value="Cadastrar Funcionario" class="nav-link">
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/FuncionarioListar" class="nav-item" novalidate>
                            <input type="submit" value="Listar Funcionarios" class="nav-link">
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
        </header>

        <main class="container mt-5">
            <div class="form-group">
                <fieldset>
                    <legend>Imagens do Produto</legend>
                    <c:forEach items="${listaImagensAtt}" var="imagens" varStatus="theCounter">
                        <form id="SalvarImagem" name="ExcluirImagem" method="post"
                              action="${pageContext.request.contextPath}/ExcluirImagem" novalidate>
                            <input type="hidden" value="${resultAtt}" name="idProd" id="idProd${theCounter.index}" />
                            <input type="hidden" value="${imagens.getIdImg()}" name="idImagem"
                                   id="idImagem${theCounter.index}" />
                            <input type="hidden" value="${imagens.getNome()}" name="nomeImg"
                                   id="nomeImg${theCounter.index}" />
                            <img src="https://storage.cloud.google.com/imagedb/${imagens.getNome()}"
                                 class="card-img-top card-imagem-posicao" alt="">
                            <input type="submit" value="Excluir" class="btn btn-padrao btn-danger m-1" />
                        </form>
                    </c:forEach>
                </fieldset>
                <hr>
            </div>
            <form id="SalvarImagem" name="SalvarImagem" method="post"
                  action="${pageContext.request.contextPath}/SalvarImagem" novalidate enctype='multipart/form-data'>
                <input type="hidden" value="${resultAtt}" name="idProd" id="idProd" />
                <input type="file" name="file" id="file" class="form-control" multiple="multiple" />
                <input type="submit" value="Salvar" class="btn btn-padrao btn-success m-1 mt-2" />
            </form>
            <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" class="nav-item"
                  novalidate>
                <input type="submit" value="Sair" class="btn btn-padrao btn-danger m-1 mb-5">
            </form>
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