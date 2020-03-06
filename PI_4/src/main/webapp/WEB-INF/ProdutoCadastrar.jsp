<!--<%-- 
    Document   : cadastroProduto
    Created on : 01/03/2020, 12:48:05
    Author     : Beatriz da Silva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Cadastrar Produtos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
          <!-- <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" /> -->
          <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" /> -->
          <!--<script src="${pageContext.request.contextPath}/javaScript/validar.js" type="text/javascript"></script> -->
    </head>

    <body>
        <script>
            if (${resultAtt} === true) {
                alert('Produto Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o Produto!');
            }
        </script> 
        <script>
            if (${SalvarIMGAtt} === true) {
                alert('IMG Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o IMG EU SEI È SO PRA VALIDARRRRRRRRRR!');
            }
        </script> 
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="src/img/logoCanesBlack.png" width="150" height="90" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <form method="get" action="${pageContext.request.contextPath}/top-10" class="nav-item active"
                          novalidate>
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
                </ul>
            </div>
        </nav>

        <div class="container">
            <h3>Cadastrar Produto</h3>
            <hr>

            <form id="SalvarImagem" name="ProdutoCadastrar" method="post"
                  action="${pageContext.request.contextPath}/ProdutoCadastrar" novalidate>

                <div class="form-group">
                    <label for="produtoNome">Produto</label>
                    <input type="text" class="form-control" name="produtoNome" id="produtoNome" placeholder="Produto">
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
                    <!--
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                              <span class="input-group-text">R$</span>
                              <span class="input-group-text">0.00</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Real amount (with dot and two decimal places)">
                        </div>
                    -->

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
                    <h4>${listaPergunta.getPergunta()}</h4>
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
                <div class="form-group">
                    <label for="image">Imagem do Produto</label>
                    <input type="file" name="file" id="file" class="form-control" />
                </div>

                
                <input type="submit" value="Salvar" class="btn btn-success col-2" />
            </form>

            <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>

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