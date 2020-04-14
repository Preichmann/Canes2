<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" type="text/css" href="src/style.css">
        <title>Alterar Endereço de Entrega</title>
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
            <h3>Alterar de Endereço de Entrega</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/AlterarEnderecoEntrega" novalidate>
                <div class="row">
                    <div class="col-sm-2">
                        <label>CEP</label><span>*</span>
                        <input type="number" class="form-control" name="cep" id="cep" value="${cep}"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Endereço</label><span>*</span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro" value="${rua}"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Número</label><span>*</span>
                        <input type="number" class="form-control" name="numero" id="numero" value="${numero}"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento" value="${complemento}"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Bairro</label><span>*</span>
                        <input type="text" class="form-control" name="bairro" id="bairro" value="${bairro}"><br>
                    </div>

                    <div class="col-sm-4">
                        <label>Cidade</label><span>*</span>
                        <input type="text" class="form-control" name="cidade" id="cidade" value="${cidade}"><br>
                    </div>

                    <div class="col-sm-2">
                        <label>Estado</label><span>*</span>
                        <input type="text" class="form-control" name="estado" id="estado" value="${estado}"><br>
                    </div>
                </div>
                <input type="hidden" class="form-control" name="idEntrega" id="idEntrega" value="${idEntrega}">
                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
            <form method="get" action="${pageContext.request.contextPath}/ListarDadosEntrega" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>
        </div>
    </body>
</html>