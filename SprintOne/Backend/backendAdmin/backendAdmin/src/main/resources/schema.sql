CREATE TABLE admins (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        dni VARCHAR(50) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL
);
INSERT INTO admins (name, dni, password) VALUES
             ('Admin Principal', '11111111A', '$2a$10$X7...hash_ejemplo_seguro_1'),
             ('Supervisor Juan', '22222222B', '$2a$10$Y9...hash_ejemplo_seguro_2'),
             ('Gestora Maria', '33333333C', '$2a$10$Z1...hash_ejemplo_seguro_3'),
             ('Soporte Pedro', '44444444D', '$2a$10$A2...hash_ejemplo_seguro_4'),
             ('Auditora Laura', '55555555E', '$2a$10$B3...hash_ejemplo_seguro_5');