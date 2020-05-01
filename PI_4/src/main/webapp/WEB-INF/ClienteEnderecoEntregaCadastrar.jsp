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
                                    $("#cepValidar2").val("");
                                },
                                400: function (msg) {
                                    $("#cepValidar2").val("falha");
                                    console.log(msg); //Request error
                                },
                                404: function (msg) {
                                    $("#cepValidar2").val("falha");
                                    console.log(msg); //Cep inv�lido
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
        <title>Cadastrar Endere�o de Entrega</title>
    </head>
    <body>
        <script>
            if (${RetornoCepVal} === false) {
                alert('CEP Digitado Invalido');
            }
        </script>
        
        <script>
            if (${RetornoCep2} === false) {
                alert('CEP do campo de faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCep} === false) {
                alert('CEP do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoRua2} === false) {
                alert('RUA do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoRua} === false) {
                alert('RUA do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoNum2} === false) {
                alert('Numero do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoNum} === false) {
                alert('Numero do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoBairro2} === false) {
                alert('Bairro do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoBairro} === false) {
                alert('Bairro do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCidade2} === false) {
                alert('Cidade do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoCidade} === false) {
                alert('Cidade do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoEstado2} === false) {
                alert('Estado do campo de Faturamento � Obrigat�rio');
            }
        </script>
        <script>
            if (${RetornoEstado} === false) {
                alert('Estado do campo de Entrega � Obrigat�rio');
            }
        </script>
        <script>
            if (${retornoCadastrarFaturamento} === false) {
                alert('Falha com o Banco de dados para cadastrar o endere�o de Faturamento');
            }
        </script>
        <script>
            if (${retornoCadastrarEntrega} === false) {
                alert('Falha com o Banco de dados para cadastrar o endere�o de Entrega');
            }
        </script>

        <%@ include file="./Components/Header.jspf" %>
                              
        <div class="container">
            <h3>Cadastro de Endere�o de Entrega</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrarEnderecoEntrega" novalidate>
                <label>Endere�o de Entrega:</label>
                <div class="row">
                    <input type="hidden" class="form-control" name="cepValidar" id="cepValidar"><br>
                    <input type="hidden" class="form-control" name="cepValidar2" id="cepValidar2"><br>
                    <div class="col-sm-2">
                        <label>CEP</label><span>*</span>
                        <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="Somente n�meros"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endere�o</label><span>*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>N�mero</label><span>*</span>
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

                <label>Endere�o de Faturamento:</label>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span>*</span>
                        <input type="number" class="form-control" name="cep2" id="cep2"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endere�o</label><span>*</span>
                        <input type="text" class="form-control" name="logradouro2" id="logradouro2"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>N�mero</label><span>*</span>
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
                
        <footer class="text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>