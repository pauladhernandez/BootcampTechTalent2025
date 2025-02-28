package UD06MetodosyArrays.UD_06_Tareas;

import javax.swing.JOptionPane;

public class T6_Ejercicio1 {

	public static void main(String[] args) {
		// Variables
		int radio = 0;
		int base = 0;
		int altura = 0;
		String figura = "";
		String mensaje = "";
		// Inputs de usuario
		figura = JOptionPane
				.showInputDialog("Introduce la figura a calcular " + "el área (círculo, triángulo, cuadrado):")
				.toLowerCase();

		switch (figura) {
			case "circulo":
				radio = Integer
						.parseInt(JOptionPane.showInputDialog("Introduce el radio del círculo:"));
				mensaje = "El area del circulo es " + CalularAreaCirculo(radio);
				break;
			case "triangulo":
				base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base del triángulo:"));
				altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura del triángulo:"));
				mensaje = "El area del triángulo es " + CalularAreaTriangulo(base, altura);
				break;
			case "cuadrado":
				base = Integer.parseInt(JOptionPane.showInputDialog("Introduce un lado del cuadrado:"));
				mensaje = "El area del cuadrado es " + CalularAreaCuadrado(base);
			    break;
			   default:
				   mensaje = "La figura no es válida";
			
		}

		System.out.println(mensaje);

	
	}

	public static double CalularAreaCirculo(int radio) {
		return Math.PI * Math.pow(radio, 2);

	}

	public static double CalularAreaTriangulo(int base, int altura) {
		return base * altura / 2;

	}

	public static double CalularAreaCuadrado(int base) {
		return base * base;

	}

}
