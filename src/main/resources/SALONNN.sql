create database SalonEnigma;

use SalonEnigma;

create user 'usuario_1'@'%' identified by 'cliente_1';

grant all privileges on SalonEnigma.* to 'usuario_1'@'%';

flush privileges;

CREATE TABLE Accesorios (
    id_accesorios INT AUTO_INCREMENT PRIMARY KEY,
    nombre_accesorio varchar(255) not null,
    descripcion VARCHAR(255),
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
    ruta_imagen VARCHAR(255),
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


INSERT INTO Accesorios (id_accesorios, nombre_accesorio, descripcion, ruta_imagen, activo) VALUES 
('1','Silla Profesional', 'Ideal para brindar comodidad y estilo a tus clientes.', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fsilla.jpg?alt=media&token=05eaf633-2201-4d5d-8588-72cc19a83595', true), 
('2','Secadora Profesional', 'Potente y eficiente para obtener resultados profesionales.','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fsecadora.jpg?alt=media&token=c9965501-8860-4958-9940-e803ddf3309b', true),
('3','Tijeras para Cortar Cabello','Precisas y ergonómicas para lograr cortes perfectos.','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FTIJERAS.jpg?alt=media&token=3bc7fb9c-de3a-4632-b832-6335302d73f5',true),
('4','Plancha Profesional','Consigue un cabello liso y brillante con esta plancha de alta calidad','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fplancha%20cabello.png?alt=media&token=2b5d2089-4fbd-4af1-b2c8-0941b9b34ca0',true),
('5','Kit de Peines','Variedad de peines profesionales para todo tipo de estilos y cortes.','https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fkit%20de%20peines.png?alt=media&token=b859775b-21bc-4d48-9b06-70ce4cba5287',true),
('6','Capa Profesional','Mantén a tus clientes cómodos y protegidos durante sus servicios.', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fcapa.png?alt=media&token=02fbf9f7-b828-4455-8e9c-b2150f6511e1', false);

INSERT INTO Servicios (id_servicios, nombre_servicio, descripcion, ruta_imagen, activo)  
VALUES      
    (1, 'corte', 'Dar forma, recortar y estilizar el cabello', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fcorte.png?alt=media&token=460421ae-fe22-4f19-bf10-81a7391ec992', true),     
    (2, 'Queratina', 'Tratamiento para el cabello que ayuda a suavizar, alisar y reparar el cabello dañado', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Fqueratina.png?alt=media&token=d53e8e53-98ce-441c-aaa1-8d2e27ec9dce', true),     
    (3, 'Tinte', 'Proceso de aplicar color artificial al cabello para cambiar su tono', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2Ftinte.png?alt=media&token=9ea294ac-79db-44bf-b3ba-bbafaf41c43d', true),     
    (4, 'Manicura', 'Servicio de cuidado de las uñas de las manos, que incluye limado, recorte, pulido y aplicación de esmalte', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FManicura.png?alt=media&token=57030465-3651-4b1d-97c8-91e81e1f1f94', true),     
    (5, 'Pedicura', 'Servicio de cuidado de las uñas de los pies, que incluye limado, recorte, pulido y aplicación de esmalte', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FPedicura.png?alt=media&token=e8e3deba-b23c-4206-8d89-4c9cbee0de1f', true),     
    (6, 'Gel X', 'Método de aplicación de uñas de gel que utiliza puntas preformadas y gel específico para una apariencia y durabilidad mejoradas', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FGelX.png?alt=media&token=cc33b05e-0f3f-4bdf-a5f9-d826d7a876b4', true);


INSERT INTO Sucursales (id_sucursales, nombre_sucursal, descripcion, ruta_imagen, activo) 
VALUES 
    (1, 'Zapote', '500mts al norte de multiplaza del este', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FZapote.png?alt=media&token=ef96ad12-8a9a-469e-8bd8-4a8ebf64ef3d', true),
    (2, 'Desamparados', '25mts sur y 100 mts este de multicentro desamparados', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FDesamparados.png?alt=media&token=2d4d47b9-a824-43fb-bbea-25a89f1172f1', true),
    (3, 'Guadalupe', '200mts oeste del Centro comercial de guadalupe', 'https://firebasestorage.googleapis.com/v0/b/enigmasalon-4beba.appspot.com/o/Salon%2FGuadalupe.png?alt=media&token=2acafb4e-26e3-4ef1-b628-b62687c9e139', true);

drop database SalonEnigma;

SELECT *FROM  Servicios

