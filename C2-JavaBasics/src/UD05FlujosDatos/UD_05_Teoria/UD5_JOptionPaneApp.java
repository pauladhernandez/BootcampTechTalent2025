package UD05FlujosDatos.UD_05_Teoria;

import javax.swing.JOptionPane;

public class UD5_JOptionPaneApp {

	public static void main(String[] args) {

		int precioProducto = 300;
		final double IVA = 0.21;

//		OUTPUT Gráfico
		JOptionPane.showMessageDialog(null,
						"El precio del producto, incluido el IVA es " + 
						(precioProducto + (precioProducto * IVA)));
//		Equivalente para la CONSOLA
//		System.out.println("El precio del producto, incluido el IVA es " + 
//						(precioProducto + (precioProducto * IVA)));

	}

}