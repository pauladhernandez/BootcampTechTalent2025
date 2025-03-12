package UD06MetodosyArrays.UD_06_Tareas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class T6_Ejercicio12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int tamaño = obtenerTamañoArray(scanner);
        int[] numeros = generarNumerosAleatorios(tamaño);
        int digitoFinal = obtenerDigitoFinal(scanner);
        
        ArrayList<Integer> filtrados = filtrarNumerosPorDigito(numeros, digitoFinal);
        
        mostrarArray("Números generados:", numeros);
        mostrarArray("Números que terminan en " + digitoFinal + ":", filtrados);
        
        scanner.close();
    }
    
    public static int obtenerTamañoArray(Scanner scanner) {
        System.out.print("Introduce el tamaño del array: ");
        return scanner.nextInt();
    }
    
    public static int[] generarNumerosAleatorios(int tamaño) {
        Random random = new Random();
        int[] numeros = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            numeros[i] = random.nextInt(300) + 1;
        }
        return numeros;
    }
    
    public static int obtenerDigitoFinal(Scanner scanner) {
        int digitoFinal;
        do {
            System.out.print("Introduce un dígito del 0 al 9 para filtrar los números: ");
            digitoFinal = scanner.nextInt();
        } while (digitoFinal < 0 || digitoFinal > 9);
        return digitoFinal;
    }
    
    public static ArrayList<Integer> filtrarNumerosPorDigito(int[] numeros, int digitoFinal) {
        ArrayList<Integer> filtrados = new ArrayList<>();
        for (int num : numeros) {
            if (num % 10 == digitoFinal) {
                filtrados.add(num);
            }
        }
        return filtrados;
    }
    
    public static void mostrarArray(String mensaje, int[] numeros) {
        System.out.println(mensaje);
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void mostrarArray(String mensaje, ArrayList<Integer> numeros) {
        System.out.println(mensaje);
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}