CREATE DATABASE SUPLEMENTOS;

USE SUPLEMENTOS;
--
CREATE TABLE PRODUTO (
ID_PRODUTO INT NOT NULL AUTO_INCREMENT,
NOME VARCHAR(150) NOT NULL,
DESCRICAO VARCHAR(1000) NOT NULL,
VALOR_UNIT NUMERIC(10,2) NOT NULL,
QUANTIDADE INT NOT NULL,
FK_ID_USUARIO INT NOT NULL,
STATUS VARCHAR(10) NOT NULL,
PRIMARY KEY (ID_PRODUTO)
);

CREATE TABLE OBJETIVO (
ID_OBJETIVO INT NOT NULL AUTO_INCREMENT,
NOME VARCHAR(100) NOT NULL,
PRIMARY KEY (ID_OBJETIVO)
);

CREATE TABLE CATEGORIA (
ID_CATEGORIA INT NOT NULL AUTO_INCREMENT,
NOME VARCHAR(100) NOT NULL,
PRIMARY KEY (ID_CATEGORIA)
);

CREATE TABLE PROD_CATEGORIA (
ID INT NOT NULL AUTO_INCREMENT,
FK_ID_CATEGORIA INT,
FK_ID_PRODUTO INT,
PRIMARY KEY(ID),
FOREIGN KEY(FK_ID_CATEGORIA) REFERENCES CATEGORIA (ID_CATEGORIA),
FOREIGN KEY(FK_ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO)
);

CREATE TABLE PROD_OBJETIVO (
ID INT NOT NULL AUTO_INCREMENT,
FK_ID_OBJETIVO INT,
FK_ID_PRODUTO INT,
PRIMARY KEY (ID),
FOREIGN KEY(FK_ID_OBJETIVO) REFERENCES OBJETIVO (ID_OBJETIVO),
FOREIGN KEY(FK_ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO)
);

CREATE TABLE PROD_IMG (
FK_ID_PRODUTO INT,
NOME VARCHAR(30) NOT NULL,
FOREIGN KEY(FK_ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO)
);

INSERT INTO OBJETIVO (NOME)
VALUES ('Massa Magra'),
	   ('Emagrecimento'),
       ('Energia'),
       ('Saúde e Qualidade de vida'),
       ('Vitaminas');
       
INSERT INTO CATEGORIA (NOME)
VALUES ('Aminoácidos'),
	   ('Pré-treino'),
       ('Hipercalórico'),
       ('Proteínas'),
       ('Termogênicos');
       
CREATE TABLE PERGUNTA(
ID_PERGUNTA INT NOT NULL AUTO_INCREMENT,
PERGUNTA VARCHAR(100) NOT NULL,
PRIMARY KEY(ID_PERGUNTA)
);
       
CREATE TABLE RESPOSTA_PROD_PERG(
ID_RESPOSTA INT NOT NULL AUTO_INCREMENT,
RESPOSTA VARCHAR(100) NOT NULL,
FK_ID_PRODUTO INT NOT NULL,
FK_ID_PERGUNTA INT NOT NULL,
PRIMARY KEY(ID_RESPOSTA),
foreign key (FK_ID_PRODUTO) references PRODUTO (ID_PRODUTO),
FOREIGN KEY (FK_ID_PERGUNTA) references PERGUNTA(ID_PERGUNTA)
);     

INSERT INTO PERGUNTA (PERGUNTA)
VALUES ('O que é?'),   
       ('Para que serve?'),
       ('Como usar?'); 
	


