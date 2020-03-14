<!DOCTYPE html>
<%-- Alterar o padrão para JSP --%>
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
                    <ul class="navbar-nav mr-auto">
                        <form method="get" action="${pageContext.request.contextPath}/ProdutoCadastrar" class="nav-item active" novalidate>
                            <input type="submit" value="Cadastrar Produto" class="nav-link active">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" class="nav-item" novalidate>
                            <input type="submit" value="Listar Produtos" class="nav-link">
                        </form>
                    </ul>
                </div>
            </nav>
        </header>

        <main>

            <section id="produtos" class="bg-light pb-5">
                <div class="container d-flex flex-wrap justify-content-md-around justify-content-center">
                    <c:forEach items="${ListaProdAtt}" var="listaProd">
                        <article class="card borda-cor-especial card-largura mt-5">
                            <div class="card-body">
                                <form id="SalvarImagem" name="ProdutoListar" method="post"
                                      action="${pageContext.request.contextPath}/ProdutoListarBackoffice" novalidate>
                                    <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                                    <h5 class="card-title"><c:out value="${listaProd.getNome()}" /></h5>
                                    <p class="card-text"><c:out value="${listaProd.getPreco()}" /></p>
                                    <input type="submit" value="Editar" class="btn btn-cor-especial">
                                </form>
                                <form id="SalvarImagem" name="ProdutoAlterar" method="post"
                                      action="${pageContext.request.contextPath}/ProdutoAlterar" novalidate>
                                    <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                                    <input type="submit" value="Excluir" class="btn btn-cor-especial">
                                </form>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </section>

        </main>

        <footer id="footer" class="bg-secondary py-3 mx-auto">
            <p class="text-center m-0"><a href="#" class="text-light text-decoration-none">contato: email@canes.com.br</a></p>
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