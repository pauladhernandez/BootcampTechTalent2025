package UD05FlujosDatos.UD_05_Teoria;

import java.util.Scanner;

public class ejemplo {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);
		        
		        System.out.print("Ingrese el número de ventas: ");
		        int numVentas = scanner.nextInt();
		        double total = 0;

		        for (int i = 1; i <= numVentas; i++) {
		            System.out.print("Ingrese el monto de la venta " + i + ": ");
		            total += scanner.nextDouble();
		        }

		        System.out.printf("El total de las ventas es: %.2f\n", total);
		        scanner.close();
		    }
		}

