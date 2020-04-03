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
                        <form method="get" action="${pageContext.request.contextPath}/top-10" class="nav-item active"
                              novalidate>
                            <input type="submit" value="Top 10" class="nav-link active">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/perdaDePeso" class="nav-item"
                              novalidate>
                            <input type="submit" value="Perda de Peso" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/preTreino" class="nav-item"
                              novalidate>
                            <input type="submit" value="Pré Treino" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ganhoDeMassa" class="nav-item"
                              novalidate>
                            <input type="submit" value="Ganho de Massa" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/recuperacaoMuscular" class="nav-item"
                              novalidate>
                            <input type="submit" value="Recuperação Muscular" class="nav-link">
                        </form>

                        <div class="d-flex user-options">
                            <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                                <input type="submit" value="Carrinho" class="nav-link">
                            </form>

                            <div class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
            <script>
                if (${ senhaAtt } === true) {
                    alert("Senha ou usuario Inválidos");
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
                                <a class="float-right" href="#">Esqueceu a senha?</a>
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
                        <form method="post" action="${pageContext.request.contextPath}/" novalidate>
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