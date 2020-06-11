<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Canes Suplementos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="src/style.css">
    </head>

    <%@ include file="./Components/Header.jspf" %>

    <body class="bg-light">
        <script>
            if (${msgName} === true) {
                alert('O campo Nome � obrigat�rio quando selecionado Cart�o');
            }
        </script>
        <script>
            if (${msgNumCartao} === true) {
                alert('O campo Numero do cartao � obrigat�rio quando selecionado Cart�o');
            }
        </script>
        <script>
            if (${msgVenci} === true) {
                alert('O campo Vencimento � obrigat�rio quando selecionado Cart�o');
            }
        </script>
        <script>
            if (${msgCVV} === true) {
                alert('O campo CVV � obrigat�rio quando selecionado Cart�o');
            }
        </script>
        <script>
            if (${msgParcelas} === true) {
                alert('O campo Parcelas � obrigat�rio quando selecionado Cart�o');
            }
        </script>


        <div class="container mt-5">
            <h3 class="title-default mb-5">Forma de Pagamento</h3>
            <form class="needs-validation"   name="CadastrarEntrega" method="post"
                  action="${pageContext.request.contextPath}/CheckOutPagamento" novalidate>

                <div class="mt-5 mb-4">
                    <div class="custom-control custom-radio">
                        <input id="boleto" name="paymentMethod" type="radio" value="boleto" class="custom-control-input" checked required>
                        <label class="custom-control-label" for="boleto">Boleto</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="credito" name="paymentMethod" type="radio" value="credito" class="custom-control-input" required>
                        <label class="custom-control-label" for="credito">Cart�o de Cr�dito</label>
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-6">
                        <label for="cc-name">Nome no cart�o</label>
                        <input type="text" class="form-control" id="cc-name" name="cc-name" placeholder="" required>
                        <small class="text-muted">Nome completo do titular do cart�o</small>
                        <div class="invalid-feedback">
                            O Nome � obrigat�rio
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="cc-number">N�mero do cart�o</label>
                        <input type="text" class="form-control" id="cc-number" name="cc-number" placeholder="" required>
                        <div class="invalid-feedback">
                            N�mero do cart�o � obrigat�rio
                        </div>
                    </div>
                </div>

                <div class="row mb-5">
                    <div class="col-md-3">
                        <label for="cc-expiration">Vencimento</label>
                        <input type="text" class="form-control" id="cc-expiration" name="cc-expiration" placeholder="" required>
                        <div class="invalid-feedback">
                            Data de Vencimento � obrigat�ria
                        </div>
                    </div>
                    <div class="col-md-3">
                        <label for="cc-cvv">CVV</label>
                        <input type="text" class="form-control" id="cc-cvv" name="cc-cvv"placeholder="" required>
                        <div class="invalid-feedback">
                            C�digo de seguran�a � obrigat�rio
                        </div>
                    </div>
                    <div class="col-md-3">
                        <label for="cc-parcelas">Parcelas</label>
                        <select id="cc-parcelas" name="cc-parcelas">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>

                <button class="btn btn-secondary mt-2 mb-5" type="submit">Seguir</button>
            </form>
        </div>

        <%@ include file="./Components/Footer.jspf" %>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
                integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</html>
