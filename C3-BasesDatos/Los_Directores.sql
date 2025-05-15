
CREATE TABLE `despachos` (
  `num` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL) 


INSERT INTO `despachos` (`num`, `capacidad`) VALUES
(101, 2),
(102, 3),
(103, 1),
(104, 4),
(105, 2),
(106, 3),
(107, 2),
(108, 5),
(109, 3),
(110, 2);



CREATE TABLE `directores` (
  `DNI` varchar(9) NOT NULL,
  `NomApels` varchar(255) DEFAULT NULL,
  `DNIJefe` varchar(9) DEFAULT NULL,
  `despacho` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



INSERT INTO `directores` (`DNI`, `NomApels`, `DNIJefe`, `despacho`) VALUES
('11111111', 'Carlos Pérez', NULL, 101),
('12345678', 'Sergio Ortega', '44444444', 110),
('22222222', 'Ana Gómez', '11111111', 102),
('33333333', 'Luis Torres', '11111111', 103),
('44444444', 'Elena Ruiz', '22222222', 104),
('55555555', 'Jorge Díaz', '33333333', 105),
('66666666', 'Lucía Martín', '22222222', 106),
('77777777', 'Marta López', '44444444', 107),
('88888888', 'Pedro Sánchez', '55555555', 108),
('99999999', 'Raquel Morales', '66666666', 109);

