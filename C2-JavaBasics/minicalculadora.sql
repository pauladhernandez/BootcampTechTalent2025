

CREATE TABLE `historial` (
  `ID` int(11) NOT NULL,
  `Operador1` double NOT NULL,
  `Operador2` double NOT NULL,
  `Operacion` varchar(10) NOT NULL,
  `Resultado` double NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) 

