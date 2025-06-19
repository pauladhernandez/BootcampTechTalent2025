package com.videoclub.viewç;

import com.videoclub.controller.ClienteController;

import javax.swing.*;
import java.awt.*;

public class ClienteView extends JFrame {
    // Componentes
    private JTextField txtId, txtNombre, txtDireccion, txtDni;
    private JTextArea textArea;
    private JButton btnAgregar, btnMostrar, btnActualizar, btnEliminar;

    // Controlador
    private ClienteController controller;

    public ClienteView() {
        // Ventana
        setTitle("Gestión de Clientes - Videoclub");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(8, 2));
        
        // Campos
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        panel.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panel.add(txtDni);

        // Botones
        btnAgregar = new JButton("Añadir Cliente");
        panel.add(btnAgregar);
        btnMostrar = new JButton("Mostrar Clientes");
        panel.add(btnMostrar);
        btnActualizar = new JButton("Actualizar Cliente");
        panel.add(btnActualizar);
        btnEliminar = new JButton("Eliminar Cliente");
        panel.add(btnEliminar);

        // Área de resultados
        panel.add(new JLabel("Resultado:"));
        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        add(panel);

        // Crear controlador
        controller = new ClienteController(this);

        // Mostrar ventana
        setVisible(true);
    }

    // Getters de campos y botones
    public String getId() { return txtId.getText(); }
    public String getNombre() { return txtNombre.getText(); }
    public String getDireccion() { return txtDireccion.getText(); }
    public String getDni() { return txtDni.getText(); }

    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnMostrar() { return btnMostrar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }

    public void mostrarResultado(String texto) {
        textArea.setText(texto);
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtDni.setText("");
    }
}