CREATE TABLE usuario (
  codigo int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  telefone_celular varchar(45) DEFAULT NULL,
  dt_cadastro date DEFAULT NULL,
  dt_nascimento date DEFAULT NULL,
  PRIMARY KEY (codigo)
);

