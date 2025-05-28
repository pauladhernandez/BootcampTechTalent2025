package UD18_JDBC;


import java.sql.*;

public class Tienda_Info {
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/Tienda_Info";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos");

            // INSERT en la tabla fabricantes
            String insertFabricante = "INSERT INTO fabricantes (nombre) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertFabricante)) {
                stmt.setString(1, "Samsung");
                stmt.executeUpdate();
                stmt.setString(1, "Lenovo");
                stmt.executeUpdate();
                System.out.println("Fabricantes insertados correctamente");
            }

            // INSERT en la tabla articulos
            String insertArticulo = "INSERT INTO articulos (nombre, precio, fabricante) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertArticulo)) {
                stmt.setString(1, "Monitor 24 pulgadas");
                stmt.setFloat(2, 249.99f);
                stmt.setInt(3, 1); // Asegúrate que este fabricante existe
                stmt.executeUpdate();

                stmt.setString(1, "Teclado Mecánico");
                stmt.setFloat(2, 89.99f);
                stmt.setInt(3, 2); // Asegúrate que este fabricante existe
                stmt.executeUpdate();
                System.out.println("Artículos insertados correctamente");
            }

            // UPDATE en la tabla articulos
            String updateArticulo = "UPDATE articulos SET precio = ? WHERE nombre = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateArticulo)) {
                stmt.setFloat(1, 79.99f);
                stmt.setString(2, "Teclado Mecánico");
                stmt.executeUpdate();
                System.out.println("Artículo actualizado correctamente");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}