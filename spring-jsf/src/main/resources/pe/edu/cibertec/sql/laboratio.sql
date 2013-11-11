DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
usuario_id integer NOT NULL AUTO_INCREMENT, 
nombre varchar(100) not null,
usuario_login varchar(50) not null,
usuario_password varchar(100) not null,
constraint pk_usuario primary key(usuario_id)
);


DROP TABLE IF EXISTS programa;
CREATE TABLE programa(
programa_id integer not null AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
estado boolean default  true comment 'VIGENTE O INACTIVO',
CONSTRAINT PRIMARY KEY (programa_id)
);

DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor(
profesor_id integer not null AUTO_INCREMENT,
apellidos VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
direccion VARCHAR(100) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(15) NOT NULL,
dni VARCHAR(8) NOT NULL,
estado boolean default  true comment 'VIGENTE O INACTIVO',
CONSTRAINT PRIMARY KEY (profesor_id)
);


DROP TABLE IF EXISTS laboratorio;
CREATE TABLE laboratorio (
  laboratorio_id int(11) NOT NULL AUTO_INCREMENT,
  programa_id integer,
  profesor_id integer,
  nombre varchar(100) NOT NULL,
  duracion integer not null,
  precio numeric(10,3) not null,
  fecha date  not null,
  estado boolean default  true comment 'VIGENTE O INACTIVO',  
  CONSTRAINT PK_lab PRIMARY KEY (laboratorio_id),
  CONSTRAINT FK_pro_lab FOREIGN  KEY (programa_id) REFERENCES programa(programa_id),
  CONSTRAINT FK_pro_prof FOREIGN  KEY( profesor_id) REFERENCES profesor(profesor_id)
) ;

DROP TABLE IF EXISTS auditoria;
CREATE TABLE auditoria(
auditoria_id integer NOT NULL AUTO_INCREMENT, 
fecha date not null,
valor varchar(50) not null,
CONSTRAINT PRIMARY KEY (auditoria_id)
);