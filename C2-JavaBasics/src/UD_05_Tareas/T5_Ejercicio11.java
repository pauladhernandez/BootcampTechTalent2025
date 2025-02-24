
package UD_05_Tareas;

import java.util.Scanner;

public class T5_Ejercicio11 {

	public static void main(String[] args) {

////		Crea una aplicación que nos pida un día de la semana y que nos diga si es un día laboral
//		o no. Usa un switch para ello.

		System.out.println("Ingrese un día de la semana: ");
		Scanner sc = new Scanner(System.in);
		String dia = sc.nextLine().toLowerCase();

//		System.out.println(dia);
		
		switch (dia) {
		
		case "lunes":
			System.out.println("Es un día laboral.");
		    break;
		case "martes":	
			System.out.println("Es un día laboral.");
            break;
		case "sabado":
            System.out.println("No es un día laboral.");
            break;
		default:
            System.out.println("Día no válido	.");
            break;
		}
		
//		switch (dia) {
//
//		case "sábado":
//			System.out.println("Es un día laboral.");
//
//		}
//		switch (dia) {
//		case "lunes":
//		case "martes":
//		case "miércoles":
//		case "jueves":
//		case "viernes":
//			System.out.println("Es un día laboral.");
//			break;
//		case "sábado":
//		case "domingo":
//			System.out.println("No es un día laboral.");
//			break;
//		default:
//			System.out.println("Día no válido.");
//			break;
//
//		}
	}

}
