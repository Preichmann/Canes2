<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#cep").on("change", function () {
                    if (this.value) {
                        $.ajax({
                            url: 'http://api.postmon.com.br/v1/cep/' + this.value,
                            dateType: "json",
                            crossDomain: true,
                            statusCode: {
                                200: function (data) {
                                    //console.log(data);

                                    $("#cep").addClass("is-valid");
                                    $("#logradouro").val(data.logradouro);
                                    $("#bairro").val(data.bairro);
                                    $("#cidade").val(data.cidade);
                                    $("#estado").val(data.estado);
                                },
                                400: function (msg) {
                                    console.log(msg); //Request error
                                },
                                404: function (msg) {
                                    console.log(msg); //Cep inválido
                                }
                            }
                        })
                    }
                });
            });
        </script>
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <script>
            if (${retornoNome} == false) {
                alert('O campo nome precisa conter no minimo 2 palavras cada uma com no minimo 3 letras');
            }
        </script>
        <script>
            if (${retornoEmail} == false) {
                alert('Email digitado é invalido');
            }
        </script>
        <script>
            if (${retornoSenha} == false) {
                alert('Senha não pode ser vazia');
            }
        </script>
        <script>
            if (${retornoCPF} == false) {
                alert('CPF digitado invalido');
            }
        </script>
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
                        <form method="get" action="${pageContext.request.contextPath}/Login" class="nav-item"
                              novalidate>
                            <input type="submit" value="Login" class="nav-link">
                        </form>
                        <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                            <input type="submit" value="Carrinho" class="nav-link">
                        </form>

                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Nome do Usuário
                                ${sessionScope.usuarioLogado.nome}
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
        <div class="container">
            <h3>Cadastro</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrar" novalidate>

                <div class="form-group">
                    <label for="clienteNome">Nome</label>
                    <input type="text" class="form-control" name="clienteNome" id="clienteNome" placeholder="Nome Completo">
                </div>

                <div class="form-group">
                    <label for="clienteEmail">E-mail</label>
                    <input type="text" class="form-control" name="clienteEmail" id="clienteEmail" placeholder="Ex: Email@dominio.com">
                </div>

                <div class="form-group">
                    <label for="clienteSenha">Senha</label>
                    <input type="password" class="form-control" name="clienteSenha" id="clienteSenha" placeholder="Senha">
                </div>

                <div class="form-group">
                    <label for="clienteCPF">CPF</label>

                    <input type="text" class="form-control" name="clienteCPF" id="clienteCPF" maxlength="11" placeholder="Somente os Números">
                </div>

                <label>Endereço de Entrega:</label>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label>
                        <input type="number" class="form-control" name="cep" id="cep"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endereço</label>
                        <input type="text" class="form-control" name="logradouro" id="logradouro"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Número</label>
                        <input type="number" class="form-control" name="numero" id="numero"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="bairro"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Cidade</label>
                        <input type="text" class="form-control" name="cidade" id="cidade"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Estado</label>
                        <input type="text" class="form-control" name="estado" id="estado"><br>
                    </div>
                </div>

                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
            <form method="get" action="${pageContext.request.contextPath}/menu-FuncionarioListar" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>
        </div>
    </body>
</html>