<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="src/style.css">
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
        <script>
            if (${retornoEndereço} == false) {
                alert('Campos de Endereço obrigatórios não foram preenchidos corretamente');
            }
        </script>
        <script>
            if (${retornoCadastro} == false) {
                alert('Falha com o banco de dados');
            }
        </script>
        <script>
            if (${retornoEmailCadastrado} == false) {
                alert('Esse E-mail já está cadastrado');
            }
        </script>
        <script>
            if (${retornoCPFCadastrado} == false) {
                alert('Já existe esse CPF cadastrado');
            }
        </script>
        
        <%@ include file="./Components/Header.jspf" %>
        
        <div class="container mt-5">
            <h3 class="title-default mb-4">Cadastro</h3>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrar" novalidate>
                <div class="form-group">
                    <label for="clienteNome">Nome</label><span class="obrigatorio">*</span>
                    <input type="text" class="form-control" name="clienteNome" id="clienteNome" placeholder="Nome completo">
                </div>

                <div class="form-group">
                    <label for="clienteEmail">E-mail</label><span class="obrigatorio">*</span>
                    <input type="text" class="form-control" name="clienteEmail" id="clienteEmail" placeholder="Ex: nome@email.com">
                </div>

                <div class="form-group">
                    <label for="clienteSenha">Senha</label><span class="obrigatorio">*</span>
                    <input type="password" class="form-control" name="clienteSenha" id="clienteSenha" placeholder="Senha">
                </div>

                <div class="form-group">
                    <label for="clienteCPF">CPF</label><span class="obrigatorio">*</span>
                    <input type="text" class="form-control" name="clienteCPF" id="clienteCPF" maxlength="11" placeholder="Somente números">
                </div>

                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
                
            <form method="get" action="${pageContext.request.contextPath}/Index" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>
        </div>

        <%@ include file="./Components/Footer.jspf" %>
    </body>
</html>