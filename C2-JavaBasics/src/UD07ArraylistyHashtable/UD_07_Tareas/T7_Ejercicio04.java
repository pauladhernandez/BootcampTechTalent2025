package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.*;

public class T7_Ejercicio04 {

class GestionTienda {
    private static HashMap<String, Double> stockProductos = new HashMap<>();
    private static List<Double> carritoCompra = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarStock();
        int opcion;
        do {
            System.out.println("\n--- Gestión de Tienda ---");
            System.out.println("1. Añadir producto al stock");
            System.out.println("2. Consultar producto en stock");
            System.out.println("3. Listar productos en stock");
            System.out.println("4. Realizar venta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    consultarProducto();
                    break;
                case 3:
                    listarProductos();
                    break;
                case 4:
                    realizarVenta();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }
    
    private static void inicializarStock() {
        stockProductos.put("Leche", 1.20);
        stockProductos.put("Pan", 0.90);
        stockProductos.put("Arroz", 2.50);
        stockProductos.put("Azúcar", 1.80);
        stockProductos.put("Cereal", 3.00);
    }

    private static void añadirProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        stockProductos.put(producto, precio);
        System.out.println("Producto añadido correctamente.");
    }

    private static void consultarProducto() {
        System.out.print("Ingrese el nombre del producto a consultar: ");
        String producto = scanner.nextLine();
        if (stockProductos.containsKey(producto)) {
            System.out.println("Precio de " + producto + ": " + stockProductos.get(producto) + " €");
        } else {
            System.out.println("El producto no está en stock.");
        }
    }

    private static void listarProductos() {
        System.out.println("\nLista de productos en stock:");
        for (Map.Entry<String, Double> entry : stockProductos.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " €");
        }
    }

    private static void realizarVenta() {
        carritoCompra.clear();
        double totalBruto = 0;
        while (true) {
            System.out.print("Ingrese el nombre del producto a comprar (o 'fin' para terminar): ");
            String producto = scanner.nextLine();
            if (producto.equalsIgnoreCase("fin")) {
                break;
            }
            if (stockProductos.containsKey(producto)) {
                carritoCompra.add(stockProductos.get(producto));
                totalBruto += stockProductos.get(producto);
            } else {
                System.out.println("El producto no está en stock.");
            }
        }
        
        double iva = totalBruto > 10 ? 0.21 : 0.04;
        double totalConIVA = totalBruto * (1 + iva);
        System.out.println("IVA aplicado: " + (iva * 100) + "%");
        System.out.println("Total bruto: " + totalBruto + " €");
        System.out.println("Total con IVA: " + totalConIVA + " €");
        System.out.print("Ingrese la cantidad pagada: ");
        double cantidadPagada = scanner.nextDouble();
        System.out.println("Cambio a devolver: " + (cantidadPagada - totalConIVA) + " €");
    }
}
}
