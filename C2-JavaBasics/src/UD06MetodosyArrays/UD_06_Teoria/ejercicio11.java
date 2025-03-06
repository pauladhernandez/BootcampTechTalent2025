package UD06MetodosyArrays.UD_06_Teoria;

import java.util.Random;
import java.util.Scanner;


public class ejercicio11 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce la dimensión de los arrays: ");
		Random scanner; //preguntar
		int dimension = scanner.nextInt();
		
		 // preguntar
		
		int[] array1 = new int[dimension];
		// array1 se rellena de randoms con el método
		array1 = rellenarArray1(dimension);
		
		
		
		int[] array2 = new int[dimension];
		int multiplicado[] = new int[dimension];
		
		
//		for (int i = 0; i < dimension; i++) { //preguntar
//			int[] array;
//			Random rand;
//			array[i] = rand.nextInt(10) + 1;
//		}
	
		array2 = array1;
		
		for (int i = 0; i < dimension; i++) { // preguntar
			Random rand;
			array2[i] = rand.nextInt(10) + 1;
		}

	
	}
	
	public static int[] rellenarArray1(int tamany) {
		
		Random aleatorio = new Random();
		int[] arrayPrimero;
		
		for (int i = 0; i < tamany; i++) { //preguntar
			
			arrayPrimero[i] = aleatorio.nextInt(0,11);
		}
		//arrayPrimero = {8,5,3}
		
		return arrayPrimero;
	}

	public static void rellenarNumeros (int array1, int [] array2) {
	}
	
}
}