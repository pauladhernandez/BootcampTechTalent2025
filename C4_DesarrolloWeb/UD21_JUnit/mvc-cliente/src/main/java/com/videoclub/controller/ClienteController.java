package com.videoclub.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.videoclub.model.Cliente;
import com.videoclub.model.ClienteDAO;
import com.videoclub.viewç.ClienteView;

public class ClienteController {
    private ClienteView vista;
    private ClienteDAO dao;

    public ClienteController(ClienteView vista) {
        this.vista = vista;
        this.dao = new ClienteDAO();

        // Asociar eventos
        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        this.vista.getBtnMostrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarClientes();
            }
        });

        this.vista.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCliente();
            }
        });

        this.vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
            }
        });
    }

    private void agregarCliente() {
        String nombre = vista.getNombre();
        String direccion = vista.getDireccion();
        String dni = vista.getDni();

        if (nombre.isEmpty() || direccion.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
            return;
        }

        Cliente c = new Cliente(nombre, direccion, dni);
        dao.insertarCliente(c);
        vista.mostrarResultado("✅ Cliente insertado correctamente");
        vista.limpiarCampos();
    }

    private void mostrarClientes() {
        ArrayList<Cliente> lista = dao.obtenerClientes();
        StringBuilder resultado = new StringBuilder();
        for (Cliente c : lista) {
            resultado.append("ID: ").append(c.getId())
                    .append(" | Nombre: ").append(c.getNombre())
                    .append(" | Dirección: ").append(c.getDireccion())
                    .append(" | DNI: ").append(c.getDni())
                    .append("\n");
        }

        if (lista.isEmpty()) {
            resultado.append("No hay clientes en la base de datos.");
        }

        vista.mostrarResultado(resultado.toString());
    }

    private void actualizarCliente() {
        try {
            int id = Integer.parseInt(vista.getId());
            String nombre = vista.getNombre();
            String direccion = vista.getDireccion();
            String dni = vista.getDni();

            Cliente c = new Cliente(id, nombre, direccion, dni);
            dao.actualizarCliente(c);
            vista.mostrarResultado("✅ Cliente actualizado correctamente");
            vista.limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
        }
    }

    private void eliminarCliente() {
        try {
            int id = Integer.parseInt(vista.getId());
            dao.eliminarCliente(id);
            vista.mostrarResultado("🗑️ Cliente eliminado correctamente");
            vista.limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido");
        }
    }
}
