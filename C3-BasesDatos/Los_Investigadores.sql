
CREATE TABLE `Equipos` (
  `NumSerie` char(4) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Facultad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO Equipos (NumSerie, Nombre, Facultad) VALUES
('E001', 'Microscopio', 5),
('E002', 'Ordenador HP', 1),
('E003', 'Impresora 3D', 3),
('E004', 'Centrífuga', 8),
('E005', 'Telescopio', 10),
('E006', 'Resonador', 2),
('E007', 'Estación meteorológica', 9),
('E008', 'Proyector', 6),
('E009', 'Escáner corporal', 2),
('E010', 'Simulador jurídico', 4);


CREATE TABLE `Facultad` (
  `Código` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO Facultad (Código, Nombre) VALUES
(1, 'Ingeniería'),
(2, 'Medicina'),
(3, 'Arquitectura'),
(4, 'Derecho'),
(5, 'Biología'),
(6, 'Filosofía'),
(7, 'Psicología'),
(8, 'Química'),
(9, 'Matemáticas'),
(10, 'Física');


CREATE TABLE `Investigadores` (
  `DNI` varchar(8) NOT NULL,
  `NomApels` varchar(255) NOT NULL,
  `Facultad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO Investigadores (DNI, NomApels, Facultad) VALUES
('10000001', 'Laura Gómez', 1),
('10000002', 'Pedro Torres', 2),
('10000003', 'Sandra Ruiz', 3),
('10000004', 'Luis Ramírez', 4),
('10000005', 'Diana Moreno', 5),
('10000006', 'Andrés Castaño', 6),
('10000007', 'Valeria Ríos', 7),
('10000008', 'Diego Paredes', 8),
('10000009', 'Nicolás Herrera', 9),
('10000010', 'Camila Díaz', 10);


CREATE TABLE `Reserva` (
  `DNI` varchar(8) NOT NULL,
  `NumSerie` char(4) NOT NULL,
  `Comienzo` datetime DEFAULT NULL,
  `Fin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO Reserva (DNI, NumSerie, Comienzo, Fin) VALUES
('10000001', 'E002', '2025-05-01 08:00:00', '2025-05-01 12:00:00'),
('10000002', 'E006', '2025-05-02 09:00:00', '2025-05-02 13:00:00'),
('10000003', 'E003', '2025-05-03 10:00:00', '2025-05-03 14:00:00'),
('10000004', 'E010', '2025-05-04 11:00:00', '2025-05-04 15:00:00'),
('10000005', 'E001', '2025-05-05 08:30:00', '2025-05-05 11:30:00'),
('10000006', 'E008', '2025-05-06 09:30:00', '2025-05-06 12:30:00'),
('10000007', 'E007', '2025-05-07 10:30:00', '2025-05-07 13:30:00'),
('10000008', 'E004', '2025-05-08 11:30:00', '2025-05-08 14:30:00'),
('10000009', 'E009', '2025-05-09 12:00:00', '2025-05-09 16:00:00'),
('10000010', 'E005', '2025-05-10 13:00:00', '2025-05-10 17:00:00');