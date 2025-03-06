package UD06MetodosyArrays.UD_06_Teoria;

import java.util.Random;
import java.util.Scanner;

public class ejercicio11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la dimensión de los arrays: ");
		Random scanner;
		int dimension = sc.nextInt();

		
		int[] array1 = rellenarArray1[dimension]; // array1 se rellena de randoms con el método

//		array1 = rellenarArray1(dimension);

		int[] array2 = new int[dimension];
		
		
		
		int multiplicado[] = new int[dimension];

//		Imprimir los arrays
		System.out.println();
	}

	}

	public static int[] x(int tamany) {

		Random aleatorio = new Random();
		int[] arrayPrimero;

		for (int i = 0; i < tamany; i++) {

			arrayPrimero[i] = aleatorio.nextInt(0, 11);
		}
		// arrayPrimero = {8,5,3}

		return arrayPrimero;
	}

	public static int[] rellenarNumeros(int[] array1, int[] array2) {

		Random aleatorio = new Random();
		int[] arraySegundo;
		for (int i = 0; i < array1.length; i++) {
			array2[i] = aleatorio.nextInt(0, 11);

		}

		return arraySegundo;
	}

	public static int[] multiplicarArrays(int[] array1, int[] array2) {

		int[] resultado = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			resultado[i] = array1[i] * array2[i];
		}
		return resultado;
	}

}}