<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@ include file="./Components/Header.jspf" %>

        <main>
            <div class="container">
                <div class="row">
                    <div id="carouselExampleControls" class="carousel slide col-md-6" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item carousel-detalhe active">
                                <img src="${ActiveImgAtt.getCaminho()}" class="d-block" alt="${ProdutoAtt.getNome()}">
                            </div>
                            <c:forEach items="${ImagensAddAtt}" var="imagensAdicionais" varStatus="theCounters">
                                <div class="carousel-item carousel-detalhe">
                                    <img src="${imagensAdicionais.getCaminho()}" class="d-block w-100" alt="${ProdutoAtt.getNome()}">
                                </div>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>                

                    <div class="col-md-6">
                        <div class="row">
                            <h3>${ProdutoAtt.getNome()}</h3>
                        </div>
                        <div class="row">
                            <h4>R$ ${ProdutoAtt.getPreco()}</h4>
                        </div>
                        <form method="post" action="${pageContext.request.contextPath}/AdicionarItemCarrinho" novalidate>
                            <input type="hidden" value="${ProdutoAtt.getIdProd()}" name="idProd" id="idProd">
                            <input type="submit" value="Adicionar ao Carrinho" class="btn btn-cor-especial" />
                        </form>
                        <div class="p-2">
                            <p>${ProdutoAtt.getDescricao()}</p>
                        </div>
                    </div>
                </div>
            </div>

<<<<<<< HEAD
        <div class="container">
            <c:forEach items="${ListaPerguntaAtt}" var="listaPergunta" varStatus="theCount">
                <input type="hidden" value="${listaPergunta.getIdPergunta()}" name="idPergunta${theCount.index}" id="idPergunta${theCount.index}" />
                <label>${listaPergunta.getPergunta()}</label>
                <textarea class="form-control" name="resposta${theCount.index}" id="resposta${theCount.index}" rows="3" readonly="true"></textarea>
                <c:forEach items="${ListaRespostaProd}" var="listaResposta" varStatus="theCountResp">
                    <input type="hidden" value="${listaResposta.getIdPergunta()}" name="idPerguntares${theCountResp.index}" id="idPerguntares${theCountResp.index}" />
                    <script>
                        var r1 = document.getElementById("idPergunta${theCount.index}").value;
                        var r2 = document.getElementById("idPerguntares${theCountResp.index}").value;
                        getResposta(r1, r2);
                        function getResposta(r1, r2) {
                            try {
                                if (r1 === r2) {
                                    document.getElementById("resposta${theCount.index}").value = "${listaResposta.getResposta()}";
=======
            <div class="container">
                <c:forEach items="${ListaPerguntaAtt}" var="listaPergunta" varStatus="theCount">
                    <input type="hidden" value="${listaPergunta.getIdPergunta()}" name="idPergunta${theCount.index}" id="idPergunta${theCount.index}" />
                    <label>${listaPergunta.getPergunta()}</label>
                    <textarea class="form-control" name="resposta${theCount.index}" id="resposta${theCount.index}" rows="3" readonly="true"></textarea>
                    <c:forEach items="${ListaRespostaProd}" var="listaResposta" varStatus="theCountResp">
                        <input type="hidden" value="${listaResposta.getIdPergunta()}" name="idPergunta${theCountResp.index}" id="idPergunta${theCountResp.index}" />
                        <script>
                            var r1 = document.getElementById("idPergunta${theCount.index}").value;
                            var r2 = document.getElementById("idPergunta${theCountResp.index}").value;
                            getResposta(r1, r2);
                            function getResposta(r1, r2) {
                                try {
                                    if (r1 === r2) {
                                        document.getElementById("resposta${theCount.index}").value = "${listaResposta.getResposta()}";
                                    }
                                } catch (err) {
                                    alert(err);
>>>>>>> 913e9713fbf38503b8f2bb5f751068b42fef13d6
                                }
                            }
                        </script>
                    </c:forEach>
                </c:forEach>
            </div>
        </main>

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
    </body>
</html>