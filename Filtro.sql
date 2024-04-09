create database riwi;

use riwi;

create table empresa(
id_empresa INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(255) NOT NULL,
sector VARCHAR(255) NOT NULL,
ubicacion VARCHAR(255) NOT NULL,
contacto VARCHAR(255) NOT NULL
);

create table coder(
id_coder INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(255) NOT NULL,
apellidos VARCHAR(255) NOT NULL,
documento VARCHAR(255) NOT NULL,
cohorte INT NOT NULL,
cv TEXT NOT NULL
);

create table vacante(
id_vacante INT PRIMARY KEY NOT NULL,
titulo VARCHAR(255) NOT NULL,
descripcion TEXT NOT NULL,
duracion VARCHAR(255) NOT NULL,
estado VARCHAR(50) NOT NULL,
id_empresa INT NOT NULL,
constraint fk_vacante_empresa FOREIGN KEY(id_empresa) REFERENCES empresa(id_empresa) ON DELETE CASCADE
);

create table contratacion(
id_contratacion INT PRIMARY KEY NOT NULL,
fecha_aplicacion DATE NOT NULL,
estado VARCHAR(255) NOT NULL,
salario DECIMAL,
id_vacante INT NOT NULL,
constraint fk_contratacion_vacante FOREIGN KEY(id_vacante) REFERENCES vacante(id_vacante) ON DELETE CASCADE,
id_coder INT NOT NULL,
constraint fk_contratacion_coder FOREIGN KEY(id_coder) REFERENCES coder(id_coder) ON DELETE CASCADE
);

ALTER TABLE vacante ADD tecnologia VARCHAR(255) NOT NULL;
ALTER TABLE coder ADD clan VARCHAR(50) NOT NULL;

ALTER TABLE contratacion CHANGE COLUMN fecha_aplicacion fecha_aplicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

INSERT INTO empresa(nombre,sector,ubicacion,contacto) VALUES ("eventtia","tecnologia","poblado","3124567867");

ALTER TABLE vacante CHANGE COLUMN id_empresa id_empresa INT NOT NULL AUTO_INCREMENT;
