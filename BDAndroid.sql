CREATE DATABASE usuarios_db;
USE usuarios_db;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (nombre, correo, contrasena)
VALUES 
('Juan Pérez', 'juan@example.com', '123456'),
('María López', 'maria@example.com', 'abcdef'),
('Carlos Gómez', 'carlos@example.com', 'qwerty');

SELECT * FROM usuarios;

SELECT * FROM usuarios WHERE correo = 'juan@example.com';

UPDATE usuarios 
SET contrasena = 'nuevaClave123' 
WHERE correo = 'juan@example.com';

DELETE FROM usuarios WHERE correo = 'carlos@example.com';
