package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.HashMap;
import java.util.Scanner;

public class T7_Ejercicio01 {

    public static void main(String[] args) {
        HashMap<String, Double> notasMedia = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int numAlumnos = solicitarNumeroAlumnos(scanner);
        ingresarNotasAlumnos(scanner, notasMedia, numAlumnos);
        mostrarNotasMedias(notasMedia);

        scanner.close();
    }

    private static int solicitarNumeroAlumnos(Scanner scanner) {
        System.out.print("Ingrese el número de alumnos: ");
        int numAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return numAlumnos;
    }

    private static void ingresarNotasAlumnos(Scanner scanner, HashMap<String, Double> notasMedia, int numAlumnos) {
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            String nombre = solicitarNombre(scanner);
            double notaMedia = calcularNotaMedia(scanner);
            notasMedia.put(nombre, notaMedia);
        }
    }

    private static String solicitarNombre(Scanner scanner) {
        System.out.print("Nombre del alumno: ");
        return scanner.nextLine();
    }

    private static double calcularNotaMedia(Scanner scanner) {
        System.out.print("Ingrese la nota del primer examen: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Ingrese la nota del segundo examen: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Ingrese la nota del tercer examen: ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        return (nota1 + nota2 + nota3) / 3.0;
    }

    private static void mostrarNotasMedias(HashMap<String, Double> notasMedia) {
        System.out.println("\nNotas medias de los alumnos:");
        for (String nombre : notasMedia.keySet()) {
            System.out.println("Alumno: " + nombre + " - Nota media: " + notasMedia.get(nombre));
        }
    }
}
