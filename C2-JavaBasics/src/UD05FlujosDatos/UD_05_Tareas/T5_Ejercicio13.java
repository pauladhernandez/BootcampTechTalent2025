package UD05FlujosDatos.UD_05_Tareas;

import javax.swing.JOptionPane;

public class T5_Ejercicio13 {

	public static void main(String[] args) {
		
		//Inicializamos las variables
		int ope1 = 0, ope2 = 0;
		String signo = "";
		
		//Pedimos los datos
		String input1= JOptionPane.showInputDialog("Introduce el primer operando");
		ope1 = Integer.parseInt(input1);
		String input2= JOptionPane.showInputDialog("Introduce el segundo operando");
		ope2 = Integer.parseInt(input2);
		signo = JOptionPane.showInputDialog("Introduce el signo aritmético");
		
		//Mostramos lo que vamos a calcular
		JOptionPane.showMessageDialog(null,"Resultado de : "
										+ ope1 + " " +signo + " " + ope2  + "=");
		
		switch (signo) {
			case "+":
				JOptionPane.showMessageDialog(null, ope1 + ope2);
				break;
			case "-":
				JOptionPane.showMessageDialog(null, ope1 - ope2);
				break;
			case "*":
				JOptionPane.showMessageDialog(null, ope1 * ope2);
				break;
			case "/":
				JOptionPane.showMessageDialog(null, (double) ope1 / ope2);
				break;
			case "^":
				JOptionPane.showMessageDialog(null, Math.pow(ope1, ope2));
				break;
			case "%":
				JOptionPane.showMessageDialog(null, ope1 % ope2);
				break;
			
				
		}
		
		
		
		//System.out.println("") es equivalente a JOptionPane.showMessageDialog(null, "")
		//Scanner scanner = new Scanner(System.in); es equivalente a JOptionPane.showInputDialog("")
		//scanner.close() es equivalente a cerrar la ventana de JOptionPane.showMessageDialog(null, "")
		
	
			
		
		
		
		

	}

}
