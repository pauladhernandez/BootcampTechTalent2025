
CREATE TABLE `articulos` (
  `codart` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `fabricante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



INSERT INTO `articulos` (`codart`, `nombre`, `precio`, `fabricante`) VALUES
(101, 'Portátil HP 15\"', 750, 1),
(102, 'Monitor Dell 24\"', 180.5, 2),
(103, 'Teclado Mecánico Logitech', 99.99, 9),
(104, 'MacBook Air M2', 1200, 4),
(105, 'Ratón Inalámbrico Razer', 85.9, 10),
(106, 'Laptop Asus Zenbook', 920, 5),
(107, 'All-in-One Lenovo', 690, 3),
(108, 'SSD Samsung 1TB', 150, 8),
(109, 'Portátil Acer Aspire', 580, 6),
(110, 'Monitor MSI Curvo 27\"', 230, 7);


CREATE TABLE `fabricantes` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `fabricantes` (`codigo`, `nombre`) VALUES
(1, 'HP'),
(2, 'Dell'),
(3, 'Lenovo'),
(4, 'Apple'),
(5, 'Asus'),
(6, 'Acer'),
(7, 'MSI'),
(8, 'Samsung'),
(9, 'Logitech'),
(10, 'Razer');