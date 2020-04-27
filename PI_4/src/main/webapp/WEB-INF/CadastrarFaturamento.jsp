<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="src/style.css">
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
                                    $("#cepValidar").val("");
                                },
                                400: function (msg) {
                                    $("#cepValidar").val("falha");
                                    console.log(msg); //Request error
                                },
                                404: function (msg) {
                                    $("#cepValidar").val("falha");
                                    console.log(msg); //Cep inv�lido
                                }
                            }
                        })
                    }
                });
            });
        </script>
        <title>Cadastrar Endere�o de Entrega</title>
    </head>
    <body>
        <script>
            if (${RetornoCep2} == false) {
                alert('CEP do campo de faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCep} == false) {
                alert('CEP do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoRua2} == false) {
                alert('RUA do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoRua} == false) {
                alert('RUA do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoNum2} == false) {
                alert('Numero do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoNum} == false) {
                alert('Numero do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoBairro2} == false) {
                alert('Bairro do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoBairro} == false) {
                alert('Bairro do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCidade2} == false) {
                alert('Cidade do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCidade} == false) {
                alert('Cidade do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoEstado2} == false) {
                alert('Estado do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoEstado} == false) {
                alert('Estado do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${retornoCadastrarFaturamento} == false) {
                alert('Falha com o Banco de dados para cadastrar o endere�o de Faturamento');
            }
        </script>
        <script>
            if (${retornoCadastrarEntrega} == false) {
                alert('Falha com o Banco de dados para cadastrar o endere�o de Entrega');
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
                            <input type="submit" value="Pr� Treino" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ganhoDeMassa" class="nav-item" novalidate>
                            <input type="submit" value="Ganho de Massa" class="nav-link">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/recuperacaoMuscular" class="nav-item"
                              novalidate>
                            <input type="submit" value="Recupera��o Muscular" class="nav-link">
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
        <div class="container">
            <h3>Cadastro de Endere�o de Faturamento</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/CadastrarFaturamento" novalidate>
                <label>Endere�o de Faturamento:</label>
                <input type="hidden" class="form-control" name="cepValidar" id="cepValidar" value=""><br>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="Somente n�meros"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endere�o</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>N�mero</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="numero" id="numero"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Bairro</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="bairro" id="bairro"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Cidade</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="cidade" id="cidade"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Estado</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="estado" id="estado"><br>
                    </div>
                </div>
                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
        </div>
                
        <footer class="text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>