package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio03 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce un número ");
	
		
		if (scanner.hasNextInt()) {
			int numero = scanner.nextInt();
			if (esPrimo(numero)) {
				System.out.println("El  número es primo. ");
			} else {
				System.out.println("El número no es  primo. ");
			}
	
			scanner.close();
			}
			}
		
		
	public static boolean esPrimo(int numero) {
		
	if (numero < 2) {
		return false;
	}
	for (int i = 2; i <= Math.sqrt(numero); i++) {
		if (numero % i == 0) {
		return false;
		
	}
		}
		return true;
	}

}
