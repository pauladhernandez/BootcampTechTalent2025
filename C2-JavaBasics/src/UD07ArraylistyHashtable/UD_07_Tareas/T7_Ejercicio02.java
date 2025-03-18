package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.ArrayList;
import java.util.Scanner;

public class T7_Ejercicio02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Lista para almacenar las cantidades de los productos
		ArrayList<Double> carrito = new ArrayList<>();

		// Introducir los artículos en el carrito
		System.out.print("Ingrese el número de artículos en el carrito: ");
		int numArticulos = scanner.nextInt();

		// Añadir cada artículo al carrito
		for (int i = 0; i < numArticulos; i++) {
			System.out.print("Ingrese el precio del artículo " + (i + 1) + ": ");
			double precio = scanner.nextDouble();
			carrito.add(precio);
		}

		// Calcular el precio total bruto
		double precioTotalBruto = 0.0;
		for (double precio : carrito) {
			precioTotalBruto += precio;
		}
		System.out.println("Introduce tipo iva(21% o 4%): ");
		double Iva = scanner.nextDouble();
		// El IVA aplicado es el 21%.
		double iva1 = 0.21;
		double iva2 = 0.04;
		double precioConIva;
		
		if (Iva == 21) {
		    precioConIva = precioTotalBruto * (1 + iva1);
		    System.out.println("IVA aplicado: " + (iva1 * 100) + "%");
		} else if (Iva == 4) {
		    precioConIva = precioTotalBruto * (1 + iva2);
		    System.out.println("IVA aplicado: " + (iva2 * 100) + "%");
		} else {
		    System.out.println("Tipo de IVA no válido. Se aplicará el IVA del 21% por defecto.");
		    precioConIva = precioTotalBruto * (1 + iva1);
		    System.out.println("IVA aplicado: " + (iva1 * 100) + "%");
		}
	

		// Mostrar los resultado
		System.out.println("Número de artículos comprados: " + numArticulos);
		System.out.println("Precio total bruto: " + precioTotalBruto + " €");
		System.out.println("Precio total con IVA: " + precioConIva + " €");

		// Cantidad pagada por el cliente
		System.out.print("Ingrese la cantidad pagada por el cliente: ");
		double cantidadPagada = scanner.nextDouble();

		// Calcular el cambio a devolver
		double cambio = cantidadPagada - precioConIva;

		// Verificar si el cliente ha pagado suficiente
		if (cambio < 0) {
			System.out.println("El cliente no ha pagado suficiente. Faltan " + (-cambio) + " €.");
		} else {
			System.out.println("Cambio a devolver: " + cambio + " €");
		}

		scanner.close();
	}
}
