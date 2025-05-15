

CREATE TABLE `piezas` (
  `idpiez` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL) 


CREATE TABLE `proveedores` (
  `idprov` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL) 


CREATE TABLE `suministra` (
  `idpiez` int(11) NOT NULL,
  `idprov` int(11) NOT NULL,
  `precio` float NOT NULL)

INSERT INTO piezas (idpiez, nombre) VALUES
(1, 'Tornillo'),
(2, 'Tuerca'),
(3, 'Engranaje'),
(4, 'Eje'),
(5, 'Rodamiento'),
(6, 'Chapa metálica'),
(7, 'Arandela'),
(8, 'Cable de cobre'),
(9, 'Placa base'),
(10, 'Motor eléctrico');

INSERT INTO proveedores (idprov, nombre) VALUES
(1, 'Proveedor A'),
(2, 'Proveedor B'),
(3, 'Proveedor C'),
(4, 'Proveedor D'),
(5, 'Proveedor E'),
(6, 'Proveedor F'),
(7, 'Proveedor G'),
(8, 'Proveedor H'),
(9, 'Proveedor I'),
(10, 'Proveedor J');

INSERT INTO suministra (idpiez, idprov, precio) VALUES
(1, 1, 0.15),
(2, 2, 0.10),
(3, 3, 1.25),
(4, 4, 0.80),
(5, 5, 2.00),
(6, 6, 1.10),
(7, 7, 0.05),
(8, 8, 0.70),
(9, 9, 3.50),
(10, 10, 5.00);


