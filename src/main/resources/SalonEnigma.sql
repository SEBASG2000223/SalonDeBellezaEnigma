create database SalonEnigma;

use SalonEnigma;

create user 'usuario_1'@'%' identified by 'cliente_1';

grant all privileges on SalonEnigma.* to 'usuario_1'@'%';

flush privileges;

CREATE TABLE Accesorios (
    id_accesorios INT AUTO_INCREMENT PRIMARY KEY,
    nombre_accesorio varchar(255) not null,
    descripcion VARCHAR(255),
    precio double not null,
	existencias int not null,
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);
CREATE TABLE Carrito (
    id_carrito INT AUTO_INCREMENT PRIMARY KEY,
    nombre_carrito varchar(255) not null,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);

CREATE TABLE Servicios (
    id_servicios INT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(255),
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);

CREATE TABLE Sucursales (
    id_sucursales INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Sucursal VARCHAR(255),
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

CREATE TABLE Usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO Usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg',true),
(2,'rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg',true),
(3,'pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854',true);

create table Rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into Rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);

INSERT INTO Accesorios (id_accesorios, nombre_accesorio, descripcion, precio, existencias, ruta_imagen, activo) VALUES 
('1','Silla Profesional', 'Ideal para brindar comodidad y estilo a tus clientes.', 150.00, 10, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fsilla.png?alt=media&token=ecd78915-1ad0-428c-8fac-bed2303a9b0c', true), 
('2','Secadora Profesional', 'Potente y eficiente para obtener resultados profesionales.', 200.00, 15, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fsecador.png?alt=media&token=0b30a518-51c1-4618-8135-943cf197bd38', true),
('3','Tijeras para Cortar Cabello','Precisas y ergonómicas para lograr cortes perfectos.', 80.00, 20, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Ftijeras.png?alt=media&token=b6391486-a0d0-4337-835b-732bc02b72d1',true),
('4','Plancha Profesional','Consigue un cabello liso y brillante con esta plancha de alta calidad', 120.00, 12, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fplancha.png?alt=media&token=380ed9af-52c7-43cf-95f9-316258e4aeff',true),
('5','Kit de Peines','Variedad de peines profesionales para todo tipo de estilos y cortes.', 50.00, 25, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fpeine.png?alt=media&token=583ba4d7-67a1-44de-a072-735e62a626e8',true),
('6','Capa Profesional','Mantén a tus clientes cómodos y protegidos durante sus servicios.', 30.00, 18, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fcapa.png?alt=media&token=9cf8be5b-4232-4f88-b22a-f1dff0769eed', false),
('7','Espejo de Maquillaje con Luz','Ideal para aplicar maquillaje con precisión gracias a su iluminación LED.', 70.00, 8, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fespejo.png?alt=media&token=de1138a7-d564-436b-bad2-f639d3711a21', true),
('8','Cepillo Profesional','Perfecto para desenredar y dar volumen al cabello.', 40.00, 30, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fcepillo.png?alt=media&token=033a34aa-e1bc-460f-82dc-822d47ae6a5e', true);

INSERT INTO Servicios (id_servicios, nombre_servicio, descripcion, ruta_imagen, activo)  
VALUES      
    (1, 'Corte de cabello', 'Dar forma y estilizar el cabello con los mejores productos y estilistas de la zona', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fcorte.png?alt=media&token=90b21f02-a34b-4cb8-a699-16f3d7973d44', true),     
    (2, 'Queratina', 'Tratamiento para suavizar y reparar el cabello dañado. En tan solo unas hora tu cabello lucira como nuevo', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fqueratina.png?alt=media&token=8fe9b9e6-b8db-4ea2-b5ef-7014c5060e77', true),     
    (3, 'Tinte', 'Proceso para cambiar el tono del cabello y cambiarlo al tono o color de tu preferencia', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Ftinte.png?alt=media&token=cc33ab67-48f3-4466-8d94-faca4b6e6e4a', true),     
    (4, 'Manicura', 'Servicio de cuidado, pintado y esmaltado de las uñas de las manos, con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fmanicura.png?alt=media&token=abcd9f7e-04dd-4c0d-ac53-89d49ec0a730', true),     
    (5, 'Pedicura', 'Servicio de cuidado de las uñas de los pies con los mejores productos y maquinas del mercado', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fpedicura.png?alt=media&token=ddbfaeb7-197a-4f91-87ae-f844929c3602', true),
    (6, 'Gel X', 'Método de aplicación de uñas de gel con una duración grantizada ya que se hace con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fgell%20x.png?alt=media&token=a1fb644d-366e-4894-9d92-f8136578fe8b', true),
    (7, 'Tratamiento capilar de hidratación profunda', 'Tratamiento que proporciona hidratación intensiva al cabello', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fhidratacion.png?alt=media&token=4be18df3-792e-4b1d-a1c5-e2bed13d3eb4', true),     
    (8, 'Maquillaje profesional', 'Servicio de maquillaje realizado por los mejores estilistas de la zona y con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fmaquillaje.png?alt=media&token=e91cb533-c6bf-47ab-a6f1-410a37389210', true);


INSERT INTO Sucursales (id_sucursales, nombre_sucursal, descripcion, ruta_imagen, activo) 
VALUES 
    (1, 'Zapote', '500mts al norte de multiplaza del este', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FZapote.png?alt=media&token=ef96ad12-8a9a-469e-8bd8-4a8ebf64ef3d', true),
    (2, 'Desamparados', '100 mts este del multicentro, desamparados', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FDesamparados.png?alt=media&token=2d4d47b9-a824-43fb-bbea-25a89f1172f1', true),
    (3, 'Guadalupe', '200mts oeste del Centro comercial de guadalupe', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FGuadalupe.png?alt=media&token=2acafb4e-26e3-4ef1-b628-b62687c9e139', true);

drop database SalonEnigma;

SELECT *FROM  Servicios

