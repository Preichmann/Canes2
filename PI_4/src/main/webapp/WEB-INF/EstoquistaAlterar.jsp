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

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/EstoquistaListar">
                    <img src="src/img/logoCanesBlack.png" width="150" height="90" class="d-inline-block align-top" alt="">
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
                    </div>

                    <div class="d-flex user-options">
                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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

        <div class="container">
            <h3>Atualizar Estoque</h3>
            <hr>

            <form id="SalvarImagem" name="AlterarProduto" method="post"
                  action="${pageContext.request.contextPath}/EstoquistaAlterar" novalidate>

                <div class="form-group">
                    <label for="produtoNome">Produto</label>
                    <input type="text" class="form-control" name="produtoNome" id="produtoNome" value="${ProdutoAtt.getNome()}" disabled="true">
                    <input type="hidden" value="${ProdutoAtt.getIdProd()}" name="idProd" id="idProd" />
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="produtoQuantidadeEstoque">Quantidade em Estoque</label>
                        <input type="text" class="form-control" name="quantidade" value="${ProdutoAtt.getQuantidade()}" id="quantidade">
                    </div>
                </div>
                <input type="submit" value="Atualizar Estoque" class="btn btn-success col-2" />
            </form>

            <form method="get" action="${pageContext.request.contextPath}/EstoquistaListar" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>

            <footer class="fixed-bottom text-center footer p-2">
                <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
                <p>2020 - Todos os direitos reservados</p>
            </footer>

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