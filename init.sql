CREATE DATABASE IF NOT EXISTS biblioteca_bd;
USE biblioteca_bd;

CREATE TABLE IF NOT EXISTS rol (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    roles VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS trabajadores (
    id_trabajador INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150),
    apellido VARCHAR(150),
    email VARCHAR(150),
    edad INT,
    password VARCHAR(150),
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS autores (
    id_autores INT PRIMARY KEY AUTO_INCREMENT,
    nombre_autores VARCHAR(150),
    nacionalidad VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(150),
    apellido_usuario VARCHAR(150),
    dni VARCHAR(8),
    correo VARCHAR(150),
    telefono VARCHAR(9),
    direccion VARCHAR(150),
    genero VARCHAR(50),
    fecha_nacimiento VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS estado_libro (
    id_estado INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS libros (
    id_libros INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150),
    anio INT,
    isbn VARCHAR(150),
    editorial VARCHAR(150),
    id_autores INT,
    id_categoria INT,
    id_estado INT,
    FOREIGN KEY (id_autores) REFERENCES autores(id_autores),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    FOREIGN KEY (id_estado) REFERENCES estado_libro(id_estado)
);

CREATE TABLE IF NOT EXISTS prestamos (
    id_prestamos INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_libros INT,
    fecha_prestamo VARCHAR(150),
    fecha_devolucion VARCHAR(150),
    fecha_real VARCHAR(150),
    multa DECIMAL(10,2),
    id_estado INT,
    comentarios VARCHAR(250),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_libros) REFERENCES libros(id_libros),
    FOREIGN KEY (id_estado) REFERENCES estado_libro(id_estado)
);

-- Datos iniciales
INSERT INTO rol (roles) VALUES
('Administrador'),
('Auxiliar de Biblioteca'),
('Bibliotecario'),
('Estudiante'),
('Profesor'),
('Usuario General');

INSERT INTO categoria (nombre_categoria) VALUES
('Arte'), ('Biografía'), ('Ciencia'), ('Derecho'), ('Educación'),
('Filosofía'), ('Geografía'), ('Historia'), ('Infantil'), ('Literatura'),
('Matemáticas'), ('Novela'), ('Psicología'), ('Religión'), ('Tecnología');

INSERT INTO autores (nombre_autores, nacionalidad) VALUES
('Alejo de Hoyos', 'Kirguistán'),
('Amparo Parejo-Segarra', 'San Marino'),
('Aura Adelaida Lasa Gámez', 'Mozambique'),
('Aurelio de Nieto', 'Guinea'),
('Conrado Varela Samper', 'Liechtenstein'),
('Emma Taboada Español', 'Sudán del Sur'),
('Isidoro Chamorro Bas', 'Camboya'),
('Lidia Gual Pedraza', 'Albania'),
('Maristela Cuervo Amaya', 'Sudán del Sur'),
('Máximo Mercader Quintanilla', 'Palau'),
('Noé Nicanor Cuéllar Aparicio', 'Países Bajos'),
('Pascuala Casas-Avilés', 'Letonia'),
('Reyna Marti Sacristán', 'Sri Lanka'),
('Roberto Reguera Rico', 'Guinea Bissau'),
('Rosenda Costa Ramírez', 'República Árabe Siria');

INSERT INTO estado_libro (descripcion) VALUES
('dañado'), ('disponible'), ('mantenimiento'), ('prestado');

INSERT INTO libros (titulo, anio, isbn, editorial, id_autores, id_categoria, id_estado) VALUES
('Animi non velit', 1990, '978-0-7080-1569-8', 'Salcedo, Huguet and Báez', 7, 1, 3),
('Aventuras en Gun', 1988, '978-1-4164-4484-8', 'Anaya', 6, 6, 2),
('Aventuras en Herself', 1984, '978-0-8290-8789-5', 'Paidos', 11, 10, 4),
('Crónicas de He', 1991, '978-1-158-86926-8', 'Trillas', 10, 7, 3),
('Crónicas de Probably', 2015, '978-0-270-67634-1', 'Santillana', 14, 3, 3),
('Descubriendo Ball', 2015, '978-0-446-72866-9', 'SM', 11, 3, 2),
('El misterio del Break', 1990, '978-0-290-74233-0', 'Panamericana', 12, 8, 4),
('El misterio del Life', 1991, '978-1-64033-988-0', 'Siglo XXI', 8, 2, 1),
('El secreto de But', 1983, '978-0-691-21975-2', 'Siglo XXI', 14, 6, 4),
('El secreto de Eat', 1995, '978-0-636-70845-7', 'McGraw-Hill', 3, 13, 3),
('Historias de Great', 1984, '978-1-85714-368-3', 'Paidos', 15, 14, 1),
('Historias de Pick', 2019, '978-0-236-30121-8', 'Anaya', 5, 5, 4),
('Historias de Start', 1994, '978-0-435-09057-9', 'Anaya', 10, 5, 2),
('Historias de Will', 2018, '978-1-85503-697-0', 'Paidos', 10, 7, 1),
('La sombra de Common', 2022, '978-0-574-17566-3', 'Panamericana', 5, 13, 1),
('La sombra de Effect', 1983, '978-0-668-89623-8', 'SM', 4, 10, 1),
('La sombra de Guess', 2001, '978-0-87846-931-4', 'McGraw-Hill', 6, 15, 1),
('La sombra de People', 1983, '978-0-7043-8150-6', 'Norma', 2, 15, 4),
('La sombra de Strategy', 2006, '978-0-89465-615-6', 'Panamericana', 10, 12, 3),
('La sombra de Whether', 2000, '978-0-9991331-2-5', 'Trillas', 13, 4, 3),
('Viaje al And', 2018, '978-0-7440-0914-9', 'Anaya', 14, 5, 2),
('Viaje al Everything', 2010, '978-0-8064-4387-4', 'Norma', 10, 15, 2),
('Viaje al Rich', 2003, '978-0-212-09604-6', 'McGraw-Hill', 11, 7, 2);

INSERT INTO usuario (nombre_usuario, apellido_usuario, dni, correo, telefono, direccion, genero, fecha_nacimiento) VALUES
('Mónica', 'Ruiz', '70238491', 'monica.r@example.com', '931283746', 'Av. Benavides 41', 'Femenino', '1998-04-12'),
('Hector', 'Iglesias', '71092837', 'hector.i@example.com', '974839276', 'Jr. Tarapacá 84', 'Masculino', '1995-11-03'),
('Renzo', 'Vargas', '71234562', 'renzo.vargas@example.com', '987000111', 'Av. Colonial 305', 'Masculino', '1997-06-22'),
('Felipe', 'Castro', '71328473', 'felipe.cast@example.com', '988121212', 'Calle San Martín 312', 'Masculino', '1996-02-18'),
('Tatiana', 'Núñez', '71328495', 'tatiana.n@example.com', '983746182', 'Av. Independencia 67', 'Femenino', '1999-09-30');