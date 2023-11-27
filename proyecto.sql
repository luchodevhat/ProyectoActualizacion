CREATE DATABASE proyecto;

USE proyecto;


drop table miembro;
drop table rol;

CREATE TABLE vape (
	id_vape INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN,
    valor INT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE miembro (
	id_miembro INT PRIMARY KEY AUTO_INCREMENT,
    identificacion VARCHAR(9) NOT NULL,
    edad INT NOT NULL,
    ruta_imagen VARCHAR(1024) DEFAULT "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(20) NOT NULL,
    contrasena VARCHAR(60) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    activo BOOLEAN NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE Rol (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(25),
    id_miembro INT,
	foreign key (id_miembro) references Miembro(id_miembro)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


CREATE USER 'proyecto'@'localhost' IDENTIFIED BY 'la_Clave';
GRANT ALL PRIVILEGES ON *.* TO 'proyecto'@'localhost';
FLUSH PRIVILEGES;


DELETE FROM Miembro;

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('111111111', 25, 'Elena', 'Garcia', 'pass123', 'elenag', 'elena@email.com', '1111111111', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('222222222', 30, 'Carlos', 'Lopez', 'pass456', 'carlosl', 'carlos@email.com', '2222222222', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('333333333', 35, 'Maria', 'Rodriguez', 'pass789', 'mariar', 'maria@email.com', '3333333333', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('444444444', 40, 'Pedro', 'Martinez', 'passabc', 'pedrom', 'pedro@email.com', '4444444444', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('555555555', 45, 'Laura', 'Gomez', 'passdef', 'laurag', 'laura@email.com', '5555555555', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('666666666', 50, 'Antonio', 'Fernandez', 'pass123', 'antoniof', 'antonio@email.com', '6666666666', false);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('777777777', 55, 'Isabel', 'Lopez', 'pass456', 'isabell', 'isabel@email.com', '7777777777', false);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('888888888', 60, 'Manuel', 'Garcia', 'pass789', 'manuelg', 'manuel@email.com', '8888888888', true);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('999999999', 65, 'Marta', 'Rodriguez', 'passabc', 'martar', 'marta@email.com', '9999999999', false);

INSERT INTO miembro (identificacion, edad, nombre, apellidos, contrasena, username, correo, telefono, activo)
VALUES ('101010101', 70, 'Javier', 'Lopez', 'passdef', 'javierl', 'javier@email.com', '1010101010', true);



INSERT INTO vape (nombre, ruta_imagen, activo, valor)
VALUES
    ('Vape 1', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605425277546526/elf-bar-disposable-apple-peach.webp?ex=6576c0d6&is=65644bd6&hm=3fff9c3db20732a868dead91cbc89e2ad5125027054b0bef47ee1dfe6e6b5a2d&', 1, 20),
    ('Vape 2', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605425634070629/elf-bar-disposable-blue-razz-lemonade.webp?ex=6576c0d6&is=65644bd6&hm=9d83902b9dd87d4d46a340f6997bc87b097ff6edad2ca3d25ec8a54db8614fc8&', 0, 25),
    ('Vape 3', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605426036715590/elf-bar-disposable-grape.webp?ex=6576c0d6&is=65644bd6&hm=b3a3dabb3c56f74ce526c65bc2946ed40836dd19f4ad81a610f9f5986798bc73&', 1, 30),
    ('Vape 4', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605426414194759/elf-bar-disposable-lychee-ice.webp?ex=6576c0d7&is=65644bd7&hm=944d4c31bfbc958507a00e2759eef58c4580ff2f915d8b3cf69c9f22dc37137a&', 1, 15),
    ('Vape 5', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605427068522537/elf-bar-disposable-mango.webp?ex=6576c0d7&is=65644bd7&hm=d1f0564c42ec4400ede48f80b8683a0a14d3c5dc31b1c388743c7011f483670b&', 0, 10),
    ('Vape 6', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605427399864360/elf-bar-disposable-pink-lemonade.webp?ex=6576c0d7&is=65644bd7&hm=efc03dd01a7387e30012d8842e72d85be018b0743e29b9d5cc8e843c0988786d&', 1, 35),
    ('Vape 7', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605427760566313/elf-bar-disposable-strawberry-ice.webp?ex=6576c0d7&is=65644bd7&hm=e82a230e6f339b09d9afc0f7f9b601103f5486e21ec86f4444a6a543d09b9d07&', 0, 18),
    ('Vape 8', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605428087730286/elf-bar-disposable-cotton-candy-ice.webp?ex=6576c0d7&is=65644bd7&hm=ae8aa0e4b87d5eb786070eee489d06fe35eb9d1057bcbc6b7932f0dd7ac83e34&', 1, 22),
    ('Vape 9', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605428456820736/elf-bar-disposable-kiwi-passionfruit-guava.webp?ex=6576c0d7&is=65644bd7&hm=77f81ac969d69998d96411ecfda2f8a0b411ad1f3a0c6bc378a3d82c12d8418d&', 1, 28),
    ('Vape 10', 'https://cdn.discordapp.com/attachments/935264591305392151/1178605428775604224/elf-bar-disposable-strawberry-banana.webp?ex=6576c0d7&is=65644bd7&hm=b822612aeb15b30f60a8dee3ab3567971dda225a4a1643643e9d23aa3e475a82&', 0, 12);


