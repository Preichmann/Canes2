<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <body>
        <%@ include file="./Components/Header.jspf" %>

        <main>
            <script>
                if (${ senhaAtt } === true) {
                    alert("Senha ou usuario Inválidos");
                }
            </script>
            <script>
                if (${ retornoCadastroEntrega } === true) {
                    alert("Sucesso ao cadastrar Endereço de Entrega");
                }
            </script>
            <script>
                if (${ retornoCadastroFat } === true) {
                    alert("Sucesso ao cadastrar Endereço de Faturamento");
                }
            </script>
            <script>
                if (${ MsgCarrinho } !== null) {
                    alert(${ MsgCarrinho });
                }
            </script>

            <div class="d-flex justify-content-center">
                <div class="login_card mt-5 mb-5">
                    <article class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>
                            <h4 class="card-title mb-4 mt-1">Fazer login</h4>
                            <div class="form-group">
                                <label for="usuario">Usuário</label>
                                <input name="usuario" id="usuario" class="form-control" placeholder="Usuário" type="email">
                                <span class="error">
                                    <p id="user_error"></p>
                                </span>
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha</label>
                                <input name="senha" id="senha" class="form-control" placeholder="******" type="password">
                                <span class="error">
                                    <p id="senha_error"></p>
                                </span>            
                            </div>
                            <div class="form-group">
                                <input type="submit" name="loginBtn" value="Login" class="btn btn-cor-especial btn-block">
                            </div>
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/ClienteCadastrar" novalidate>
                            <input type="submit" name="" value="Criar sua conta na Canes Suplementos" class="btn btn-secondary btn-block">
                        </form>
                    </article>
                </div>
            </div>
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