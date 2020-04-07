<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Cadastrar Funcionario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>

    <body>
        <script>
            if (${retornoNome} === false) {
                alert('O campo nome precisa conter no minimo 2 palavras cada uma com no minimo 3 letras');
            }
        </script>
        <script>
            if (${retornoEmail} === false) {
                alert('Email digitado é invalido');
            }
        </script>
        <script>
            if (${retornoSenha} === false) {
                alert('Senha não pode ser vazia');
            }
        </script>
        <script>
            if (${retornoCPF} === false) {
                alert('CPF digitado invalido');
            }
        </script>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
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
                        <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                            <input type="submit" value="Carrinho" class="nav-link">
                        </form>

                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Nome do Usuário
                                ${sessionScope.usuarioLogado.nome}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Trocar Senha</a>
                                <a class="dropdown-item" href="#">Sair</a>
                            </div>
                        </div>
                    </div>          
                </div>
            </nav>
        </header>

        <div class="container">
            <h3>Cadastro</h3>
            <hr>

            <form method="post" action="${pageContext.request.contextPath}/ClienteCadastrar" name="form1" novalidate>

                <div class="form-group">
                    <label for="clienteNome">Nome</label>
                    <input type="text" class="form-control" name="clienteNome" id="clienteNome" placeholder="Nome Completo">
                </div>

                <div class="form-group">
                    <label for="clienteEmail">E-mail</label>
                    <input type="text" class="form-control" name="clienteEmail" id="clienteEmail" placeholder="Ex: Email@dominio.com">
                </div>

                <div class="form-group">
                    <label for="clienteSenha">Senha</label>
                    <input type="password" class="form-control" name="clienteSenha" id="clienteSenha" placeholder="Senha">
                </div>

                <div class="form-group">
                    <label for="clienteCPF">CPF</label>
                    <input type="text" name="clienteCPF" id="clienteCPF" maxlength="11" placeholder="Somente os Números">
                </div>

                <label>Endereço de Entrega:</label>
                <div class="form-group">
                    <label for="clienteCEP">CEP</label>
                    <input type="text" class="form-control" name="clienteCEP" id="clienteCEP" placeholder="Ex: 00000-00">
                </div>

                <div class="form-group">
                    <label for="clienteRua">Rua</label>
                    <input type="text" class="form-control" name="clienteRua" id="clienteRua" placeholder="Rua">
                </div>
                <div class="form-group">
                    <label for="clienteComplemento">Complemento</label>
                    <input type="text" class="form-control" name="clienteComplemento" id="clienteComplemento" placeholder="Complemento">
                </div>
                <div class="form-group">
                    <label for="clienteBairro">Bairro</label>
                    <input type="text" class="form-control" name="clienteBairro" id="clienteBairro" placeholder="Bairro">
                </div>
                <div class="form-group">
                    <label for="clienteCidade">Cidade</label>
                    <input type="text" class="form-control" name="clienteCidade" id="clienteCidade" placeholder="Cidade">
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <select id="estado" name="estado">
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                        <option value="EX">Estrangeiro</option>
                    </select>
                </div>
                <label>Endereço de Faturamento:</label>
                <button id="copEndereco" name="copEndereco" onclick="copDados()">Copiar dados de Entrega</button>
                <div class="form-group">
                    <label for="clienteCEP">CEP</label>
                    <input type="text" class="form-control" name="clienteCEP2" id="clienteCEP2" placeholder="Ex: 00000-00">
                </div>

                <div class="form-group">
                    <label for="clienteRua">Rua</label>
                    <input type="text" class="form-control" name="clienteRua2" id="clienteRua2" placeholder="Rua">
                </div>
                <div class="form-group">
                    <label for="clienteComplemento">Complemento</label>
                    <input type="text" class="form-control" name="clienteComplemento2" id="clienteComplemento2" placeholder="Complemento">
                </div>
                <div class="form-group">
                    <label for="clienteBairro">Bairro</label>
                    <input type="text" class="form-control" name="clienteBairro2" id="clienteBairro2" placeholder="Bairro">
                </div>
                <div class="form-group">
                    <label for="clienteCidade">Cidade</label>
                    <input type="text" class="form-control" name="clienteCidade2" id="clienteCidade2" placeholder="Cidade">
                </div>
                <div class="form-group">
                    <label for="estad2">Estado</label>
                    <select id="estado2" name="estado2">
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                        <option value="EX">Estrangeiro</option>
                    </select>
                </div>

                <input type="submit" value="Cadastrar" class="btn btn-success col-2" />
            </form>
            <form method="get" action="${pageContext.request.contextPath}/menu-FuncionarioListar" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-danger col-2" />
            </form>

            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    </body>
</html>