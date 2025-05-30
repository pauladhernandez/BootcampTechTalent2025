package VentanaGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ejercicio8 {



	
		    private static int contador1 = 0;
		    private static int contador2 = 0;

		    public static void main(String[] args) {
		        SwingUtilities.invokeLater(() -> {
		            JFrame frame = new JFrame("Contador de Clics Mejorado");
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame.setSize(500, 250);
		            frame.setLayout(new GridLayout(3, 2, 10, 10));
		            frame.setLocationRelativeTo(null); // Centrar

		            // Etiquetas
		            JLabel etiqueta1 = new JLabel("Botón 1 clics: 0");
		            JLabel etiqueta2 = new JLabel("Botón 2 clics: 0");

		            // Botones
		            JButton boton1 = new JButton("Botón 1 ");
		            JButton boton2 = new JButton("Botón 2 ");
		            JButton botonReset = new JButton("Resetear");

		            // Campo de entrada simulada (para control de errores)
		            JTextField campoEntrada = new JTextField();
		            campoEntrada.setToolTipText("Introduce un número (solo para demostrar manejo de errores)");

		            // Acción para el botón 1
		            ActionListener accionBoton1 = e -> {
		                contador1++;
		                etiqueta1.setText("Botón 1 clics: " + contador1);
		            };

		            // Acción para el botón 2
		            ActionListener accionBoton2 = e -> {
		                contador2++;
		                etiqueta2.setText("Botón 2 clics: " + contador2);
		            };

		            // Acción para el botón reset
		            ActionListener accionReset = e -> {
		                contador1 = 0;
		                contador2 = 0;
		                etiqueta1.setText("Botón 1 clics: 0");
		                etiqueta2.setText("Botón 2 clics: 0");
		                campoEntrada.setText("");
		            };

		            // Control de errores al presionar Enter en el campo de entrada
		            campoEntrada.addActionListener(e -> {
		                try {
		                    int numero = Integer.parseInt(campoEntrada.getText());
		                    JOptionPane.showMessageDialog(frame, "Número válido: " + numero, "Correcto", JOptionPane.INFORMATION_MESSAGE);
		                } catch (NumberFormatException ex) {
		                    JOptionPane.showMessageDialog(frame, "Error: debes introducir un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		                }
		            });

		            // Añadir acciones a los botones
		            boton1.addActionListener(accionBoton1);
		            boton2.addActionListener(accionBoton2);
		            botonReset.addActionListener(accionReset);

		            // Asignar atajos de teclado (A = botón 1, B = botón 2, R = reset)
		            InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		            ActionMap actionMap = frame.getRootPane().getActionMap();

		            inputMap.put(KeyStroke.getKeyStroke('A'), "boton1");
		            inputMap.put(KeyStroke.getKeyStroke('B'), "boton2");
		            inputMap.put(KeyStroke.getKeyStroke('R'), "reset");

		            actionMap.put("boton1", new AbstractAction() {
		                public void actionPerformed(ActionEvent e) {
		                    accionBoton1.actionPerformed(e);
		                }
		            });
		            actionMap.put("boton2", new AbstractAction() {
		                public void actionPerformed(ActionEvent e) {
		                    accionBoton2.actionPerformed(e);
		                }
		            });
		            actionMap.put("reset", new AbstractAction() {
		                public void actionPerformed(ActionEvent e) {
		                    accionReset.actionPerformed(e);
		                }
		            });

		            // Añadir componentes
		            frame.add(etiqueta1);
		            frame.add(etiqueta2);
		            frame.add(boton1);
		            frame.add(boton2);
		            frame.add(campoEntrada);
		            frame.add(botonReset);

		            frame.setVisible(true);
		        });
		    }
		}


