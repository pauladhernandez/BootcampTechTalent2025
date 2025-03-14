package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;

		// Validación para que el número sea positivo
		do {
			System.out.print("Ingrese un número entero positivo: ");
			numero = scanner.nextInt();
			if (numero <= 0) { //El do while pedirá las veces 
									//que sea necesario hasta que reciba un número positivo
				System.out.println("Por favor, ingrese un número positivo.");
			}
		} while (numero <= 0);

		scanner.close();

		int cifras = contarCifras(numero);
		System.out.println("El número tiene " + cifras + " cifras.");
	}

	
	public static int contarCifras(int numero) {
		int contador = 0;

		if (numero == 0) {
			return 1;
		}
//Este método cuenta las cifras 
		while (numero > 0) {
			numero /= 10;
			contador++;
		}

		return contador;
	}

}
