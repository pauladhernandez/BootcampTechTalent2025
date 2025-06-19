package com.videoclub.model;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    // Parámetros de conexión
    private final String URL = "jdbc:mysql://localhost:3306/videoclub";
    private final String USER = "root";  // Cambia si tu usuario es otro
    private final String PASS = "";      // Pon aquí tu contraseña

    private Connection conexion;

    public ClienteDAO() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión establecida");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
    }

    // INSERT
    public void insertarCliente(Cliente c) {
        String sql = "INSERT INTO cliente (nombre, direccion, dni) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDireccion());
            stmt.setString(3, c.getDni());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }

    // SELECT (todos)
    public ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("dni")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener clientes: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public void actualizarCliente(Cliente c) {
        String sql = "UPDATE cliente SET nombre=?, direccion=?, dni=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDireccion());
            stmt.setString(3, c.getDni());
            stmt.setInt(4, c.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
}
