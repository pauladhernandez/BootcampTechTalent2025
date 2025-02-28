package UD05FlujosDatos.UD_05_Tareas;

import java.util.Scanner;

public class T5_Ejercicio12 {

	public static void main(String[] args) {
	  
//		Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
//		se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá mas
//		la contraseña y mostrara un mensaje diciendo “Enhorabuena”. Piensa bien en la condición
//		de salida (3 intentos y si acierta sale, aun le queden intentos).
//		13)

		
		        String password = "paula"; // Contraseña correcta
		        int intentos = 3; // Número máximo de intentos
		        boolean correcto = false;

		        Scanner scanner = new Scanner(System.in);

		        while (intentos > 0) { // Mientras queden intentos
		            System.out.print("Introduce la contraseña: ");
		            String input = scanner.nextLine(); // Leer la contraseña del usuario

		            if (input.equals(password)) {
		                correcto = true;
		                break; // Sale del bucle si la contraseña es correcta
		            } else {
		                intentos--; // Restar intento
		                if (intentos > 0) {
		                    System.out.println("Contraseña incorrecta, te quedan " + intentos + " intentos.");
		                }
		            }
		        }

		        // Mensaje final después del bucle
		        if (correcto) {
		            System.out.println("Enhorabuena, contraseña correcta.");
		        } else {
		            System.out.println("Has agotado los intentos.");
		        }

		        scanner.close(); // Cerrar Scanner
		    }
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//			String password = "paula"; //Contraseña correcta
//          	int intentos = 3;
//          	boolean correcto = false;
//           
//           Scanner scanner = new Scanner(System.in);
//           	
//           	while (intentos > 0) {
//           		System.out.println("Introduce la contraseña: ");
//           		String input1 = scanner.nextLine(); 
//           		//Lee la contraseña introducida por el usuario
//           		
//               
//           	if (input1.equals(password)) {
//                   correcto = true;
//                   break;
//                   
//               } else {
//
//                  intentos--; //Resta un intento
//                  
//                  if (intentos > 0) {
//                	  System.out.println("Contraseña incorrecta, te quedan " + (intentos - 1) + " intentos.");
//                  
//               if (correcto) {
//            	   System.out.println("Enhorabuena");
//               } else {
//            	   System.out.println("Has agotado los intentos");
               

