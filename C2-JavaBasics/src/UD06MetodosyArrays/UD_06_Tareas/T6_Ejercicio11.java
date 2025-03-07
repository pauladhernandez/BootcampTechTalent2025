package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class T6_Ejercicio11 {

	public static void main(String[] args) {
//		
//		Crea dos arrays de números con la dimensión pasada por teclado.
//		Uno de ellos estará rellenado con números aleatorios y el otro apuntara al array anterior,
//		reasigna los valores del segundo array con valores aleatorios.
//		Después, crea un método que tenga como parámetros, los dos arrays y devuelva uno nuevo
//		con la multiplicación de la posición 0 del array1 con el del array2 y así sucesivamente.
//		Por último, muestra el contenido de cada array.


		        // Crear los arrays
		        int[] array1 = new int[dimension];
		        int[] array2 = array1; // Apuntando inicialmente a array1
		        int[] multiplicado[]= new  
		        
		        // Rellenar array1 con valores aleatorios
		        llenarArrayAleatorio(array1);

		        // Reasignar valores aleatorios a array2
		        array2 = new int[dimension]; // Creamos un nuevo array para array2
		        llenarArrayAleatorio(array2);

		        // Crear el array de resultado con la multiplicación de ambos arrays
		        int[] resultado = multiplicarArrays(array1, array2);

		        // Mostrar los arrays
		        System.out.println("Array 1: " + Arrays.toString(array1));
		        System.out.println("Array 2: " + Arrays.toString(array2));
		        System.out.println("Resultado de la multiplicación: " + Arrays.toString(resultado));
		    }

		    // Método para llenar un array con números aleatorios entre 1 y 100
		    public static void llenarArrayAleatorio(int[] array) {
		        for (int i = 0; i < array.length; i++) {
		            array[i] = (int) (Math.random() * 100) + 1; // Números aleatorios entre 1 y 100
		        }
		    }

		    // Método que multiplica los elementos de dos arrays y devuelve un nuevo array con los resultados
		    public static int[] multiplicarArrays(int[] array1, int[] array2) {
		        int[] resultado = new int[array1.length];
		        for (int i = 0; i < array1.length; i++) {
		            resultado[i] = array1[i] * array2[i]; // Multiplicamos los valores
		        }
		        return resultado;
		    }
		

		
	}

}
