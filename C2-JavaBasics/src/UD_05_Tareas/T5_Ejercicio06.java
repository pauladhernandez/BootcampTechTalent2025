package UD_05_Tareas;
import javax.swing.JOptionPane;

public class T5_Ejercicio06 {

	public static void main(String[] args) {
		
		final double IVA=0.21;
		String text_num=JOptionPane.showInputDialog("Introduce el precio del producto");
		
		int precio=Integer.parseInt(text_num);
		JOptionPane.showMessageDialog(null, "El producto tiene un precio de "+precio+""
				+ " y su precio final es de "+(precio+(precio*IVA)));
		
	}

}
