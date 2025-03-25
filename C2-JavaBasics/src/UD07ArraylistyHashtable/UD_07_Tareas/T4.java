package UD07ArraylistyHashtable.UD_07_Tareas;


	import java.util.*;

	public class T4 {

			private static Map<String, Double> inventario = new HashMap<>();
			private static Map<String, Integer> stock = new HashMap<>();
			private static Scanner scanner = new Scanner(System.in);
			private static double totalAPagar = 0.0;

			public static void main(String[] args) {
				inicializarInventario();
				boolean ejecutando = true;

				while (ejecutando) {
					System.out.println("\n1. Comprar producto");
					System.out.println("2. Administrar stock");
					System.out.println("3. Pagar");
					System.out.println("4. Salir");
					System.out.print("Seleccione una opción: ");
					int opcion = scanner.nextInt();
					scanner.nextLine();

					switch (opcion) {
					case 1:
						comprarProducto();
						break;
					case 2:
						administrarStock();
						break;
					case 3:
						pagar();
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
				inventario.put("Pulsera", 1.50);
				stock.put("Pulsera", 10);
				inventario.put("Escritorio", 1.00);
				stock.put("Escritorio", 15);
				inventario.put("Pan", 1.00);
				stock.put("Pan", 15);
				inventario.put("Pan", 1.00);
				stock.put("Pan", 15);
			}

			private static void comprarProducto() {
				System.out.println("Productos disponibles:");
				for (String producto : inventario.keySet()) {
					System.out.println(
							producto + " - Precio: " + inventario.get(producto) + "€ - Stock: " + stock.get(producto));
				}

				System.out.print("Ingrese el nombre del producto: ");
				String producto = scanner.nextLine();
				if (inventario.containsKey(producto) && stock.get(producto) > 0) {
					stock.put(producto, stock.get(producto) - 1);
					double total = inventario.get(producto) * 1.21;
					totalAPagar += total;
					System.out.println("Total con IVA: " + total + "€");
				} else {
					System.out.println("Producto no disponible o sin stock.");
				}
			}

			private static void administrarStock() {
				System.out.print("Ingrese el nombre del producto: ");
				String producto = scanner.nextLine();
				System.out.print("Ingrese la cantidad a añadir: ");
				int cantidad = scanner.nextInt();
				scanner.nextLine();
				stock.put(producto, stock.getOrDefault(producto, 0) + cantidad);
				System.out.println("Stock actualizado.");
			}

			private static void pagar() {
				 if (totalAPagar > 0) {
				        System.out.println("Seleccione el porcentaje de IVA:");
				        System.out.println("1. 21%");
				        System.out.println("2. 4%");
				        int opcionIVA = scanner.nextInt();
				        scanner.nextLine();
				        double ivaSeleccionado = 0.21; // Default IVA
				        switch (opcionIVA) {
				            case 1:
				                ivaSeleccionado = 0.21;
				                break;
				            case 2:
				                ivaSeleccionado = 0.04;
				                break;
				            default:
				                System.out.println("Opción inválida. Se aplicará el IVA del 21%.");
				        }

				        double totalConIVA = totalAPagar * (1 + ivaSeleccionado);
				        System.out.println("El total a pagar con IVA es: " + totalConIVA + "€");
				        System.out.print("Ingrese la cantidad con la que va a pagar: ");
				        double pago = scanner.nextDouble();
				        scanner.nextLine();
				        if (pago >= totalConIVA) {
				            double cambio = pago - totalConIVA;
				            System.out.println("Pago realizado con éxito. Su cambio es: " + redondear(cambio) + "€");
				            totalAPagar = 0.0;
				        } else {
				            System.out.println("Pago insuficiente. Por favor, intente nuevamente.");
				        }
				    } else {
				        System.out.println("No hay productos en el carrito.");
				}
			}
			 private static double redondear(double valor) {
			        return Math.round(valor * 100) / 100.0;
			    }
		}

