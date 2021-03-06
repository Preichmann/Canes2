<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Cadastrar Produtos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"> 
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <header>
            <script>
                if (${SalvarIMGAtt} === true) {
                    alert('Produto Salvo Com sucesso!');
                } else {
                    alert('Falha ao Salvar o Produto!');
                }
                if (${result2Att} === true) {
                    alert('Produto Alterado Com sucesso!');
                } else {
                    alert('Falha ao Alterar o Produto!');
                }
            </script> 

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

        <div class="container mt-5">
            <h3 class="title-default mb-5">Cadastrar Produto</h3>

            <form id="SalvarImagem" name="ProdutoCadastrar" method="post"
                  action="${pageContext.request.contextPath}/ProdutoCadastrar" novalidate>

                <div class="form-group">
                    <label for="produtoNome">Produto</label>
                    <input type="text" class="form-control" name="produtoNome" id="produtoNome" placeholder="Nome do Produto">
                </div>

                <div class="form-group">
                    <label for="produtoDescricao">Descrição</label>
                    <textarea class="form-control" name="produtoDescricao" id="produtoDescricao" rows="3"></textarea>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="produtoValorUnitario">Valor Unitário</label>
                        <input type="text" class="form-control" name="produtoValorUnitario" id="produtoValorUnitario" placeholder="">
                    </div>

                    <div class="form-group col-md-4">
                        <label for="produtoQuantidadeEstoque">Quantidade em Estoque</label>
                        <input type="text" class="form-control" name="produtoQuantidadeEstoque" id="produtoQuantidadeEstoque" placeholder="">
                    </div>

                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" name="produtoDisponivel" id="produtoDisponivel">
                        <label class="custom-control-label" for="produtoDisponivel">Disponível</label>
                    </div>
                </div>
                <c:forEach items="${ListaPerguntaAtt}" var="listaPergunta" varStatus="theCount">
                    <input type="hidden" value="${listaPergunta.getIdPergunta()}" name="idPergunta${theCount.index}" id="idPergunta${theCount.index}" />
                    <label for="resposta${theCount.index}">${listaPergunta.getPergunta()}</label>
                    <textarea class="form-control" name="resposta${theCount.index}" id="resposta${theCount.index}" rows="3"></textarea>
                </c:forEach>
                <fieldset>
                    <legend>Objetivos</legend>
                    <c:forEach items="${ListaObjetivoAtt}" var="listaObjetivo" varStatus="theCounter">
                        <input type="hidden" value="${listaObjetivo.getIdObjetivo()}" name="idObjetivo${theCounter.index}" id="idObjetivo${theCounter.index}" />
                        <p><input type="checkbox" name="Objetivo${theCounter.index}" id="Objetivo${theCounter.index}">
                            <label for="Objetivo${theCounter.index}">${listaObjetivo.getDescricaoObj()}</label>
                        </p>
                    </c:forEach>
                </fieldset>
                <fieldset>
                    <legend>Categorias</legend>
                    <c:forEach items="${ListaCategoriaAtt}" var="listaCategoria" varStatus="theCounters">
                        <input type="hidden" value="${listaCategoria.getIdCategoria()}" name="idCategoria${theCounters.index}" id="idCategoria${theCounters.index}" />
                        <p><input type="checkbox" name="Categoria${theCounters.index}" id="Categoria${theCounters.index}">
                            <label for="Categoria${theCounters.index}">${listaCategoria.getNome()}</label>
                        </p>
                    </c:forEach>
                </fieldset>

                <input type="submit" value="Adicionar Imagens" class="btn btn-success col-2" />
            </form>

            <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>
        </div>

        <%@ include file="./Components/Footer.jspf" %>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    </body>
</html>