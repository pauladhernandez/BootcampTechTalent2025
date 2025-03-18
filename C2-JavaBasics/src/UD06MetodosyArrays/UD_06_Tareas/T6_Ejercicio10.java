package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;
import java.util.Random;

public class T6_Ejercicio10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Solicitar datos al usuario
		System.out.print("Introduce el tamaño del array: ");
		int tamaño = scanner.nextInt();

		System.out.print("Introduce el valor mínimo: ");
		int min = scanner.nextInt();

		System.out.print("Introduce el valor máximo: ");
		int max = scanner.nextInt();

		// Llamamos al método para generar el array y obtener el mayor primo
		int[] primosArray = generarArrayPrimos(tamaño, min, max);
		int mayorPrimo = encontrarMayorPrimo(primosArray);

		// Mostrar el array
		System.out.print("Array de números primos: ");
		for (int num : primosArray) {
			System.out.print(num + " ");
		}

		// Mostrar el mayor número primo encontrado
		System.out.println("\nEl mayor número primo es: " + mayorPrimo);

		scanner.close();
	}

	// Método para generar un array de números primos aleatorios
	public static int[] generarArrayPrimos(int tamaño, int min, int max) {
		Random rand = new Random();
		int[] primosArray = new int[tamaño];

		for (int i = 0; i < tamaño; i++) {
			int numero;
			do {
				numero = rand.nextInt(max - min + 1) + min;
			} while (!esPrimo(numero));

			primosArray[i] = numero;
		}

		return primosArray;
	}

	// Método para encontrar el mayor número primo en el array
	public static int encontrarMayorPrimo(int[] array) {
		int mayorPrimo = Integer.MIN_VALUE;
		for (int num : array) {
			if (num > mayorPrimo) {
				mayorPrimo = num;
			}
		}
		return mayorPrimo;
	}

	// Método para comprobar si un número es primo
	public static boolean esPrimo(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
