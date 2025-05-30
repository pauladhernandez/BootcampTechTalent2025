package VentanaGrafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Ejercicio3 {
	 private static int contador1 = 0;
	    private static int contador2 = 0;

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            // Crear la ventana
	            JFrame frame = new JFrame("Contador de Clics");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(400, 200);
	            frame.setResizable(false); // Permite cambiar tamaño
	            frame.setLayout(new GridLayout(2, 2, 10, 10));
	            frame.setLocationRelativeTo(null); // Centrar ventana

	            // Crear etiquetas
	            JLabel etiqueta1 = new JLabel("Botón 1 clics: 0");
	            JLabel etiqueta2 = new JLabel("Botón 2 clics: 0");

	            // Crear botones
	            JButton boton1 = new JButton("Botón 1");
	            JButton boton2 = new JButton("Botón 2");

	            // Acción botón 1
	            boton1.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    contador1++;
	                    etiqueta1.setText("Botón 1 clics: " + contador1);
	                }
	            });

	            // Acción botón 2
	            boton2.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    contador2++;
	                    etiqueta2.setText("Botón 2 clics: " + contador2);
	                }
	            });

	            // Añadir componentes a la ventana
	            frame.add(etiqueta1);
	            frame.add(etiqueta2);
	            frame.add(boton1);
	            frame.add(boton2);

	            // Mostrar la ventana
	            frame.setVisible(true);
	        });
	    
	    }
}

