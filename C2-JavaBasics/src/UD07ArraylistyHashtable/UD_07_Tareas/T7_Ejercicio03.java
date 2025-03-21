package UD07ArraylistyHashtable.UD_07_Tareas;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class T7_Ejercicio03 {
	
	    private static ArrayList<String> listaProductos = new ArrayList<>();
	    private static HashMap<String, Integer> stockProductos = new HashMap<>();
	    private static HashMap<String, Double> preciosProductos = new HashMap<>();

	    public static void main(String[] args) {
	        inicializarProductos();
	        listarProductos();
	        // Simulación de la interfaz visual para añadir productos
	        agregarProductoDesdeConsola();
	        consultarProducto();
	    }

	    private static void inicializarProductos() {
	        listaProductos.add("Gafas");
	        listaProductos.add("Pulsera");
	        listaProductos.add("Ordenador");
	        listaProductos.add("Funda");
	        listaProductos.add("Ratón");
	        listaProductos.add("Soporte");
	        listaProductos.add("Cargador");
	        listaProductos.add("Escritorio");
	        listaProductos.add("Reloj");
	        listaProductos.add("Audífonos");

	        preciosProductos.put("Gafas", 10.00);
	        preciosProductos.put("Pulsera", 5.00);
	        preciosProductos.put("Ordenador", 100.00);
	        preciosProductos.put("Funda", 13.00);
	        preciosProductos.put("Ratón", 10.00);
	        preciosProductos.put("Soporte", 2.00);
	        preciosProductos.put("Cargador", 90.00);
	        preciosProductos.put("Escritorio", 50.00);
	        preciosProductos.put("Reloj", 90.00);
	        preciosProductos.put("Audífonos", 100.00);

	        stockProductos.put("Gafas", 10);
	        stockProductos.put("Pulsera", 5);
	        stockProductos.put("Ordenador", 100);
	        stockProductos.put("Funda", 13);
	        stockProductos.put("Ratón", 10);
	        stockProductos.put("Soporte", 2);
	        stockProductos.put("Cargador", 90);
	        stockProductos.put("Escritorio", 50);
	        stockProductos.put("Reloj", 90);
	        stockProductos.put("Audífonos", 100);
	    }

	    private static void agregarProductoDesdeConsola() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese el nombre del producto: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingrese el precio del producto: ");
	        double precio = scanner.nextDouble();
	        System.out.print("Ingrese la cantidad del producto: ");
	        int cantidad = scanner.nextInt();

	        listaProductos.add(nombre);
	        preciosProductos.put(nombre, precio);
	        stockProductos.put(nombre, cantidad);
	        System.out.println("Producto agregado exitosamente.");
	    }
	    	

	    private static void consultarProducto() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese el nombre del producto a consultar: ");
	        String nombre = scanner.nextLine();

	        if (preciosProductos.containsKey(nombre)) {
	            System.out.println("Producto: " + nombre);
	            System.out.println("Precio: €" + preciosProductos.get(nombre));
	            System.out.println("Cantidad en stock: " + stockProductos.get(nombre));
	        } else {
	            System.out.println("El producto no existe en el inventario.");
	        }
	    }

	    private static void listarProductos() {
	        System.out.println("\nInventario:");
	        for (String producto : listaProductos) {
	            System.out.println(producto + " - €" + preciosProductos.get(producto) + "\nCantidad en stock: " + stockProductos.get(producto));
	        }
	        
	    }
	}

