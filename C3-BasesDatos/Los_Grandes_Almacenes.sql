
CREATE TABLE Cajeros (
  Codigo INT(11) NOT NULL,
  NomApels VARCHAR(255) NOT NULL,
  PRIMARY KEY (Codigo)
);

INSERT INTO Cajeros (Codigo, NomApels) VALUES
(1, 'Ana Gómez'),
(2, 'Luis Pérez'),
(3, 'María Torres'),
(4, 'Juan Rodríguez'),
(5, 'Lucía Martínez'),
(6, 'Carlos Sánchez'),
(7, 'Elena Ruiz'),
(8, 'David Romero'),
(9, 'Paula Navarro'),
(10, 'Sergio Morales');


CREATE TABLE Maquinas_Registradoras (
  Codigo INT(11) NOT NULL,
  Piso INT(11) NOT NULL,
  PRIMARY KEY (Codigo)
);

INSERT INTO Maquinas_Registradoras (Codigo, Piso) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5),
(10, 5);


CREATE TABLE Productos (
  Codigo INT(11) NOT NULL,
  Nombre VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Precio INT(11) NOT NULL,
  PRIMARY KEY (Codigo)
);

INSERT INTO Productos (Código, Nombre, Precio) VALUES
(1, 'Pan', 1000),
(2, 'Leche', 2500),
(3, 'Arroz', 3200),
(4, 'Café', 7800),
(5, 'Queso', 5400),
(6, 'Azúcar', 2100),
(7, 'Galletas', 3900),
(8, 'Cereal', 4600),
(9, 'Huevos', 5500),
(10, 'Aceite', 8800);


CREATE TABLE Venta (
  Cajero INT(11) NOT NULL,
  Maquina INT(11) NOT NULL,
  Producto INT(11) NOT NULL,
  PRIMARY KEY (Cajero, Maquina, Producto),
  FOREIGN KEY (Cajero) REFERENCES Cajeros(Codigo),
  FOREIGN KEY (Maquina) REFERENCES Maquinas_Registradoras(Codigo),
  FOREIGN KEY (Producto) REFERENCES Productos(Codigo)
);

INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10);