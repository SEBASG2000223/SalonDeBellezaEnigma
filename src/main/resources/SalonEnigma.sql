drop schema if exists SalonEnigma;
drop user if exists usuario_1;
CREATE SCHEMA SalonEnigma ;
use SalonEnigma;
create user 'usuario_1'@'%' identified by 'cliente_1';

grant all privileges on SalonEnigma.* to 'usuario_1'@'%';

flush privileges;

create table accesorios (
    id_accesorios INT AUTO_INCREMENT PRIMARY KEY,
    nombre_accesorio varchar(255) not null,
    descripcion VARCHAR(255),
    precio double not null,
    existencias int not null,
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);

create table carrito (
    id_carrito INT AUTO_INCREMENT PRIMARY KEY,
    nombre_carrito varchar(255) not null,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);

create table conozcanos(
    id_conozcanos INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(1024)
);

create table servicios (
    id_servicios INT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(255),
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN
);

create table sucursales (
    id_sucursales INT AUTO_INCREMENT PRIMARY KEY,
    nombre_sucursal VARCHAR(255),
    descripcion VARCHAR(255),
    ruta_imagen VARCHAR(255),
    ubicacion VARCHAR(1024),
    activo BOOLEAN
);

create table usuario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    password varchar(512) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    correo VARCHAR(25) NULL,
    telefono VARCHAR(15) NULL,
    ruta_imagen varchar(1024),
    activo boolean,
    PRIMARY KEY (`id_usuario`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre varchar(20),
    id_usuario int,
    PRIMARY KEY (id_rol),
    foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into usuario (id_usuario, username, password, nombre, apellidos, correo, telefono, ruta_imagen, activo) values 
(1,'Cristiano','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Cristiano', 'Mora', 'cristiano@gmail.com', '4556-8978', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FUsuarios%2FCris.png?alt=media&token=9fddcd28-305d-4120-8ce3-7e857b60d8cc',true),
(2,'Messi','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Messi', 'Pérez Messi', 'messi@gmail.com', '5456-8789','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FUsuarios%2FMessi.png?alt=media&token=eea3e27f-30a8-47d2-809f-5533c13b0eab',true),
(3,'Dembele','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Dembele', 'Mena', 'dembele@gmail.com', '7898-8936','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FUsuarios%2Fdembele.png?alt=media&token=0fe5c053-e090-4cf3-8081-4ae0b8b0733a',true);

insert into conozcanos (id_conozcanos, descripcion, ruta_imagen) values 
(1, 'Información', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FIconoInfo.png?alt=media&token=e941b81a-c89a-4f06-8c4d-6c8ce01a8eda'),
(2, 'Contáctenos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FIconoContactenos.png?alt=media&token=53d45252-8218-414d-b584-fdc37adaa284');

insert into rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);

insert into accesorios (id_accesorios, nombre_accesorio, descripcion, precio, existencias, ruta_imagen, activo) values 
('1','Silla Profesional', 'Ideal para brindar comodidad y estilo a tus clientes.', 150.00, 10, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fsilla.png?alt=media&token=ecd78915-1ad0-428c-8fac-bed2303a9b0c', true), 
('2','Secadora Profesional', 'Potente y eficiente para obtener resultados profesionales.', 200.00, 15, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fsecador.png?alt=media&token=0b30a518-51c1-4618-8135-943cf197bd38', true),
('3','Tijeras para Cortar Cabello','Precisas y ergonómicas para lograr cortes perfectos.', 80.00, 20, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Ftijeras.png?alt=media&token=b6391486-a0d0-4337-835b-732bc02b72d1',true),
('4','Plancha Profesional','Consigue un cabello liso y brillante con esta plancha de alta calidad', 120.00, 12, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fplancha.png?alt=media&token=380ed9af-52c7-43cf-95f9-316258e4aeff',true),
('5','Kit de Peines','Variedad de peines profesionales para todo tipo de estilos y cortes.', 50.00, 25, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fpeine.png?alt=media&token=583ba4d7-67a1-44de-a072-735e62a626e8',true),
('6','Capa Profesional','Mantén a tus clientes cómodos y protegidos durante sus servicios.', 30.00, 18, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fcapa.png?alt=media&token=9cf8be5b-4232-4f88-b22a-f1dff0769eed', false),
('7','Espejo de Maquillaje con Luz','Ideal para aplicar maquillaje con precisión gracias a su iluminación LED.', 70.00, 8, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fespejo.png?alt=media&token=de1138a7-d564-436b-bad2-f639d3711a21', true),
('8','Cepillo Profesional','Perfecto para desenredar y dar volumen al cabello.', 40.00, 30, 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FAccesorios%2Fcepillo.png?alt=media&token=033a34aa-e1bc-460f-82dc-822d47ae6a5e', true);

insert into servicios (id_servicios, nombre_servicio, descripcion, ruta_imagen, activo) values      
    (1, 'Corte de cabello', 'Dar forma y estilizar el cabello con los mejores productos y estilistas de la zona', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fcorte.png?alt=media&token=90b21f02-a34b-4cb8-a699-16f3d7973d44', true),     
    (2, 'Queratina', 'Tratamiento para suavizar y reparar el cabello dañado. En tan solo unas hora tu cabello lucira como nuevo', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fqueratina.png?alt=media&token=8fe9b9e6-b8db-4ea2-b5ef-7014c5060e77', true),     
    (3, 'Tinte', 'Proceso para cambiar el tono del cabello y cambiarlo al tono o color de tu preferencia', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Ftinte.png?alt=media&token=cc33ab67-48f3-4466-8d94-faca4b6e6e4a', true),     
    (4, 'Manicura', 'Servicio de cuidado, pintado y esmaltado de las uñas de las manos, con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fmanicura.png?alt=media&token=abcd9f7e-04dd-4c0d-ac53-89d49ec0a730', true),     
    (5, 'Pedicura', 'Servicio de cuidado de las uñas de los pies con los mejores productos y maquinas del mercado', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fpedicura.png?alt=media&token=ddbfaeb7-197a-4f91-87ae-f844929c3602', true),
    (6, 'Gel X', 'Método de aplicación de uñas de gel con una duración grantizada ya que se hace con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fgell%20x.png?alt=media&token=a1fb644d-366e-4894-9d92-f8136578fe8b', true),
    (7, 'Tratamiento capilar de hidratación profunda', 'Tratamiento que proporciona hidratación intensiva al cabello', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fhidratacion.png?alt=media&token=4be18df3-792e-4b1d-a1c5-e2bed13d3eb4', true),     
    (8, 'Maquillaje profesional', 'Servicio de maquillaje realizado por los mejores estilistas de la zona y con los mejores productos', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FServicios%2Fmaquillaje.png?alt=media&token=e91cb533-c6bf-47ab-a6f1-410a37389210', true);

insert into sucursales ( id_sucursales, nombre_sucursal, descripcion, ruta_imagen, ubicacion, activo) values 
    (1,'Zapote', '500mts al norte de multiplaza del este', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FZapote.png?alt=media&token=ef96ad12-8a9a-469e-8bd8-4a8ebf64ef3d', '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3930.149431052117!2d-84.05770538820262!3d9.921510290139038!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0e39ee6a4dc8b%3A0xb92fa606d766a180!2sSan%20Jos%C3%A9%2C%20Zapote!5e0!3m2!1ses!2scr!4v1713798666657!5m2!1ses!2scr" width="465" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', true),
    (2,'Desamparados', '100 mts este del multicentro, desamparados', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FDesamparados.png?alt=media&token=2d4d47b9-a824-43fb-bbea-25a89f1172f1', '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15721.836887212135!2d-84.07123409041706!3d9.895656992617!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0e2e34751040b%3A0x2631b3acf1783ed9!2sSan%20Jos%C3%A9%2C%20Desamparados!5e0!3m2!1ses!2scr!4v1713798687948!5m2!1ses!2scr" width="465" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', true),
    (3,'Guadalupe', '200mts oeste del Centro comercial de guadalupe', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FGuadalupe.png?alt=media&token=2acafb4e-26e3-4ef1-b628-b62687c9e139', '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15721.836887212135!2d-84.07123409041706!3d9.895656992617!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0e47b29807d63%3A0xac204eb1e99176ea!2sSan%20Jos%C3%A9%2C%20Guadalupe!5e0!3m2!1ses!2scr!4v1713798707000!5m2!1ses!2scr" width="465" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>', true);


