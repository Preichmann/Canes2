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
        <script>
            $(document).ready(function () {
                $("#cep2").on("change", function () {
                    if (this.value) {
                        $.ajax({
                            url: 'http://api.postmon.com.br/v1/cep/' + this.value,
                            dateType: "json",
                            crossDomain: true,
                            statusCode: {
                                200: function (data) {
                                    //console.log(data);

                                    $("#cep2").addClass("is-valid");
                                    $("#logradouro2").val(data.logradouro);
                                    $("#bairro2").val(data.bairro);
                                    $("#cidade2").val(data.cidade);
                                    $("#estado2").val(data.estado);
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
        <script>
            function copyFromTextbox(id) {
                var textToCopy = document.getElementById('cep').value;
                var whereToCopy = document.getElementById("cep2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('logradouro').value;
                var whereToCopy = document.getElementById("logradouro2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('numero').value;
                var whereToCopy = document.getElementById("numero2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('complemento').value;
                var whereToCopy = document.getElementById("complemento2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('bairro').value;
                var whereToCopy = document.getElementById("bairro2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('cidade').value;
                var whereToCopy = document.getElementById("cidade2");
                whereToCopy.value = textToCopy;
                var textToCopy = document.getElementById('estado').value;
                var whereToCopy = document.getElementById("estado2");
                whereToCopy.value = textToCopy;
            }
        </script>
        <title>Cadastrar Endereço de Entrega</title>
    </head>
    <body>
        <script>
            if (${RetornoCep2} == false) {
                alert('CEP do campo de faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCep} == false) {
                alert('CEP do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoRua2} == false) {
                alert('RUA do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoRua} == false) {
                alert('RUA do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoNum2} == false) {
                alert('Numero do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoNum} == false) {
                alert('Numero do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoBairro2} == false) {
                alert('Bairro do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoBairro} == false) {
                alert('Bairro do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCidade2} == false) {
                alert('Cidade do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCidade} == false) {
                alert('Cidade do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoEstado2} == false) {
                alert('Estado do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoEstado} == false) {
                alert('Estado do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${retornoCadastrarFaturamento} == false) {
                alert('Falha com o Banco de dados para cadastrar o endereço de Faturamento');
            }
        </script>
        <script>
            if (${retornoCadastrarEntrega} == false) {
                alert('Falha com o Banco de dados para cadastrar o endereço de Entrega');
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
                        <form method="get" action="${pageContext.request.contextPath}/Login" class="nav-item"
                              novalidate>
                            <input type="submit" value="Login" class="nav-link">
                        </form>
                    </div>          
                </div>
            </nav>
        </header>
        <div class="container">
            <h3>Cadastro de Endereço de Entrega</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrarEnderecoEntrega" novalidate>
                <label>Endereço de Entrega:</label>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span>*</span>
                        <input type="number" class="form-control" name="cep" id="cep"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endereço</label><span>*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Número</label><span>*</span>
                        <input type="number" class="form-control" name="numero" id="numero"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Bairro</label><span>*</span>
                        <input type="text" class="form-control" name="bairro" id="bairro"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Cidade</label><span>*</span>
                        <input type="text" class="form-control" name="cidade" id="cidade"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Estado</label><span>*</span>
                        <input type="text" class="form-control" name="estado" id="estado"><br>
                    </div>
                </div>
                <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${idCliente}">

                <div class="col-sm-2" >
                    <label>Copiar dados de entrega para faturamento:</label>
                    <button class="btn-padrao" type="button" id="copiar" name="copiar" onClick="copyFromTextbox();">Copiar</button>
                </div>

                <label>Endereço de Faturamento:</label>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span>*</span>
                        <input type="number" class="form-control" name="cep2" id="cep2"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endereço</label><span>*</span>
                        <input type="text" class="form-control" name="logradouro2" id="logradouro2"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Número</label><span>*</span>
                        <input type="number" class="form-control" name="numero2" id="numero2"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Complemento</label>
                        <input type="text" class="form-control" name="complemento2" id="complemento2"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Bairro</label><span>*</span>
                        <input type="text" class="form-control" name="bairro2" id="bairro2"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Cidade</label><span>*</span>
                        <input type="text" class="form-control" name="cidade2" id="cidade2"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Estado</label><span>*</span>
                        <input type="text" class="form-control" name="estado2" id="estado2"><br>
                    </div>
                </div>
                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
        </div>
    </body>
</html>