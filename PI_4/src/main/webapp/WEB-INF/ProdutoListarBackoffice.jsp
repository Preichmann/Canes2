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
    <script>
        function confirmaExclusao() {
            if (confirm("Tem certeza que deseja deletar excluir esse produto?")) {
                document.getElementById("idConfirma").value = 1;
            } else {
                document.getElementById("idConfirma").value = 0;
            }
        }
    </script>

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
            <section id="produtos" class="pb-5">
                <div class="container">
                    <c:forEach items="${ListaProdAtt}" var="listaProd">
                        <article class="card mt-3">
                            <div class="card-body justify-content-between">
                                <div class="d-flex flex-row">
                                    <form class="d-flex flex-row justify-content-between" style="width: 100%;" name="ProdutoListar" method="post"
                                          action="${pageContext.request.contextPath}/ProdutoListarBackoffice" novalidate>
                                        <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                                        <h5 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaProd.getNome()}" /></h5>
                                        <p class="card-text" style="margin: 0;display: flex;align-items: center;"><span>R$</span><c:out value="${listaProd.getPreco()}" /></p>
                                        <input type="submit" class="btn btn-primary" value="Editar" class="btn btn-cor-especial">
                                    </form>
                                    <form class="d-flex ml-1" id="SalvarImagem" name="ProdutoExcluir" method="post"
                                          action="${pageContext.request.contextPath}/ProdutoExcluir" novalidate>
                                        <input type="hidden" value="${listaProd.getIdProd()}" name="idProd" id="idProd" />
                                        <input type="hidden" name="idConfirma" id="idConfirma" />
                                        <input type="submit" class="btn btn-danger" value="Excluir" class="btn btn-cor-especial" onclick="confirmaExclusao()">
                                    </form>
                                </div>
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