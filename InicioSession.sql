CREATE DATABASE inicioSesion;

USE inicioSesion;

CREATE TABLE administrador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contraseña VARCHAR(255)
);

CREATE TABLE colaborador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contraseña VARCHAR(255)
);

INSERT INTO administrador (nombre, correo, contraseña)
VALUES ('Zaira', 'zaira@gmail.com', '4dm1nS0S5');

INSERT INTO colaborador (nombre, correo, contraseña)
VALUES ('Gabriela', 'gabs@gmail.com', 'c014b0r4d0r');

INSERT INTO colaborador (nombre, correo, contraseña)
VALUES ('Emmanuel', 'consuelo@gmail.com', '123456');