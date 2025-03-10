
package UD06MetodosyArrays.UD_06_Tareas;

import java.util.Scanner;

public class T6_Ejercicio04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número ");
        int numero = scanner.nextInt();
        scanner.close();

        int result = factorial(numero);
        System.out.println("El factorial de " + numero + " es " + result);
    }

    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) 
            resultado *= i;
        
        return resultado;
        
//        public static int factorial(int n) {
//        n = Math.abs(n);
//        
//        if(n <= 1) {
//        	return 1;
//        } else {
//        	return n * factorial(n-1);
        	
        }
    }


