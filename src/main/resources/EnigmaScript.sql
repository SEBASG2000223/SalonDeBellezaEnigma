create database SalonEnigma;

use SalonEnigma;

create user 'usuario_1'@'%' identified by 'cliente_1';

grant all privileges on SalonEnigma.* to 'usuario_1'@'%';

flush privileges;

CREATE TABLE Accesorios (
    id_accesorios INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    ruta_Imagen VARCHAR(255),
    activo BOOLEAN
);

CREATE TABLE Servicios (
    id_servicios INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(255),
    activo BOOLEAN
);

CREATE TABLE Sucursales (
    id_sucursales INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(255),
    activo BOOLEAN
);

CREATE TABLE Conozcanos (
    id_conozcanos INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(255),
    activo BOOLEAN
);
