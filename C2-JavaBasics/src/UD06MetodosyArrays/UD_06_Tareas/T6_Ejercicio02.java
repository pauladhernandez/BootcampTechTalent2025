package UD06MetodosyArrays.UD_06_Tareas;

import javax.swing.JOptionPane;

public class T6_Ejercicio02 {

	private static final JOptionPane JOPtionPane = null;

	public static void main(String[] args) {

//		Crea una aplicación que nos genere una cantidad de números enteros aleatorios que
//		nosotros le pasaremos por teclado. Crea un método donde pasamos como parámetros entre
//		que números queremos que los genere, podemos pedirlas por teclado antes de generar los
//		números. Este método devolverá un número entero aleatorio. Muestra estos números por
//		pantalla.
//		

		int cantRandoms = Integer
				.parseInt(JOptionPane.showInputDialog("Introduce " + "la cantidad de números aleatorios a generar "));

		int r1, r2;

		while (cantRandoms > 0) {

//			Pedir los rangos para generar los números aleatorios
			r1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer rango "));
			r2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo rango "));
			System.out.println(enteroRandom(r1, r2));
			cantRandoms--;

			// Cálculo del random
			JOptionPane.showMessageDialog(null, "El número aleatorio es: " + enteroRandom(r1, r2));
		}
	}

	public static int enteroRandom(int rango1, int rango2) {

//		Cálculo del random
		int resultado = (int) (Math.random() * (rango2 - rango1 + 1)) + rango1;
		return resultado;
	}
}
