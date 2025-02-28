package UD06MetodosyArrays.UD_06_Tareas;

import javax.swing.JOptionPane;

public class T6_Ejercicio1 {

	public static void main(String[] args) {
		
		double radio = 0;
		double area = AreaCirculo(radio);
//		System.out.println("El área del círculo es:" + area);
		JOptionPane.showMessageDialog(null, "El área del círculo es:" + area);
		
		
		
	}

	public static double AreaCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);

	}
}
