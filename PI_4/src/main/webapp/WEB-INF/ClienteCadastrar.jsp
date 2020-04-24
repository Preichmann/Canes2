<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Cadastrar Funcionario</title>
        <!--CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#clienteCEP").on("change", function () {
                    if (this.value) {
                        $.ajax({
                            url: 'http://api.postmon.com.br/v1/cep/' + this.value,
                            dateType: "json",
                            crossDomain: true,
                            statusCode: {
                                200: function (data) {
                                    //console.log(data);

                                    $("#clienteCEP").addClass("is-valid");
                                    $("#clienteRua").val(data.logradouro);
                                    $("#clienteBairro").val(data.bairro);
                                    $("#clienteCidade").val(data.cidade);
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

    </head>

    <body>

        

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

                    <input type="text" class="form-control" name="clienteCPF" id="clienteCPF" maxlength="11" placeholder="Somente os Números">
                </div>

                <label>Endereço de Entrega:</label>
                <div class="form-group">
                    <label for="clienteCEP">CEP</label>
                    <input type="number" id="clienteCEP" name="clienteCEP"/>
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

    </body>
</html>