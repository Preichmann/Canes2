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
        
        
        <div class="container mt-5">
            <h3 class="title-default mb-5">Cadastrar Endereço de Faturamento</h3>
            
            
            <form method="post" action="${pageContext.request.contextPath}/CadastrarFaturamento" novalidate>
                <div class="row mt-3">
                    <input type="hidden" class="form-control" name="cepValidar" id="cepValidar">
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
                
                <div class="row mt-4">
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
                <input type="submit" value="Cadastrar" class="btn btn-cor-especial col-2 mt-5 mb-5" />
            </form>
        </div>

        <%@ include file="./Components/Footer.jspf" %>
    </body>
</html>