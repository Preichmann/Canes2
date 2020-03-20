<!DOCTYPE html>
<%-- Alterar o padrão para JSP --%>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Canes Suplementos</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="src/style.css">
</head>

<body>
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
                              
                        <form method="get" action="${pageContext.request.contextPath}/ProdutoCadastrar" class="nav-item active" novalidate>
                            <input type="submit" value="Cadastrar Produto" class="nav-link active">
                        </form>

                        <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" class="nav-item" novalidate>
                            <input type="submit" value="Listar Produtos" class="nav-link">
                        </form>	
                    </div>
                              
                    <div class="d-flex user-options">
                        <form method="get" action="${pageContext.request.contextPath}/Carrinho" class="nav-item" novalidate>
                            <input type="submit" value="Carrinho" class="nav-link">
                        </form>

                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Nome do Usuário
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

  <main>
    <section id="produtos" class="bg-light pb-5">
      <div class="container d-flex flex-wrap justify-content-md-around justify-content-center">
        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>

        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>

        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>

        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>

        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>

        <article class="card borda-cor-especial card-largura mt-5">
          <img src="src/img/wheyProtein.png" class="card-img-top card-imagem-posicao" alt="">
          <div class="card-body">
            <h5 class="card-title">Produto</h5>
            <p class="card-text">R$</p>
            <a href="#" class="btn btn-cor-especial">Comprar</a>
          </div>
        </article>
      </div>
    </section>
  </main>

  <footer id="footer" class="bg-secondary py-3 mx-auto">
    <p class="text-center m-0"><a href="#" class="text-light text-decoration-none">contato: email@canes.com.br</a></p>
  </footer>

  <!-- modal -->
  <div class="modal fade" id="modal-contato" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
      <dialog class="modal-content">
        <header class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Entre em contato</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </header>
        <article class="modal-body">
          <form>
            <div class="form-group">
              <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="informe seu nome">
            </div>
            <div class="form-group">
              <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="informe seu e-mail">
            </div>
            <div class="form-group">
              <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="deixe sua mensagem"
                rows="3"></textarea>
            </div>
          </form>
        </article>
        <footer class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
          <button type="button" class="btn btn-cor-especial">Enviar</button>
        </footer>
      </dialog>
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
</body>

</html>