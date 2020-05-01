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
                                    console.log(msg); //Cep inválido
                                }
                            }
                        })
                    }
                });
            });
        </script>
        <title>Cadastrar Endereço de Entrega</title>
    </head>
    <body>
        <script>
            if (${RetornoCepVal} === false) {
                alert('CEP Digitado Invalido');
            }
        </script>
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

        <%@ include file="./Components/Header.jspf" %>
        <div class="container">
            <h3>Cadastro de Endereço de Entrega</h3>
            <hr>
            <form method="post" action="${pageContext.request.contextPath}/CadastrarEntrega" novalidate>
                <label>Endereço de Entrega:</label>
                <input type="hidden" class="form-control" name="cepValidar" id="cepValidar" value=""><br>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="Somente números"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endereço</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Número</label><span class="obrigatorio">*</span>
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
                <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${idCliente}">
                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
        </div>

        <footer class="text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>