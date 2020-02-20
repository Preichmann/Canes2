# Canes2
Projeto Canes dos alunos do 4° semestre de ADS do Senac



# How To

Executar os comandos abaixo no diretorio do projeto

$ docker build --tag=jboss/wildfly-admin .
$ docker run -d -p 9990:9990 -p 8080:8080 jboss/wildfly-admin
