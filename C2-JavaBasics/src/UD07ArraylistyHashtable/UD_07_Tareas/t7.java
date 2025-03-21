package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.ArrayList;

public class t7{
		
	private static 	ArrayList<String> listaProductos=new ArrayList<String>();
//		ArrayList<Integer> listaStock = new ArrayList<>();
//		ArrayList<String> listaBootcamp = new Arraylist<>();
		
		public static void main(String [] args) {
			inicializarProductos();
			listarProductos();
		}
		private static void inicializarProductos() {
		
		listaProductos.add("Gafas, 10€");
		listaProductos.add("Pulsera, 5€");
		listaProductos.add("Ordenador, 100€");
		listaProductos.add("Funda, 13€");
		listaProductos.add("Ratón, 10€");
		listaProductos.add("Soporte, 2€");
		listaProductos.add("Cargador, 90€");
		listaProductos.add("Escritorio, 50€");
		listaProductos.add("Reloj, 90€");
		listaProductos.add("Audífonos, 100€");
		
		}
		
		private static void listarProductos() {
			System.out.println("\nInventario: ");
			for (Object primera : listaProductos) {
				System.out.println(primera);
			
		}
	
		}
		
//		System.out.println(listaProductos.toString());
//		System.out.println(listaProductos.size());
		
//		listaBootcamp.add()
		
		
	}
	


