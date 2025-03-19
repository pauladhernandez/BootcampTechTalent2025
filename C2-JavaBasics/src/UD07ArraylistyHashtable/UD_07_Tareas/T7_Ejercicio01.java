package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.HashMap;
import java.util.Scanner;

public class T7_Ejercicio01 {

	public static void main(String[] args) {

		// Crear un diccionario para almacenar las notas medias de los alumnos
		HashMap<String, Double> notasMedia = new HashMap<>();
		Scanner scanner = new Scanner(System.in);

		// Solicitar el número de alumnos
		System.out.print("Ingrese el número de alumnos: ");
		int numAlumnos = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer

		// Bucle para ingresar los datos de cada alumno
		for (int i = 0; i < numAlumnos; i++) {
			System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");

			// Ingresar el nombre del alumno
			System.out.print("Nombre del alumno: ");
			String nombre = scanner.nextLine();

			// Ingresar las notas del alumno
			System.out.print("Ingrese la nota del primer examen: ");
			double nota1 = scanner.nextDouble();
			System.out.print("Ingrese la nota del segundo examen: ");
			double nota2 = scanner.nextDouble();
			System.out.print("Ingrese la nota del tercer examen: ");
			double nota3 = scanner.nextDouble();
			scanner.nextLine(); // Limpiar el buffer

			// Calcular la nota media
			double notaMedia = (nota1 + nota2 + nota3) / 3.0;

			// Almacenar la nota media en el diccionario
			notasMedia.put(nombre, notaMedia);
		}

		// Mostrar las notas medias de todos los alumnos
		System.out.println("\nNotas medias de los alumnos:");
		for (String nombre : notasMedia.keySet()) {
			System.out.println("Alumno: " + nombre + " - Nota media: " + notasMedia.get(nombre));
		}

		scanner.close();
	}
}