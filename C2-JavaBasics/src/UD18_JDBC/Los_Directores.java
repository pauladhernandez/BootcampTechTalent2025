package UD18_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Los_Directores {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Los_Directores";
        String user = "root";
        String password = ""; // Cambia si tu MySQL tiene contraseña

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión establecida con la base de datos: " + conn.getCatalog());

            Statement stmt = conn.createStatement();

            // Eliminar las tablas si existen (orden correcto por relaciones)
            stmt.executeUpdate("DROP TABLE IF EXISTS directores");
            stmt.executeUpdate("DROP TABLE IF EXISTS despachos");

            // Crear tabla despachos
            stmt.executeUpdate(
                "CREATE TABLE despachos (" +
                "num INT(11) NOT NULL PRIMARY KEY," +
                "capacidad INT(11) NOT NULL" +
                ") ENGINE=InnoDB");

            // Crear tabla directores
            stmt.executeUpdate(
                "CREATE TABLE directores (" +
                "DNI VARCHAR(9) NOT NULL PRIMARY KEY," +
                "NomApels VARCHAR(255)," +
                "DNIJefe VARCHAR(9)," +
                "despacho INT(11) NOT NULL," +
                "FOREIGN KEY (DNIJefe) REFERENCES directores(DNI) ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY (despacho) REFERENCES despachos(num) ON DELETE CASCADE ON UPDATE CASCADE" +
                ") ENGINE=InnoDB");

            System.out.println("Tablas creadas correctamente");

            // Insertar despachos
            String insertDespacho = "INSERT INTO despachos (num, capacidad) VALUES (?, ?)";
            try (PreparedStatement psDespacho = conn.prepareStatement(insertDespacho)) {
                int[][] despachos = {
                    {101, 2}, {102, 3}, {103, 1}, {104, 4}, {105, 2},
                    {106, 3}, {107, 2}, {108, 5}, {109, 3}, {110, 2}
                };
                for (int[] d : despachos) {
                    psDespacho.setInt(1, d[0]);
                    psDespacho.setInt(2, d[1]);
                    psDespacho.executeUpdate();
                }
                System.out.println("Despachos insertados correctamente");
            }

            // Insertar directores en orden jerárquico correcto
            String insertDirector = "INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psDirector = conn.prepareStatement(insertDirector)) {
                String[][] directores = {
                    {"11111111", "Carlos Pérez", null, "101"},
                    {"22222222", "Ana Gómez", "11111111", "102"},
                    {"33333333", "Luis Torres", "11111111", "103"},
                    {"44444444", "Elena Ruiz", "22222222", "104"},
                    {"66666666", "Lucía Martín", "22222222", "106"},
                    {"55555555", "Jorge Díaz", "33333333", "105"},
                    {"77777777", "Marta López", "44444444", "107"},
                    {"88888888", "Pedro Sánchez", "55555555", "108"},
                    {"99999999", "Raquel Morales", "66666666", "109"},
                    {"12345678", "Sergio Ortega", "44444444", "110"}
                };
                for (String[] d : directores) {
                    psDirector.setString(1, d[0]); // DNI
                    psDirector.setString(2, d[1]); // Nombre
                    if (d[2] != null) {
                        psDirector.setString(3, d[2]); // DNIJefe
                    } else {
                        psDirector.setNull(3, java.sql.Types.VARCHAR);
                    }
                    psDirector.setInt(4, Integer.parseInt(d[3])); // despacho
                    psDirector.executeUpdate();
                }
                System.out.println("Directores insertados correctamente");
            }
            
         // Actualizar capacidad de un despacho
            String updateDespacho = "UPDATE despachos SET capacidad = ? WHERE num = ?";
            try (PreparedStatement psUpdateDespacho = conn.prepareStatement(updateDespacho)) {
                psUpdateDespacho.setInt(1, 6); // Nueva capacidad
                psUpdateDespacho.setInt(2, 108); // Número de despacho a actualizar
                int filas = psUpdateDespacho.executeUpdate();
                System.out.println("Despacho actualizado. Filas afectadas: " + filas);
            }

            // Cambiar el jefe de un director
            String updateDirectorJefe = "UPDATE directores SET DNIJefe = ? WHERE DNI = ?";
            try (PreparedStatement psUpdateDirector = conn.prepareStatement(updateDirectorJefe)) {
                psUpdateDirector.setString(1, "11111111"); // Nuevo jefe
                psUpdateDirector.setString(2, "12345678"); // Director a modificar
                int filas = psUpdateDirector.executeUpdate();
                System.out.println("Jefe actualizado. Filas afectadas: " + filas);
            }

            // Cambiar nombre y despacho de un director
            String updateDirectorInfo = "UPDATE directores SET NomApels = ?, despacho = ? WHERE DNI = ?";
            try (PreparedStatement psUpdateInfo = conn.prepareStatement(updateDirectorInfo)) {
                psUpdateInfo.setString(1, "Andrés Cuervo"); // Nuevo nombre
                psUpdateInfo.setInt(2, 103); // Nuevo despacho
                psUpdateInfo.setString(3, "12345678"); // Director a modificar
                int filas = psUpdateInfo.executeUpdate();
                System.out.println("Datos del director actualizados. Filas afectadas: " + filas);
            }


        } catch (SQLException e) {
            System.out.println("Error al conectar o ejecutar SQL:");
            e.printStackTrace();
        }
    }
}

