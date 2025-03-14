package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio08 {

	public static void main(String[] args) {
		int[] array = new int[10]; // Crear un array de 10 posiciones
		
		rellenarArray(array); // Rellenar el array con valores desde el teclado
		mostrarArray(array); // Mostrar el índice y el valor correspondiente
	}

	// Método para rellenar el array
	public static void rellenarArray(int[] array) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduce el valor para el índice " + i + ": ");
			array[i] = scanner.nextInt();
		}
		scanner.close();
	}

	// Método para mostrar el índice y el valor
	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Índice: " + i + " | Valor: " + array[i]);
		}
	}
}
