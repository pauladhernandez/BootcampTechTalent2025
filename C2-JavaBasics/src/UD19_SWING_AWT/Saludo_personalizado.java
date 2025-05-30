package UD19_SWING_AWT;

import javax.swing.*;
import java.awt.event.*;


public class Saludo_personalizado extends JFrame {

	private JTextField textField;
	
	public Saludo_personalizado() {
		
		setTitle("Saludo Personalizable");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
JPanel panel = new JPanel();
        
        // Crear un campo de texto
        textField = new JTextField(20);
        panel.add(textField);
        
        // Crear un botón
        JButton botonSaludar = new JButton("Saludar");
        // Agregar ActionListener al botón
        botonSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de texto
                String nombre = textField.getText();
                // Mostrar un mensaje en un JOptionPane
                JOptionPane.showMessageDialog(Saludo_personalizado
                		.this, "¡Hola " + nombre + "!");
            }
        });
        panel.add(botonSaludar);
        
        // Agregar el panel a la ventana
        add(panel);
    }
    
    public static void main(String[] args) {
        // Crear una instancia de la ventana
       Saludo_personalizado ventana = new Saludo_personalizado();
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}