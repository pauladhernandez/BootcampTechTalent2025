package VentanaGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;

public class Ejercicio1 {
	

	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            JFrame frame = new JFrame("Mi Ventana Gráfica");
//	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Salir al cerrar
	            frame.setSize(400, 300); // Tamaño inicial
//	            frame.setResizable(true); // Permite cambiar tamaño
	            frame.setLocationRelativeTo(null); // Centrar ventana

	            JLabel etiqueta = new JLabel("Hola, esta es una etiqueta", JLabel.CENTER);
	            frame.add(etiqueta);

	            frame.setVisible(true);
	        });
	    }
	}

