package UD19_SWING_AWT;

import javax.swing.*;

public class Saludo_personalizado extends JFrame {

	private JPanel contentPane;
	public Saludo_personalizado() {
		
		setTitle("Título de la ventana");
		
		setBounds(100, 100, 450, 300);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JLabel etiqueta = new JLabel("Hola Mundo");
		etiqueta.setBounds(10, 11, 414, 14);
		contentPane.add(etiqueta);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 36, 414, 20);
		contentPane.add(textField);
		
		JButton btnPulsame = new JButton("Púlsame");
		btnPulsame.setBounds(10, 67, 414, 23);
		contentPane.add(btnPulsame);
	}
	
	public static void main(String[]args) {
		Saludo_personalizado ventana = new Saludo_personalizado();
		
		
	}
	
	
}
