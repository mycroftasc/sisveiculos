CREATE TABLE tipoVeiculo (
  idTipoVeiculo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY(idTipoVeiculo)
)
ENGINE=INNODB;


CREATE TABLE MarcaVeiculo (
  idMarca INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY(idMarca)
)
ENGINE=INNODB;


CREATE TABLE usuario (
  idUsuario INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(32) NOT NULL,
  sexo CHAR(1) NULL,
  dataNascimento DATE NULL,
  PRIMARY KEY(idUsuario)
)
ENGINE=INNODB;


CREATE TABLE manutencao (
  idManutencao INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY(idManutencao)
)
ENGINE=INNODB;


CREATE TABLE manutencao_x_veiculo (
  idManutencao INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  idVeiculo INT(11) UNSIGNED NOT NULL,
  dataManutencao DATE NOT NULL,
  quilometragemManutencao DATE NOT NULL,
  valorPeca FLOAT NOT NULL,
  ValorMaoObra FLOAT NOT NULL,
  valorTotal FLOAT NOT NULL,
  PRIMARY KEY(idManutencao)
)
ENGINE=INNODB;


CREATE TABLE veiculo (
  idVeiculo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  idTipoVeiculo INT(11) UNSIGNED NOT NULL,
  idMarca INT(11) UNSIGNED NOT NULL,
  idUsuario INT(11) UNSIGNED NOT NULL,
  placa CHAR(7) NULL,
  PRIMARY KEY(idVeiculo)
)
ENGINE=INNODB;


ALTER TABLE veiculo
ADD CONSTRAINT fk_veiculo_tipoVeiculo FOREIGN KEY (idTipoVeiculo) REFERENCES tipoVeiculo (idTipoVeiculo);


ALTER TABLE veiculo
ADD CONSTRAINT fk_veiculo_marcaVeiculo FOREIGN KEY (idMarca) REFERENCES marcaVeiculo (idMarca);


ALTER TABLE veiculo
ADD CONSTRAINT fk_veiculo_usuario FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario);


ALTER TABLE manutencao_x_veiculo
ADD CONSTRAINT fk_veiculo FOREIGN KEY (idVeiculo) REFERENCES veiculo (idveiculo);


INSERT INTO tipoVeiculo (descricao) VALUES ('Motocicleta');
INSERT INTO tipoVeiculo (descricao) VALUES ('Automovel');
INSERT INTO tipoVeiculo (descricao) VALUES ('�nibus');
INSERT INTO tipoVeiculo (descricao) VALUES ('Caminh�o');

/* Carros*/
INSERT INTO MarcaVeiculo (descricao) VALUES ('Agrale');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Aston Martin');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Audi');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Bentley');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Bmw');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Changan');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Chery');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Chevrolet');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Chrysler');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Citro�n');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Dodge');
INSERT INTO MarcaVeiculo (descricao) VALUES ('DS');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Effa Motors');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Ferrari');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Fiat');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Ford');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Geely');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Honda');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Hyundai');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Iveco');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Jac');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Jaguar');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Jeep');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Jinbei');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Kia');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Lamborghini');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Land Rover');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Lexus');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Lifan');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Mahindra');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Maserati');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Mercedes-Benz');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Mini');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Mitsubishi');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Nissan');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Peugeot');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Porsche');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Ram');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Rely');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Renault');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Rolls Royce');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Shineray');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Smart');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Ssangyong');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Subaru');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Suzuki');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Tac');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Toyota');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Troller');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Volkswagen');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Volvo');


/*Motos*/
INSERT INTO MarcaVeiculo (descricao) VALUES ('Dafra');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Harley-Davidson');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Kasinski');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Kawasaki');
INSERT INTO MarcaVeiculo (descricao) VALUES ('Yamaha');

/*caminhoes*/
INSERT INTO MarcaVeiculo (descricao) VALUES ('HAFEI');
INSERT INTO MarcaVeiculo (descricao) VALUES ('SCANIA');



