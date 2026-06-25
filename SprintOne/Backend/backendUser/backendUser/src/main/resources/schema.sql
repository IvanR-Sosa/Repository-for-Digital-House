-- Crear tabla users
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       dni VARCHAR(50) NOT NULL
);

-- Insertar registros de ejemplo
INSERT INTO users (name, dni) VALUES ('Laura Gómez', '12345678');
INSERT INTO users (name, dni) VALUES ('Pedro Martínez', '87654321');
