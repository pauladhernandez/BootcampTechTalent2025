package UD_05_Teoria;
import java.util.Scanner;

public class UD5_ScannerApp {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("-- Bienvenido a Java --");
//		System.out.println("Introduce tu nombre");
//		
//		String nombre = sc.nextLine();
//		sc.close();
//	
//		System.out.println("Hola " + nombre.toUpperCase());
//		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-- Bienvenido a Java --");
		System.out.println("Introduce tu edad");
		
		String edad = sc.nextLine();
		sc.close();
	
		System.out.println("Tu edad es " + edad.toUpperCase());
		
	}

}
