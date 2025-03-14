package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio07 {

	public static void main(String[] args) {
	
	        Scanner scanner = new Scanner(System.in);
	        
	        // Solicitar cantidad en euros
	        System.out.print("Ingrese la cantidad de euros: ");
	        double euros = scanner.nextDouble();
	        
	        // Solicitar la moneda de destino
	        System.out.print("Ingrese la moneda a la que desea convertir (Dólares, Yenes o Libras): ");
	        String moneda = scanner.next().toLowerCase();
	        
	        scanner.close();
	        
	        // Llamar al método de conversión
	        convertirDivisa(euros, moneda);
	}

	public static void convertirDivisa(double euros, String moneda) {
		double resultado;

		switch (moneda) {
		case "dolares":
			resultado = euros * 1.28611; 
			System.out.println(euros + " euros son " + resultado + " dólares.");
			break;
		case "yenes":
			resultado = euros * 129.852; 
			System.out.println(euros + " euros son " + resultado + " yenes.");
			break;
		case "libras":
			resultado = euros * 0.86; 
			System.out.println(euros + " euros son " + resultado + " libras.");
			break;
		default:
			System.out.println("Moneda no válida. Las divisas son: dólares, yenes o libras.");
		}

	}

}
