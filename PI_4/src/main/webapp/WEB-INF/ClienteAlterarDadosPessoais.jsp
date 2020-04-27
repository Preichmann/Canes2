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
                                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterarDados" class="nav-item" novalidate>
                                    <input type="submit" value="Gerenciar dados de Entrega" class="nav-link">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterarDados" class="nav-item" novalidate>
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
                
        <footer class="text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>        
    </body>
</html>