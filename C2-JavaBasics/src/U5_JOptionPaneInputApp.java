import javax.swing.JOptionPane;

public class U5_JOptionPaneInputApp {

	public static void main(String[] args) {
	
		String nombre=JOptionPane.showInputDialog("Introduce tu nombre");
		
		JOptionPane.showMessageDialog(null, "Bien, tu nombre es " + nombre);
		
		

	}

}
