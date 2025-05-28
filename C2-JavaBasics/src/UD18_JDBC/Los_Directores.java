package UD18_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Los_Directores {
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/Los_Directores";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión establecida");

            // INSERT múltiples en despachos
            String insertDespacho = "INSERT INTO despachos (num, capacidad) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertDespacho)) {
                int[][] datosDespachos = {
//                    {101, 2}, {102, 3}, {103, 1}, {104, 4}, {105, 2},
//                    {106, 3}, {107, 2}, {108, 5}, {109, 3}, {110, 2}
                };
                for (int[] d : datosDespachos) {
                    stmt.setInt(1, d[0]);
                    stmt.setInt(2, d[1]);
                    stmt.executeUpdate();
                }
                System.out.println("Despachos insertados correctamente");
            }

            // INSERT múltiples en directores
            String insertDirector = "INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertDirector)) {
                Object[][] datosDirectores = {
                    {"11111111", "Carlos Pérez", null, 101},
                    {"12345678", "Sergio Ortega", "44444444", 110},
                    {"22222222", "Ana Gómez", "11111111", 102},
                    {"33333333", "Luis Torres", "11111111", 103},
                    {"44444444", "Elena Ruiz", "22222222", 104},
                    {"55555555", "Jorge Díaz", "33333333", 105},
                    {"66666666", "Lucía Martín", "22222222", 106},
                    {"77777777", "Marta López", "44444444", 107},
                    {"88888888", "Pedro Sánchez", "55555555", 108},
                    {"99999999", "Raquel Morales", "66666666", 109}
                };
                for (Object[] d : datosDirectores) {
                    stmt.setString(1, (String) d[0]);
                    stmt.setString(2, (String) d[1]);
                    if (d[2] != null) {
                        stmt.setString(3, (String) d[2]);
                    } else {
                        stmt.setNull(3, java.sql.Types.VARCHAR);
                    }
                    stmt.setInt(4, (int) d[3]);
                    stmt.executeUpdate();
                }
                System.out.println("Directores insertados correctamente");
            }

            // UPDATE de despacho de un director
            String updateDespacho = "UPDATE directores SET despacho = ? WHERE DNI = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateDespacho)) {
                stmt.setInt(1, 105);  // nuevo despacho
                stmt.setString(2, "12345678"); // DNI del director
                stmt.executeUpdate();
                System.out.println("Despacho del director actualizado correctamente");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}