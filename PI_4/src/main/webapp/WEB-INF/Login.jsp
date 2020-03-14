<%-- 
    Document   : Login
    Created on : 13/03/2020, 20:58:51
    Author     : beatriz.silva19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <script>
            if (${usuarioAtt} === true) {
                alert("Usuário Inválido");
            }
        </script>    
        <script>
            if (${senhaAtt} === true) {
                alert("Senha Inválida");
            }
        </script>    

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>    
                <label for="usuario">Usuário</label>
                <input type="text" name="usuario" id="usuario" placeholder="Usuário" class="">
                <span class="error"><p id="user_error"></p></span>

                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha" placeholder="Senha" class="">
                <span class="error"><p id="senha_error"></p></span>

                <div class="coluna">
                    <input type="submit" name="loginBtn" value="Entrar" class="btn">
                </div>
            </form>
        </div>
        <div class="container">
            <input type="submit" name="" value="Criar sua conta na Canes Suplementos" class="">
        </div>

        <footer>
            <a href="${pageContext.request.contextPath}/creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>