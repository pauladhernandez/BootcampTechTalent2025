package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class T7_Ejercicio03 {

	private static HashMap<String, Double> stockProductos = new HashMap<>();

	public static void main(String[] args) {

		// Diccionario de artículos con sus precios
		Map<String, Double> stockProductos = new HashMap<>();

		// Llenamos el diccionario con 10 artículos iniciales
		stockProductos.put("Leche", 1.20);
		stockProductos.put("Pan", 0.90);
		stockProductos.put("Arroz", 2.50);
		stockProductos.put("Azúcar", 1.80);
		stockProductos.put("Cereal", 3.00);
		stockProductos.put("Jabón", 2.20);
		stockProductos.put("Aceite", 4.50);
		stockProductos.put("Tomates", 2.00);
		stockProductos.put("Manzanas", 1.50);
		stockProductos.put("Café", 5.00);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Gestión de Stock de Productos ---");
			System.out.println("1. Añadir artículo");
			System.out.println("2. Consultar artículo");
			System.out.println("3. Listar todos los artículos");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 1:
				añadirArticulo(scanner);
				break;
			case 2:
				consultarArticulo(scanner);
				break;
			case 3:
				listarArticulos();
				break;
			case 4:
				System.out.println("Saliendo del programa...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opción no válida. Inténtelo nuevamente.");
			}
		}
	}

	// Método para añadir un artículo al diccionario
	private static void añadirArticulo(Scanner scanner) {
		System.out.print("Ingrese el nombre del artículo: ");
		String articulo = scanner.nextLine();

		System.out.print("Ingrese el precio del artículo: ");
		double precio = scanner.nextDouble();
		scanner.nextLine(); // Limpiar el buffer

		// Añadir el artículo al diccionario
		stockProductos.put(articulo, (double) precio);
		System.out.println("Artículo '" + articulo + "' añadido con éxito.");
	}

	// Método para consultar el precio de un artículo
	private static void consultarArticulo(Scanner scanner) {
		System.out.print("Ingrese el nombre del artículo a consultar: ");
		String articulo = scanner.nextLine();

		// Verificar si el artículo está en el diccionario
		if (stockProductos.containsKey(articulo)) {
			double precio = stockProductos.get(articulo);
			System.out.println("El precio de " + articulo + " es: " + precio + " €.");
		} else {
			System.out.println("El artículo '" + articulo + "' no se encuentra en el stock.");
		}
	}

	// Método para listar todos los artículos en el stock
	private static void listarArticulos() {
		if (stockProductos.isEmpty()) {
			System.out.println("No hay artículos en el stock.");
		} else {
			System.out.println("\nListado de artículos en el stock:");
			for (Entry<String, Double> entry : stockProductos.entrySet()) {
				System.out.println("Artículo: " + entry.getKey() + " - Precio: " + entry.getValue() + " €");
			}
		}
	}
}
