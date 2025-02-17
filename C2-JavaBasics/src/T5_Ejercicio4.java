import javax.swing.JOptionPane;

public class T5_Ejercicio4 {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("¿Cuál es el radio del círculo?");
		
		double radio = Double.parseDouble(input);
		
		double area = Math.PI * Math.pow(radio, 2);
		
		JOptionPane.showMessageDialog(null, "El área del círculo es: " + area);
		

	}

}
