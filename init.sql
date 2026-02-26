CREATE DATABASE IF NOT EXISTS biblioteca_bd;
USE biblioteca_bd;

-- Tabla: rol
CREATE TABLE rol (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    roles VARCHAR(150)
);

-- Tabla: trabajadores
CREATE TABLE trabajadores (
    id_trabajador INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150),
    apellido VARCHAR(150),
    email VARCHAR(150),
    edad INT,
    password VARCHAR(150),
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

-- Tabla: categoria
CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria VARCHAR(150)
);

-- Tabla: autores
CREATE TABLE autores (
    id_autores INT PRIMARY KEY AUTO_INCREMENT,
    nombre_autores VARCHAR(150),
    nacionalidad VARCHAR(150)
);

-- Tabla: usuario
CREATE TABLE usuario (
    id_usuario int primary key auto_increment,
    nombre_usuario varchar(150),
    apellido_usuario varchar(150),
    dni varchar(8),
    correo varchar(150),
    telefono varchar(9),
    direccion varchar(150),
    genero varchar(50),
    fecha_nacimiento varchar(150)
);


-- Tabla: estado_libro
CREATE TABLE estado_libro (
    id_estado INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(50)
);

-- Tabla: libros
CREATE TABLE libros (
    id_libros INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150),
    anio INT,
    isbn VARCHAR(150),
    editorial VARCHAR(150),
    id_autores INT,
    id_categoria INT,
    id_estado INT,
    FOREIGN KEY (id_autores) REFERENCES autores (id_autores),
    FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria),
    FOREIGN KEY (id_estado) REFERENCES estado_libro (id_estado)
);

-- Tabla: prestamos
CREATE TABLE prestamos (
    id_prestamos INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_libros INT,
    fecha_prestamo VARCHAR(150),
    fecha_devolucion VARCHAR(150),
    fecha_real VARCHAR(150),
    multa DECIMAL(10,2),
    id_estado INT,
    comentarios VARCHAR(250),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_libros) REFERENCES libros (id_libros),
    FOREIGN KEY (id_estado) REFERENCES estado_libro (id_estado)
);

-- Registros: rol
INSERT INTO rol (roles) VALUES 
('Administrador'),
('Auxiliar de Biblioteca'),
('Bibliotecario'),
('Estudiante'),
('Profesor'),
('Usuario General');

-- Registros: trabajadores
/*INSERT INTO trabajadores (nombre, apellido, email, edad, password, id_rol) VALUES
('Andrea', 'Paredes', 'andrea.paredes@biblioteca.edu', 29, 'andrea789', 3),
('Carlos', 'Mejía', 'carlos.mejia@biblioteca.edu', 42, 'carlos456', 2),
('Jorge', 'Salazar', 'jorge.salazar@biblioteca.edu', 26, 'jorge987', 4),
('Luis', 'Torres', 'luis.torres@biblioteca.edu', 21, 'luis321', 5),
('Lucía', 'Ramírez', 'lucia.ramirez@biblioteca.edu', 35, 'lucia123', 1),
('María', 'Fernández', 'maria.fernandez@biblioteca.edu', 38, 'maria654', 6);*/

/*INSERT INTO trabajadores (nombre, apellido, email, edad, password, id_rol) VALUES
('Andrea', 'Paredes', 'andrea.paredes@biblioteca.edu', 29, 'andrea789', 3);*/

-- Registros: categoria
INSERT INTO categoria (nombre_categoria) VALUES
('Arte'),
('Biografía'),
('Ciencia'),
('Derecho'),
('Educación'),
('Filosofía'),
('Geografía'),
('Historia'),
('Infantil'),
('Literatura'),
('Matemáticas'),
('Novela'),
('Psicología'),
('Religión'),
('Tecnología');

-- Registros: autores
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

-- Registros: usuario
INSERT INTO usuario 
(nombre_usuario, apellido_usuario, dni, correo, telefono, direccion, genero, fecha_nacimiento)
VALUES
('Mónica', 'Ruiz', '70238491', 'monica.r@example.com', '931283746', 'Av. Benavides 41', 'Femenino', '1998-04-12'),
('Hector', 'Iglesias', '71092837', 'hector.i@example.com', '974839276', 'Jr. Tarapacá 84', 'Masculino', '1995-11-03'),
('Renzo', 'Vargas', '71234562', 'renzo.vargas@example.com', '987000111', 'Av. Colonial 305', 'Masculino', '1997-06-22'),
('Felipe', 'Castro', '71328473', 'felipe.cast@example.com', '988121212', 'Calle San Martín 312', 'Masculino', '1996-02-18'),
('Tatiana', 'Núñez', '71328495', 'tatiana.n@example.com', '983746182', 'Av. Independencia 67', 'Femenino', '1999-09-30'),
('Elena', 'Mejía', '72384910', 'elena.mejia@example.com', '972345678', 'Calle Callao 333', 'Femenino', '1994-07-15'),
('Oscar', 'Salinas', '72819012', 'oscar.s@example.com', '999000111', 'Pasaje Puno 58', 'Masculino', '1992-12-10'),
('Karla', 'Zegarra', '72938475', 'karla.z@example.com', '963258741', 'Av. Wilson 320', 'Femenino', '2000-01-25'),
('Fiorella', 'Castillo', '73219485', 'fiorella.c@example.com', '987987987', 'Jr. Ancash 132', 'Femenino', '1998-03-14'),
('Ivan', 'Vargas', '73219837', 'ivan.v@example.com', '911987654', 'Calle Bolívar 210', 'Masculino', '1993-06-08'),

('Sofia', 'Flores', '73482930', 'sofia.flores@example.com', '987889900', 'Av. Tacna 300', 'Femenino', '1997-09-19'),
('Alonso', 'Diaz', '73912038', 'alonso.d@example.com', '944556677', 'Calle Grau 128', 'Masculino', '1991-05-04'),
('Alvaro', 'Morales', '74583920', 'alvaro.m@example.com', '910928374', 'Pasaje Huascarán 14', 'Masculino', '1990-10-21'),
('Luis', 'Martinez', '74829361', 'luis.martinez@example.com', '912345678', 'Av. Perú 123', 'Masculino', '1996-08-11'),
('Marco', 'Rojas', '75123987', 'marco.rojas@example.com', '921234567', 'Calle Misti 108', 'Masculino', '1995-02-02'),
('Lucia', 'Ramirez', '75201394', 'lucia.r@example.com', '901283746', 'Calle Amazonas 50', 'Femenino', '1999-11-17'),
('Valeria', 'Gomez', '75438901', 'valeria.g@example.com', '976543210', 'Calle Cuzco 212', 'Femenino', '2001-04-09'),
('Diego', 'Fernandez', '75839172', 'diego.fernandez@example.com', '932849392', 'Calle Piura 100', 'Masculino', '1994-01-30'),
('Francisco', 'Ortega', '75918273', 'francisco.o@example.com', '999321123', 'Av. La Marina 156', 'Masculino', '1992-06-16'),
('Rodrigo', 'Castro', '76019284', 'rodrigo.c@example.com', '977889900', 'Av. Pizarro 88', 'Masculino', '1989-12-05'),

('Andres', 'Quispe', '76382918', 'andres.q@example.com', '912345901', 'Jr. Loreto 98', 'Masculino', '1993-07-27'),
('Diana', 'Vega', '76582910', 'diana.v@example.com', '998231456', 'Calle Ayaviri 260', 'Femenino', '1998-10-13'),
('Pedro', 'Torres', '76583920', 'pedro.torres@example.com', '911223344', 'Jr. Ica 901', 'Masculino', '1991-03-22'),
('Jorge', 'Salazar', '76829401', 'jorge.salazar@example.com', '924578932', 'Pasaje El Sol 12', 'Masculino', '1990-09-18'),
('Ricardo', 'Paredes', '76839201', 'ricardo.p@example.com', '954321789', 'Jr. Huánuco 221', 'Masculino', '1995-05-29'),
('Camila', 'Moreno', '76930128', 'camila.mor@example.com', '945001122', 'Jr. Junín 88', 'Femenino', '2000-02-07'),
('Brenda', 'Cruz', '78120394', 'brenda.c@example.com', '978654321', 'Jr. Santa Rosa 74', 'Femenino', '1999-06-03'),
('Carlos', 'Rodriguez', '78391027', 'carlos.rod@example.com', '913214589', 'Jr. Los Andes 789', 'Masculino', '1992-11-24'),
('Tomas', 'Navarro', '78392018', 'tomas.n@example.com', '911112223', 'Av. Bolognesi 456', 'Masculino', '1994-08-01'),
('Natalia', 'Huaman', '78503918', 'natalia.h@example.com', '974839210', 'Jr. Moquegua 700', 'Femenino', '1997-12-12'),

('Gabriel', 'Mendoza', '78903412', 'gabriel.m@example.com', '987231456', 'Av. Grau 145', 'Masculino', '1991-04-26'),
('Esteban', 'Lopez', '78932174', 'esteban.l@example.com', '954123789', 'Jr. Miraflores 45', 'Masculino', '1990-01-09'),
('Maria', 'Paz', '79128364', 'maria.pz@example.com', '956782341', 'Av. Brasil 321', 'Femenino', '1998-05-20'),
('Paula', 'Soto', '79234567', 'paula.s@example.com', '933221122', 'Pasaje Ucayali 109', 'Femenino', '2001-03-15'),
('Daniela', 'Luna', '79384017', 'daniela.l@example.com', '965432100', 'Av. Arequipa 1120', 'Femenino', '1996-07-06'),
('Isabela', 'Espinoza', '79402173', 'isabela.e@example.com', '987111222', 'Jr. Ayacucho 315', 'Femenino', '1999-10-28'),
('Melany', 'Delgado', '79402810', 'melany.d@example.com', '987345601', 'Calle Garcilaso 200', 'Femenino', '2000-12-01'),
('Lourdes', 'Alvarez', '79482301', 'lourdes.a@example.com', '955001100', 'Av. Zorritos 310', 'Femenino', '1995-09-09'),
('Andrea', 'Ramos', '79483920', 'andrea.r@example.com', '965432198', 'Calle Pachacútec 99', 'Femenino', '1997-01-18');

-- Registros: estado_libro
INSERT INTO estado_libro (descripcion) VALUES
('dañado'),
('disponible'),
('mantenimiento'),
('prestado');

-- Registros: libros
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
('Leyendas del Firm', 2002, '978-1-874277-81-1', 'Océano', 12, 9, 1),
('Leyendas del Space', 1983, '978-1-83054-015-7', 'Panamericana', 7, 1, 3),
('Leyendas del Their', 1996, '978-1-04-176679-7', 'Alfaguara', 11, 13, 4),
('Más allá de Former', 2006, '978-1-899226-62-7', 'Paidos', 10, 5, 3),
('Rem saepe vero', 1999, '978-0-231-35619-0', 'Ferrero PLC', 14, 3, 2),
('Sit quisquam amet', 2018, '978-0-89250-867-9', 'Prats and Sons', 1, 13, 4),
('Totam est dolores', 2001, '978-0-482-74467-8', 'Aragón-Quiroga', 8, 12, 3),
('Viaje al And', 2018, '978-0-7440-0914-9', 'Anaya', 14, 5, 2),
('Viaje al Everything', 2010, '978-0-8064-4387-4', 'Norma', 10, 15, 2),
('Viaje al Explain', 1998, '978-1-5416-2812-0', 'McGraw-Hill', 12, 2, 3),
('Viaje al Form', 1993, '978-0-288-54945-3', 'SM', 4, 8, 3),
('Viaje al Rich', 2003, '978-0-212-09604-6', 'McGraw-Hill', 11, 7, 2),
('Viaje al Traditional', 2003, '978-0-7185-2760-0', 'Siglo XXI', 5, 9, 4),
('Viaje al Will', 1983, '978-0-00-253588-5', 'Santillana', 3, 4, 4);

-- Registros: prestamos
INSERT INTO prestamos (id_usuario, id_libros, fecha_prestamo, fecha_devolucion, fecha_real, multa, id_estado, comentarios) VALUES
(1, 1, '2025-06-01', '2025-06-08', '2025-06-08', 0.00, 1, 'Devuelto a tiempo'),
(1, 2, '2025-06-05', '2025-06-12', '2025-06-12', 0.00, 1, 'Correcto'),
(1, 3, '2025-06-09', '2025-06-16', '2025-06-17', 2.00, 2, 'Entrega tardía'),
(1, 4, '2025-06-13', '2025-06-20', '2025-06-20', 0.00, 1, 'Sin observación'),
(1, 1, '2025-06-17', '2025-06-24', '2025-06-24', 0.00, 1, 'Devuelto'),
(1, 2, '2025-06-21', '2025-06-28', '2025-06-28', 0.00, 1, 'Entrega normal'),
(1, 3, '2025-06-25', '2025-07-02', '2025-07-03', 1.00, 2, 'Devuelto un día tarde'),
(2, 2, '2025-06-02', '2025-06-09', '2025-06-10', 2.50, 2, 'Devuelto con retraso'),
(2, 3, '2025-06-06', '2025-06-13', '2025-06-14', 1.50, 2, 'Un día tarde'),
(2, 4, '2025-06-10', '2025-06-17', '2025-06-17', 0.00, 1, 'Entrega correcta'),
(2, 1, '2025-06-14', '2025-06-21', '2025-06-21', 0.00, 1, 'Entregado a tiempo'),
(2, 2, '2025-06-18', '2025-06-25', '2025-06-26', 1.25, 2, 'Devuelto tarde'),
(2, 3, '2025-06-22', '2025-06-29', '2025-06-30', 2.75, 2, 'Retraso'),
(3, 3, '2025-06-03', '2025-06-10', '2025-06-10', 0.00, 1, 'Entrega puntual'),
(3, 4, '2025-06-07', '2025-06-14', '2025-06-14', 0.00, 1, 'Devuelto en fecha'),
(3, 1, '2025-06-11', '2025-06-18', '2025-06-18', 0.00, 1, 'Puntual'),
(3, 2, '2025-06-15', '2025-06-22', '2025-06-22', 0.00, 1, 'Todo bien'),
(3, 3, '2025-06-19', '2025-06-26', '2025-06-26', 0.00, 1, 'Entrega sin problema'),
(3, 4, '2025-06-23', '2025-06-30', '2025-06-30', 0.00, 1, 'Puntual'),
(4, 4, '2025-06-04', '2025-06-11', '2025-06-13', 3.00, 2, 'Demora leve'),
(4, 1, '2025-06-08', '2025-06-15', '2025-06-15', 0.00, 1, 'Sin problemas'),
(4, 2, '2025-06-12', '2025-06-19', '2025-06-21', 4.00, 2, 'Retraso mayor'),
(4, 3, '2025-06-16', '2025-06-23', '2025-06-24', 1.00, 2, 'Leve retraso'),
(4, 4, '2025-06-20', '2025-06-27', '2025-06-27', 0.00, 1, 'Correcto'),
(4, 1, '2025-06-24', '2025-07-01', '2025-07-01', 0.00, 1, 'Sin novedades');