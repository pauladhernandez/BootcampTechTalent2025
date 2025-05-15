CREATE DATABASE ACADEMIA_IDIOMAS;

CREATE TABLE Profesores
    (DNI_Profesor CHAR(9),
    Nombre VARCHAR(20),
    Apellido1 VARCHAR(255),
    Apellido2 VARCHAR(255),
    Dirección VARCHAR(50),
    Título VARCHAR(255),
    Gana DECIMAL(10,2) NOT NULL,
    UNIQUE (Nombre, Apellido1, Apellido2),
    PRIMARY KEY (DNI_Profesor));

CREATE TABLE Cursos
	(Cod_Curso INT,
    Nombre_Curso VARCHAR(100),
     DNI_Profesor VARCHAR(9),
     Max_Alumnos INT,
     Fecha_Inicio DATE,
     Fecha_Fin DATE,
     Num_Horas INT NOT NULL,
     PRIMARY KEY (Cod_Curso),
     FOREIGN KEY (DNI_Profesor)
     REFERENCES Profesores (DNI_Profesor)
     ON DELETE SET NULL
    ON UPDATE CASCADE,
  CHECK (FECHA_INICIO <= FECHA_FIN));

CREATE TABLE Alumnos
    (DNI CHAR(9),
    Nombre VARCHAR(20) NOT NULL,
    Apellido1 VARCHAR(255) NOT NULL,    
    Apellido2 VARCHAR(255) NOT NULL,
    Dirección VARCHAR(50),
    Sexo CHAR(1) CHECK (Sexo IN ('H','M')),
    Fecha_Nacimiento DATE,
    Cursos INT NOT NULL,
    PRIMARY KEY (DNI),
    FOREIGN KEY (Cursos)
    REFERENCES Cursos (Cod_Curso)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
