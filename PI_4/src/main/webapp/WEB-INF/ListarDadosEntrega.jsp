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
            if (${retornoAlterar} === true) {
                alert('Funcionario Alterado Com sucesso!');
            } else {
                alert('Falha ao Alterar o Funcionario!');
            }
        </script>
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
                            <input type="submit" value="Pré Treino" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ganhoDeMassa" class="nav-item" novalidate>
                            <input type="submit" value="Ganho de Massa" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/recuperacaoMuscular" class="nav-item"
                              novalidate>
                            <input type="submit" value="Recuperação Muscular" class="nav-link">
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
                                <form method="get" action="${pageContext.request.contextPath}/ListarDadosEntrega" class="nav-item" novalidate>
                                    <input type="submit" value="Gerenciar dados de Entrega" class="nav-link">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/ListarDadosFaturamento" class="nav-item" novalidate>
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
            <section id="produtos" class="pb-5">
                <div class="container">
            <h2>Endereços de Entrega</h2>
                    <c:forEach items="${ListaEntrega}" var="listaEndereco">
                        <article class="card mt-3">
                            <div class="card-body justify-content-between">
                                <div class="d-flex flex-row">
                                    <form class="d-flex flex-row justify-content-between" style="width: 100%;" name="FuncionarioListar" method="post"
                                          action="${pageContext.request.contextPath}/ListarDadosEntrega" novalidate>
                                        <input type="hidden" value="${listaEndereco.getId_entrega()}" name="idEntrega" id="idEntrega" />
                                        <h5 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getCep()}" /></h5>
                                        <h6 class="card-title" style="width:200px;margin: 0;display: flex;align-items: center;"><c:out value="${listaEndereco.getRua()}" /></h6>
                                        <input type="submit" class="btn btn-primary" value="Editar" class="btn btn-cor-especial">
                                    </form>
                                </div>
                            </div>
                        </article>
                    </c:forEach>
                </div>
            </section>
        </main>

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
