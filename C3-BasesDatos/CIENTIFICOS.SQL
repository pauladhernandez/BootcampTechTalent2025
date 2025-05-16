
CREATE TABLE `asignado` (
  `cientificos` varchar(9) NOT NULL,
  `proyectos` char(4) NOT NULL) 

INSERT INTO asignado (cientificos, proyectos) VALUES
('12345678', 'P001'),
('23456789', 'P002'),
('34567890', 'P003'),
('45678901', 'P004'),
('56789012', 'P005'),
('67890123', 'P006'),
('78901234', 'P007'),
('89012345', 'P008'),
('90123456', 'P009'),
('01234567', 'P010');


CREATE TABLE `cientificos` (
  `dni` varchar(9) NOT NULL,
  `nomapels` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL) 

INSERT INTO cientificos (dni, nomapels) VALUES
('12345678', 'Ana Martínez'),
('23456789', 'Luis Pérez'),
('34567890', 'Carlos Gómez'),
('45678901', 'María López'),
('56789012', 'Lucía Torres'),
('67890123', 'Jorge Ramírez'),
('78901234', 'Elena Fernández'),
('89012345', 'Manuel Ruiz'),
('90123456', 'Carmen Sánchez'),
('01234567', 'David Herrera');


CREATE TABLE `proyectos` (
  `id` char(4) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `horas` int(11) DEFAULT NULL) 

INSERT INTO proyecto (id, nombre, horas) VALUES
('P001', 'Proyecto Alfa', 120),
('P002', 'Proyecto Beta', 80),
('P003', 'Proyecto Gamma', 200),
('P004', 'Proyecto Delta', 60),
('P005', 'Proyecto Epsilon', 150),
('P006', 'Proyecto Zeta', 90),
('P007', 'Proyecto Eta', 110),
('P008', 'Proyecto Theta', 75),
('P009', 'Proyecto Iota', 130),
('P010', 'Proyecto Kappa', 100);
