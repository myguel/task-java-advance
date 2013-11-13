DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
usuario_id integer NOT NULL AUTO_INCREMENT, 
nombre varchar(100) not null,
usuario_login varchar(50) not null,
usuario_password varchar(100) not null,
constraint pk_usuario primary key(usuario_id)
);

CREATE TABLE usuario_rol (
  usuario_rol_id int(10) NOT NULL AUTO_INCREMENT,
  usuario_id int(11) DEFAULT NULL,
  permiso varchar(45) NOT NULL,
  PRIMARY KEY (usuario_rol_id),
  KEY FK_usuario_rol (usuario_id),
  CONSTRAINT FK_usuario_rol FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
) ;

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


insert into usuario(usuario_id,nombre,usuario_login,usuario_password,estado) values (1,'MIGUEL LIBERATO','myguel','myguel123',1);
insert into usuario(usuario_id,nombre,usuario_login,usuario_password,estado) values (2,'ROCIO MANYA','rocio','rocio123',1);
insert into usuario(usuario_id,nombre,usuario_login,usuario_password,estado) values (3,'Willam Yamunaque','willy','willy123',1);
insert into usuario(usuario_id,nombre,usuario_login,usuario_password,estado) values (4,'Juan Padilla','juan','juan123',1);



insert into usuario_rol(usuario_rol_id,usuario_id,permiso) values (1,1,'ROL_ADMINISTRADOR');
insert into usuario_rol(usuario_rol_id,usuario_id,permiso) values (2,2,'ROL_DIRECTOR');
insert into usuario_rol(usuario_rol_id,usuario_id,permiso) values (3,3,'ROL_INVITADO');
insert into usuario_rol(usuario_rol_id,usuario_id,permiso) values (4,4,'ROL_USER');


