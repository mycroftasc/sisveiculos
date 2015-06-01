
CREATE TABLE modelosVeiculos (
  idModelo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  idMarca INT(11) NOT NULL,
  PRIMARY KEY (IdModelo)
);


CREATE TABLE marcasVeiculos (
  idmarcasVeiculos INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY(idmarcasVeiculos)
);

CREATE TABLE tiposVeiculos (
  idTipoVeiculo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY(idTipoVeiculo)
);


CREATE TABLE marcasXtipos (
idMarcaXTipo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
idMarca INT(11) UNSIGNED NOT NULL,
idTipo  INT(11) UNSIGNED NOT NULL,
PRIMARY KEY(idMarcaXTipo)
);


CREATE TABLE usuarios (
  idUsuario INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(32) NOT NULL,
  sexo CHAR(1) NULL,
  dataNascimento DATE NULL,
  PRIMARY KEY(idUsuario)
);



CREATE TABLE veiculos (
  idVeiculo INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INT(11) UNSIGNED NOT NULL,
  idMarcaXTipo  INT(11) UNSIGNED NOT NULL,
  placa CHAR(7) NOT NULL,
  cor VARCHAR(60) NOT NULL,
  PRIMARY KEY(idVeiculo)
);



CREATE TABLE servicos (
  idServico INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY(idServico)
);


CREATE TABLE manutencoes (
  idManutencao INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  idVeiculo INT(11) UNSIGNED NOT NULL,
  idServico INT(11) UNSIGNED NOT NULL,
  dataManutencao DATE NOT NULL,
  quilometragemManutencao FLOAT NOT NULL,
  valorPeca FLOAT NOT NULL,
  ValorMaoObra FLOAT NOT NULL,
  valorTotal FLOAT NOT NULL,
  PRIMARY KEY(idManutencao)
);

ALTER TABLE manutencoes
ADD CONSTRAINT fk_servico_manutencao FOREIGN KEY (idServico) REFERENCES servicos (
idServico);

ALTER TABLE veiculos
ADD CONSTRAINT fk_marcaxtipo_veiculo FOREIGN KEY (idMarcaXTipo) REFERENCES marcasXtipos (
idMarcaXTipo);

ALTER TABLE marcasXtipos
ADD CONSTRAINT fk_marca_marcaXtipo FOREIGN KEY (idMarca) REFERENCES marcasVeiculos (
idmarcasVeiculos);

ALTER TABLE marcasXtipos
ADD CONSTRAINT fk_tipo_marcaXtipo FOREIGN KEY (idTipo) REFERENCES tiposVeiculos (
idTipoVeiculo);

ALTER TABLE modelosVeiculos
ADD CONSTRAINT fk_marcaVeiculo_modeloVeiculo FOREIGN KEY (idMarca) REFERENCES marcasVeiculos (
idmarcasVeiculos);

ALTER TABLE veiculos
ADD CONSTRAINT fk_veiculo_usuario FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario);

ALTER TABLE manutencoes
ADD CONSTRAINT fk_veiculo FOREIGN KEY (idVeiculo) REFERENCES veiculos (idveiculo);


INSERT INTO tiposVeiculos (nome) VALUES ('Motocicleta');
INSERT INTO tiposVeiculos (nome) VALUES ('Automovel');
INSERT INTO tiposVeiculos (nome) VALUES ('�nibus');
INSERT INTO tiposVeiculos (nome) VALUES ('Caminh�o');

/* Carros*/
INSERT INTO marcasVeiculos (nome) VALUES ('Agrale');
INSERT INTO marcasVeiculos (nome) VALUES ('Aston Martin');
INSERT INTO marcasVeiculos (nome) VALUES ('Audi');
INSERT INTO marcasVeiculos (nome) VALUES ('Bentley');
INSERT INTO marcasVeiculos (nome) VALUES ('Bmw');
INSERT INTO marcasVeiculos (nome) VALUES ('Changan');
INSERT INTO marcasVeiculos (nome) VALUES ('Chery');
INSERT INTO marcasVeiculos (nome) VALUES ('Chevrolet');
INSERT INTO marcasVeiculos (nome) VALUES ('Chrysler');
INSERT INTO marcasVeiculos (nome) VALUES ('Citro�n');
INSERT INTO marcasVeiculos (nome) VALUES ('Dodge');
INSERT INTO marcasVeiculos (nome) VALUES ('DS');
INSERT INTO marcasVeiculos (nome) VALUES ('Effa Motors');
INSERT INTO marcasVeiculos (nome) VALUES ('Ferrari');
INSERT INTO marcasVeiculos (nome) VALUES ('Fiat');
INSERT INTO marcasVeiculos (nome) VALUES ('Ford');
INSERT INTO marcasVeiculos (nome) VALUES ('Geely');
INSERT INTO marcasVeiculos (nome) VALUES ('Honda');
INSERT INTO marcasVeiculos (nome) VALUES ('Hyundai');
INSERT INTO marcasVeiculos (nome) VALUES ('Iveco');
INSERT INTO marcasVeiculos (nome) VALUES ('Jac');
INSERT INTO marcasVeiculos (nome) VALUES ('Jaguar');
INSERT INTO marcasVeiculos (nome) VALUES ('Jeep');
INSERT INTO marcasVeiculos (nome) VALUES ('Jinbei');
INSERT INTO marcasVeiculos (nome) VALUES ('Kia');
INSERT INTO marcasVeiculos (nome) VALUES ('Lamborghini');
INSERT INTO marcasVeiculos (nome) VALUES ('Land Rover');
INSERT INTO marcasVeiculos (nome) VALUES ('Lexus');
INSERT INTO marcasVeiculos (nome) VALUES ('Lifan');
INSERT INTO marcasVeiculos (nome) VALUES ('Mahindra');
INSERT INTO marcasVeiculos (nome) VALUES ('Maserati');
INSERT INTO marcasVeiculos (nome) VALUES ('Mercedes-Benz');
INSERT INTO marcasVeiculos (nome) VALUES ('Mini');
INSERT INTO marcasVeiculos (nome) VALUES ('Mitsubishi');
INSERT INTO marcasVeiculos (nome) VALUES ('Nissan');
INSERT INTO marcasVeiculos (nome) VALUES ('Peugeot');
INSERT INTO marcasVeiculos (nome) VALUES ('Porsche');
INSERT INTO marcasVeiculos (nome) VALUES ('Ram');
INSERT INTO marcasVeiculos (nome) VALUES ('Rely');
INSERT INTO marcasVeiculos (nome) VALUES ('Renault');
INSERT INTO marcasVeiculos (nome) VALUES ('Rolls Royce');
INSERT INTO marcasVeiculos (nome) VALUES ('Shineray');
INSERT INTO marcasVeiculos (nome) VALUES ('Smart');
INSERT INTO marcasVeiculos (nome) VALUES ('Ssangyong');
INSERT INTO marcasVeiculos (nome) VALUES ('Subaru');
INSERT INTO marcasVeiculos (nome) VALUES ('Suzuki');
INSERT INTO marcasVeiculos (nome) VALUES ('Tac');
INSERT INTO marcasVeiculos (nome) VALUES ('Toyota');
INSERT INTO marcasVeiculos (nome) VALUES ('Troller');
INSERT INTO marcasVeiculos (nome) VALUES ('Volkswagen');
INSERT INTO marcasVeiculos (nome) VALUES ('Volvo');


/*Motos*/
INSERT INTO marcasVeiculos (nome) VALUES ('Dafra');
INSERT INTO marcasVeiculos (nome) VALUES ('Harley-Davidson');
INSERT INTO marcasVeiculos (nome) VALUES ('Kasinski');
INSERT INTO marcasVeiculos (nome) VALUES ('Kawasaki');
INSERT INTO marcasVeiculos (nome) VALUES ('Yamaha');

/*Caminhoes*/
INSERT INTO marcasVeiculos (nome) VALUES ('Hafei');
INSERT INTO marcasVeiculos (nome) VALUES ('Sxania');

/*Onibus*/
INSERT INTO marcasVeiculos (nome) VALUES ('BusCar');
INSERT INTO marcasVeiculos (nome) VALUES ('Caio');
INSERT INTO marcasVeiculos (nome) VALUES ('Ciferal');
INSERT INTO marcasVeiculos (nome) VALUES ('Cobrasma S.A');
INSERT INTO marcasVeiculos (nome) VALUES ('Comil');
INSERT INTO marcasVeiculos (nome) VALUES ('Irizar');
INSERT INTO marcasVeiculos (nome) VALUES ('Jotave');
INSERT INTO marcasVeiculos (nome) VALUES ('Mafersa');
INSERT INTO marcasVeiculos (nome) VALUES ('Marcopolo');
INSERT INTO marcasVeiculos (nome) VALUES ('Mascarello');
INSERT INTO marcasVeiculos (nome) VALUES ('maxiBus');
INSERT INTO marcasVeiculos (nome) VALUES ('NeoBus');
INSERT INTO marcasVeiculos (nome) VALUES ('Nielson');
INSERT INTO marcasVeiculos (nome) VALUES ('TecnoBbus');
INSERT INTO marcasVeiculos (nome) VALUES ('Thamco');
INSERT INTO marcasVeiculos (nome) VALUES ('Volare');




