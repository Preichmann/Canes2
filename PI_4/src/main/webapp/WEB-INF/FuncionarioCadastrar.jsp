<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Cadastrar Funcionario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <script>
            if (${retorno} === true) {
                alert('Funcionario Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o Funcionario!');
            }
        </script>
        <script>
            if (${NomeFalha} === false) {
                alert('Nome com menos que 5 caracteres');
            }
        </script>
        <script>
            if (${EmailFalha} === false) {
                alert('Formato do e-mail digitado está errado');
            }
        </script>
        <script>
            if (${UserFalha} === false) {
                alert('Campo com usuário não foi preenchido');
            }
        </script>
        <script>
            if (${senhaFalha} === false) {
                alert('Campo com Senha não foi preenchido');
            }
        </script>
        <script>
            if (${tipoFalha} === false) {
                alert('Campo com tipo não foi Selecionado');
            }
        </script>

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

        <div class="container mt-5">
            <h3 class="title-default mb-5">Cadastrar Funcionário</h3>

            <form method="post" action="${pageContext.request.contextPath}/FuncionarioCadastrar" novalidate>
                <div class="form-group">
                    <label for="funcionarioNome">Nome</label>
                    <input type="text" class="form-control" name="funcionarioNome" id="funcionarioNome" placeholder="Nome">
                </div>
                
                <div class="form-group">
                    <label for="funcionarioEmail">Email</label>
                    <input type="text" class="form-control" name="funcionarioEmail" id="funcionarioEmail" placeholder="Email">
                </div>
                
                <div class="form-group">
                    <label for="funcionarioUser">Usuário</label>
                    <input type="text" class="form-control" name="funcionarioUser" id="funcionarioUser" placeholder="Usuário">
                </div>

                <div class="form-group">
                    <label for="funcionarioSenha">Senha</label>
                    <input type="password" class="form-control" name="funcionarioSenha" id="funcionarioSenha" placeholder="Senha">
                </div>

                <div class="form-group">
                    <label for="tipo">Tipo</label><span class="obrigatorio">*</span>
                    <br>
                    <label for="radioAdministrador">Administrador</label>
                    <input type="radio" class="radio" name="tipo" id="radioAdministrador" value="Administrador" />
                    <br>
                    <label for="radioEstoquista">Estoquista</label>
                    <input type="radio" class="radio" name="tipo" id="radioEstoquista" value="Estoquista" />
                    <span class="error"><p id="sexo_error"></p></span>
                </div>

                <div class="custom-control custom-switch mb-5">
                    <input type="checkbox" class="custom-control-input" name="FuncionarioDisponivel" id="FuncionarioDisponivel" checked="true">
                    <label class="custom-control-label" for="FuncionarioDisponivel">Disponível</label>
                </div>

                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>

            <form class="mb-5 mt-3" method="get" action="${pageContext.request.contextPath}/menu-FuncionarioListar" novalidate>
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