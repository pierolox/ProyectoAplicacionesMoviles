CREATE DATABASE usuarios_db;
USE usuarios_db;

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE habito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    categoria_id INT,
    usuario_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

INSERT INTO usuarios (nombre, correo, contrasena)
VALUES 
('Juan Pérez', 'juan@example.com', '123456'),
('María López', 'maria@example.com', 'abcdef'),
('Carlos Gómez', 'carlos@example.com', 'qwerty');

SELECT * FROM usuarios;
