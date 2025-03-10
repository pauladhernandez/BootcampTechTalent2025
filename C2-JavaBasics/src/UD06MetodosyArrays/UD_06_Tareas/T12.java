package UD06MetodosyArrays.UD_06_Tareas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class T12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int size = solicitarTamanoArray(scanner);
        int[] numbers = crearArrayAleatorio(size, random);
        int digit = solicitarDigito(scanner);

        ArrayList<Integer> filteredNumbers = filtrarNumerosPorDigito(numbers, digit);

        mostrarNumerosFiltrados(filteredNumbers, digit);

        scanner.close();
    }

    private static int solicitarTamanoArray(Scanner scanner) {
        System.out.print("Introduce el tamaño del array: ");
        return scanner.nextInt();
    }

    private static int[] crearArrayAleatorio(int size, Random random) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(300) + 1;
        }
        return numbers;
    }

    private static int solicitarDigito(Scanner scanner) {
        int digit;
        while (true) {
            System.out.print("Introduce un dígito (0-9): ");
            digit = scanner.nextInt();
            if (digit >= 0 && digit <= 9) {
                break;
            } else {
                System.out.println("Por favor, introduce un dígito válido entre 0 y 9.");
            }
        }
        return digit;
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

    private static ArrayList<Integer> filtrarNumerosPorDigito(int[] numbers, int digit) {
        ArrayList<Integer> filteredNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 10 == digit) {
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }

    private static void mostrarNumerosFiltrados(ArrayList<Integer> filteredNumbers, int digit) {
        System.out.println("Números que terminan en " + digit + ": " + filteredNumbers);
    }
}
