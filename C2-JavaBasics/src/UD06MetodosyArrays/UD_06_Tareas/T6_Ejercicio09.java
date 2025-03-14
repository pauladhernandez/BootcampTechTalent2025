package UD06MetodosyArrays.UD_06_Tareas;

	import java.util.Random;
	import java.util.Scanner;

	public class T6_Ejercicio09 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Pedimos el tamaño del array
	        System.out.print("Introduce el tamaño del array: ");
	        int tamaño = scanner.nextInt();
	        
	        // Crear el array
	        int[] array = new int[tamaño];
	        
	        // Rellenar el array con números aleatorios entre 0 y 9
	        rellenarArray(array, 0, 9);
	        
	        // Mostrar el contenido del array y la suma
	        mostrarArray(array);
	        
	        scanner.close();
	    }

	    // Método para rellenar el array con números aleatorios
	    public static void rellenarArray(int[] array, int min, int max) {
	        Random rand = new Random();
	        for (int i = 0; i < array.length; i++) {
	            // Generamos un número aleatorio entre min y max
	            array[i] = rand.nextInt(max - min + 1) + min;
	        }
	    }

	    // Método para mostrar el contenido del array y la suma
	    public static void mostrarArray(int[] array) {
	        int suma = 0;
	        for (int i = 0; i < array.length; i++) {
	            System.out.println("Índice " + i + ": " + array[i]);
	            suma += array[i];
	        }
	        System.out.println("La suma total de los valores es: " + suma);
	    }

	}

