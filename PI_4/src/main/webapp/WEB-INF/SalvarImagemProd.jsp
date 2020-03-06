<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="SalvarImagem" name="SalvarImagem" method="post"
              action="${pageContext.request.contextPath}/SalvarImagem" novalidate enctype='multipart/form-data'>
            <div class="form-group">
        <input type="hidden" value="${resultAtt}" name="idProd" id="idProd" />
                <label for="image">Imagem do Produto</label>
                <input type="file" name="file" id="file" class="form-control" />
            </div>
            <input type="submit" value="Salvar" class="btn btn-success col-2" />
        </form>

    </body>
</html>
