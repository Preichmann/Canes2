
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
        <div class="container">
            <div class="py-5 text-center">
                <h2>Forma de Pagamento</h2>
            </div>

            <div class="row">
                <div class="col-md-8 order-md-1">
                    <form class="needs-validation" >
                        <h4 class="mb-3">Pagamento</h4>

                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="boleto" name="paymentMethod" type="radio" value="boleto" class="custom-control-input" checked required>
                                <label class="custom-control-label" for="boleto">Boleto</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="credito" name="paymentMethod" type="radio" value="credito" class="custom-control-input" required>
                                <label class="custom-control-label" for="credito">Cartão de Crédito</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="cc-name">Nome no Cartão</label>
                                <input type="text" class="form-control" id="cc-name" name="cc-name" placeholder="" required>
                                <small class="text-muted">O nome completo que aparece no cartão</small>
                                <div class="invalid-feedback">
                                    O Nome é obrigatório
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="cc-number">Número do cartão de crédito</label>
                                <input type="text" class="form-control" id="cc-number" name="cc-number" placeholder="" required>
                                <div class="invalid-feedback">
                                    Número do cartão é obrigatório
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">Vencimento</label>
                                <input type="text" class="form-control" id="cc-expiration" name="cc-expiration" placeholder="" required>
                                <div class="invalid-feedback">
                                    Data de Vencimento é obrigatória
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="cc-cvv">CVV</label>
                                <input type="text" class="form-control" id="cc-cvv" name="cc-cvv"placeholder="" required>
                                <div class="invalid-feedback">
                                    Código de segurança é obrigatório
                                </div>
                            </div>
                        </div>
                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Seguir</button>
                    </form>
                </div>
            </div>
        </div>
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
