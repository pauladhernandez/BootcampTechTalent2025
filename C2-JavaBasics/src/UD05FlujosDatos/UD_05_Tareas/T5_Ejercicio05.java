package UD05FlujosDatos.UD_05_Tareas;
import javax.swing.JOptionPane;

public class T5_Ejercicio05 {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("Escribe un número");
		
		int numero = Integer.parseInt(input);
		
		if (numero % 2 == 0) {
			JOptionPane.showMessageDialog(null, numero + " es divisible entre 2.");
		} else {
			JOptionPane.showConfirmDialog(null, numero + " NO es divisible entre 2.");
			
		}

	}

}
