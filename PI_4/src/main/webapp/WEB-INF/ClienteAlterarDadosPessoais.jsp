<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" type="text/css" href="src/style.css">
        <title>Alterar Dados Pessoais</title>
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
            if (${retornoAlterar} == false) {
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
        
        <div class="container">
            <h3>Alterar dados pessoais</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/ClienteAlterarDados" novalidate>

                <div class="form-group">
                    <label for="clienteNome">Nome</label><span class="obrigatorio">*</span>
                    <input type="text" class="form-control" name="clienteNome" id="clienteNome" value="${Cliente.getNome()}">
                </div>

                <div class="form-group">
                    <label for="clienteEmail">E-mail</label><span class="obrigatorio">*</span>
                    <input type="text" class="form-control" name="clienteEmail" id="clienteEmail" value="${Cliente.getEmail()}" disabled="true">
                </div>

                <div class="form-group">
                    <label for="clienteSenha">Senha</label><span class="obrigatorio">*</span>
                    <input type="password" class="form-control" name="clienteSenha" id="clienteSenha" value="${Cliente.getSenha()}">
                </div>

                <div class="form-group">
                    <label for="clienteCPF">CPF</label><span class="obrigatorio">*</span>

                    <input type="text" class="form-control" name="clienteCPF" id="clienteCPF" maxlength="11" value="${Cliente.getCPF()}" disabled="true">
                </div>

                <input type="submit" value="Alterar" class="btn btn-success col-2" />
            </form>
            <form method="get" action="${pageContext.request.contextPath}/Index" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>
        </div>

        <%@ include file="./Components/Footer.jspf" %>     
    </body>
</html>