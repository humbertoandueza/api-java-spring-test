CREATE DATABASE azurian; 
USE azurian;

CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;


INSERT INTO `clients` (`first_name`, `last_name`, `address`, `email`, `phone`)
VALUES
('Juan', 'Pérez', 'Calle A, Ciudad X', 'juan@example.com', '123456789'),
('María', 'García', 'Calle B, Ciudad Y', 'maria@example.com', '987654321'),
('Carlos', 'Rodríguez', 'Calle C, Ciudad Z', 'carlos@example.com', '567890123'),
('Ana', 'López', 'Calle D, Ciudad W', 'ana@example.com', '345678901'),
('Roberto', 'Martínez', 'Calle E, Ciudad V', 'roberto@example.com', '234567890'),
('Laura', 'Sánchez', 'Calle F, Ciudad U', 'laura@example.com', '456789012'),
('Pedro', 'Ramírez', 'Calle G, Ciudad T', 'pedro@example.com', '678901234'),
('Carmen', 'Ruiz', 'Calle H, Ciudad S', 'carmen@example.com', '789012345'),
('Francisco', 'Torres', 'Calle I, Ciudad R', 'francisco@example.com', '890123456'),
('Isabel', 'Gómez', 'Calle J, Ciudad Q', 'isabel@example.com', '901234567'),
('Miguel', 'González', 'Calle K, Ciudad P', 'miguel@example.com', '012345678'),
('Elena', 'Herrera', 'Calle L, Ciudad O', 'elena@example.com', '321098765'),
('Antonio', 'Jiménez', 'Calle M, Ciudad N', 'antonio@example.com', '210987654'),
('Marta', 'Castro', 'Calle N, Ciudad M', 'marta@example.com', '109876543'),
('David', 'Molina', 'Calle O, Ciudad L', 'david@example.com', '098765432'),
('Beatriz', 'Ortega', 'Calle P, Ciudad K', 'beatriz@example.com', '987654321'),
('José', 'Nuñez', 'Calle Q, Ciudad J', 'jose@example.com', '876543210'),
('Patricia', 'Medina', 'Calle R, Ciudad I', 'patricia@example.com', '765432109'),
('Javier', 'Romero', 'Calle S, Ciudad H', 'javier@example.com', '654321098'),
('Rosa', 'Fernández', 'Calle T, Ciudad G', 'rosa@example.com', '543210987'),
('Sergio', 'Aguilar', 'Calle U, Ciudad F', 'sergio@example.com', '432109876'),
('Carolina', 'Navarro', 'Calle V, Ciudad E', 'carolina@example.com', '321098765'),
('Raúl', 'Díaz', 'Calle W, Ciudad D', 'raul@example.com', '210987654'),
('Susana', 'Bravo', 'Calle X, Ciudad C', 'susana@example.com', '109876543'),
('Jorge', 'Vargas', 'Calle Y, Ciudad B', 'jorge@example.com', '098765432'),
('Paula', 'Ríos', 'Calle Z, Ciudad A', 'paula@example.com', '987654321'),
('Alberto', 'Mendoza', 'Calle A1, Ciudad Z', 'alberto@example.com', '876543210'),
('Silvia', 'Jiménez', 'Calle B1, Ciudad Y', 'silvia@example.com', '765432109'),
('Ángel', 'Guzmán', 'Calle C1, Ciudad X', 'angel@example.com', '654321098'),
('Natalia', 'Cordero', 'Calle Z1, Ciudad W', 'natalia@example.com', '567890123');