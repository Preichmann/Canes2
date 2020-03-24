<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Créditos</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>

    <body>
        <div class="container">
            <h2>CANES - 2020</h2>
            <p>Esse projeto foi desenvolvido pelos alunos do 4º semestre de Ténologia em Análise e Desenvolvimento de Sistemas do Centro Universitário SENAC Santo Amaro</p>
            <hr>
            <h3>Desenvolvedores</h3>
            <ul>
                <li><a href="https://github.com/beatrizdasilva" target="_blank">Beatriz da Silva</a></li>
                <li><a href="https://github.com/Mansoldo" target="_blank">Diego Mansoldo</a></li>
                <li><a href="https://github.com/gabrielribeiroo" target="_blank">Gabriel Ribeiro Vital</a></li>
                <li><a href="https://github.com/micaelssantos" target="_blank">Micael Santos</a></li>
                <li><a href="https://github.com/Preichmann" target="_blank">Pedro Almeida</a></li>
            </ul>

            <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>
                <input type="submit" value="Voltar" class="btn">
            </form>
        </div>

        <footer class="fixed-bottom text-center footer p-2">
            <a href="${pageContext.request.contextPath}/Creditos">CANES SUPLEMENTOS</a>
            <p>2020 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>
