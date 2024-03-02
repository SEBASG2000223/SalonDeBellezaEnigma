create database SalonEnigma;

use SalonEnigma;

create user 'usuario_1'@'%' identified by 'cliente_1';

grant all privileges on SalonEnigma.* to 'usuario_1'@'%';

flush privileges;