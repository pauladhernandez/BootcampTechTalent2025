
package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número ");
        int number = scanner.nextInt();
        scanner.close();

        int result = factorial(number);
        System.out.println("El factorial de " + number + " es " + result);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
        
//        public static int factorial(int n) {
//        n = Math.abs(n);
//        
//        if(n <= 1) {
//        	return 1;
//        } else {
//        	return n * factorial(n-1);
        	
        }
    }


