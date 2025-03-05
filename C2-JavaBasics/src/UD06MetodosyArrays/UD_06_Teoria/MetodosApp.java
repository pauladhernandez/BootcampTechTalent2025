package UD06MetodosyArrays.UD_06_Teoria;

import javax.swing.JOptionPane;

public class MetodosApp {

	public static void main(String[] args) {
		
		
		int argumento1 = 0, argumento2 = 0;
		
		argumento1 =  Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número"));
		argumento2 =  Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo número"));
		
		System.out.println("El resultado de la suma es: " + sumaNumeros(argumento1, argumento2));
	}				
	
		public static int sumaNumeros(int parametro1, int parametro2) {
			
			return 	parametro1 + parametro2;
			
		}
		
		

	}


