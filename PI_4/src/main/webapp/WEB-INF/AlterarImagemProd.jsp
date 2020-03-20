<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <div class="form-group">
            <fieldset>
                <legend>Imagens</legend>

                <c:forEach items="${listaImagensAtt}" var="imagens" varStatus="theCounter">
                    <form id="SalvarImagem" name="ExcluirImagem" method="post"
                          action="${pageContext.request.contextPath}/ExcluirImagem" novalidate>
                        <input type="hidden" value="${resultAtt}" name="idProd" id="idProd${theCounter.index}" />
                        <input type="hidden" value="${imagens.getIdImg()}" name="idImagem" id="idImagem${theCounter.index}" />
                        <input type="hidden" value="${imagens.getNome()}" name="nomeImg" id="nomeImg${theCounter.index}" />
                        <img src="https://storage.cloud.google.com/imagedb/${imagens.getNome()}" class="card-img-top card-imagem-posicao" alt="">
                        <input type="submit" value="Excluir" class="btn btn-success col-2"/>
                    </form>
                </c:forEach>
            </fieldset>
            <hr>
        </div>
        <form id="SalvarImagem" name="SalvarImagem" method="post"
              action="${pageContext.request.contextPath}/SalvarImagem" novalidate enctype='multipart/form-data'>
            <input type="hidden" value="${resultAtt}" name="idProd" id="idProd" />
            <input type="file" name="file" id="file" class="form-control" multiple="multiple" />
            <input type="submit" value="Salvar" class="btn btn-success col-2" />
        </form>
        <form method="get" action="${pageContext.request.contextPath}/ProdutoListarBackoffice" class="nav-item" novalidate>
            <input type="submit" value="Sair" class="nav-link">
        </form>
    </body>
</html>
