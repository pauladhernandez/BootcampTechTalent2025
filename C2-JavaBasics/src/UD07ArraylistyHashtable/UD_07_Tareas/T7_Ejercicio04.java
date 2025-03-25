package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.*;

public class T7_Ejercicio04 {

	private static Map<String, Double> inventario = new HashMap<>();
	private static Map<String, Integer> stock = new HashMap<>();
	private static List<String> carrito = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		inicializarInventario();
		boolean ejecutando = true;

		while (ejecutando) {
			System.out.println("\n1. Agregar producto al carrito");
			System.out.println("2. Ver carrito y finalizar compra");
			System.out.println("3. Administrar stock");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				agregarAlCarrito();
				break;
			case 2:
				finalizarCompra();
				break;
			case 3:
				administrarStock();
				break;
			case 4:
				ejecutando = false;
				break;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	private static void inicializarInventario() {
		inventario.put("Leche", 1.50);
		stock.put("Leche", 10);
		inventario.put("Pan", 1.00);
		stock.put("Pan", 15);
		inventario.put("Huevos", 2.50);
		stock.put("Huevos", 8);
		inventario.put("Arroz", 3.00);
		stock.put("Arroz", 12);
	}

	private static void agregarAlCarrito() {
		System.out.println("Productos disponibles:");
		for (String producto : inventario.keySet()) {
			System.out
					.println(producto + " - Precio: " + inventario.get(producto) + "€ - Stock: " + stock.get(producto));
		}

		System.out.print("Ingrese el nombre del producto: ");
		String producto = scanner.nextLine();
		if (inventario.containsKey(producto) && stock.get(producto) > 0) {
			carrito.add(producto);
			stock.put(producto, stock.get(producto) - 1);
			System.out.println("Producto agregado al carrito.");
		} else {
			System.out.println("Producto no disponible o sin stock.");
		}
	}

	private static void finalizarCompra() {
		if (carrito.isEmpty()) {
			System.out.println("El carrito está vacío.");
			return;
		}
		double total = 0;
		for (String item : carrito) {
			total += inventario.get(item);
		}
		System.out.println("Seleccione el IVA a aplicar:");
        System.out.println("1. 21%");
        System.out.println("2. 4%");
        System.out.print("Opción: ");
        int opcionIVA = scanner.nextInt();
        scanner.nextLine(); 
        
        double tasaIVA = (opcionIVA == 2) ? 0.04 : 0.21;
        double iva = total * tasaIVA;
        double totalConIVA = total + iva;
        
//		double iva = total * 0.21;
//		double iva2 = total * 0.04;
//		double totalConIVA = total + iva;

		System.out.println("Total bruto: " + total + "€");
		System.out.println("IVA aplicado (" + (tasaIVA * 100) + "%): " + iva + "€");
		System.out.println("Total con IVA: " + totalConIVA + "€");
		System.out.print("Ingrese cantidad pagada: ");
		double pago = scanner.nextDouble();
		scanner.nextLine();
		if (pago >= totalConIVA) {
			System.out.println("Cambio a devolver: " + (pago - totalConIVA) + "€");
			carrito.clear();
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	private static void administrarStock() {
		System.out.println("1. Agregar nuevo producto");
		System.out.println("2. Añadir stock");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		scanner.nextLine();

		if (opcion == 1) {
			System.out.print("Ingrese el nombre del nuevo producto: ");
			String producto = scanner.nextLine();
			System.out.print("Ingrese el precio: ");
			double precio = scanner.nextDouble();
			System.out.print("Ingrese la cantidad inicial: ");
			int cantidad = scanner.nextInt();
			scanner.nextLine();

			inventario.put(producto, precio);
			stock.put(producto, cantidad);
			System.out.println("Producto agregado correctamente.");
		} else if (opcion == 2) {
			System.out.print("Ingrese el nombre del producto a reabastecer: ");
			String producto = scanner.nextLine();
			if (stock.containsKey(producto)) {
				System.out.print("Ingrese la cantidad a añadir: ");
				int cantidad = scanner.nextInt();
				scanner.nextLine();
				stock.put(producto, stock.get(producto) + cantidad);
				System.out.println("Stock actualizado.");
			} else {
				System.out.println("Producto no encontrado.");
			}
		} else {
			System.out.println("Opción inválida.");
		}
	}
}
