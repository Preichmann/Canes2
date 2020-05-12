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
            if (${RetornoCepVal} === false) {
                alert('CEP Digitado Invalido');
            }
        </script>
        
        <script>
            if (${RetornoCep2} === false) {
                alert('CEP do campo de faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCep} === false) {
                alert('CEP do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoRua2} === false) {
                alert('RUA do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoRua} === false) {
                alert('RUA do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoNum2} === false) {
                alert('Numero do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoNum} === false) {
                alert('Numero do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoBairro2} === false) {
                alert('Bairro do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoBairro} === false) {
                alert('Bairro do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCidade2} === false) {
                alert('Cidade do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoCidade} === false) {
                alert('Cidade do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoEstado2} === false) {
                alert('Estado do campo de Faturamento é Obrigatório');
            }
        </script>
        <script>
            if (${RetornoEstado} === false) {
                alert('Estado do campo de Entrega é Obrigatório');
            }
        </script>
        <script>
            if (${retornoCadastrarFaturamento} === false) {
                alert('Falha com o Banco de dados para cadastrar o endereço de Faturamento');
            }
        </script>
        <script>
            if (${retornoCadastrarEntrega} === false) {
                alert('Falha com o Banco de dados para cadastrar o endereço de Entrega');
            }
        </script>

        <%@ include file="./Components/Header.jspf" %>
                              
        <div class="container mt-5">
            <h3 class="title-default mb-5">Cadastrar Endereço</h3>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrarEnderecoEntrega" novalidate>
                <h4 class="mb-3">Endereço de Entrega:</h4>
                
                <div class="row">
                    <input type="hidden" class="form-control" name="cepValidar" id="cepValidar">
                    <input type="hidden" class="form-control" name="cepValidar2" id="cepValidar2">
                    <div class="col-sm-3">
                        <label for="cep">CEP</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="Somente números" required>
                    </div>
                    <div class="col-sm-7">
                        <label for="logradouro">Logradouro</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro" required>
                    </div>
                    <div class="col-sm-2">
                        <label for="numero">Número</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="numero" id="numero" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento">
                    </div>
                    <div class="col-sm-3">
                        <label for="bairro">Bairro</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="bairro" id="bairro" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="cidade">Cidade</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="cidade" id="cidade" required>
                    </div>
                    <div class="col-sm-1">
                        <label for="estado">Estado</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="estado" id="estado" required>
                    </div>
                </div>
                <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${idCliente}">
                
                <div class="mt-5">
                    <button class="btn btn-secondary" type="button" id="copiar" name="copiar" onClick="copyFromTextbox();">Usar endereço para faturamento</button>
                </div>
                
                <h4 class="mt-5 mb-3">Endereço de Faturamento:</h4>
                <div class="row">
                    <div class="col-sm-3">
                        <label for="cep2">CEP</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="cep2" id="cep2" maxlength="8" placeholder="Somente números" required>
                    </div>
                    <div class="col-sm-7">
                        <label for="logradouro2">Logradouro</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="logradouro2" id="logradouro2" required>
                    </div>
                    <div class="col-sm-2">
                        <label for="numero2">Número</label><span class="obrigatorio">*</span>
                        <input type="number" class="form-control" name="numero2" id="numero2" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <label for="complemento2">Complemento</label>
                        <input type="text" class="form-control" name="complemento2" id="complemento2">
                    </div>
                    <div class="col-sm-3">
                        <label for="bairro2">Bairro</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="bairro2" id="bairro2" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="cidade2">Cidade</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="cidade2" id="cidade2" required>
                    </div>
                    <div class="col-sm-1">
                        <label for="estado2">Estado</label><span class="obrigatorio">*</span>
                        <input type="text" class="form-control" name="estado2" id="estado2" required>
                    </div>
                </div>
                <input type="submit" value="Cadastrar" class="btn btn-cor-especial col-2 mb-5" />
            </form>
        </div>
                
        <%@ include file="./Components/Footer.jspf" %>
    </body>
</html>