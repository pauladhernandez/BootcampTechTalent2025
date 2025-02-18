package UD04JavaBasics.teoria;

public class OpUnariosApp {

	public static void main(String[] args) {
		
		int op1=10; int x=0;
		
//		Equivalentes
//		x++;
//		++x;
//		x = x + 1;
		
		op1++;
		++op1;
		op1--;
		System.out.println(op1);

		x = op1++;
		System.out.println("La x vale: " + x 
				+ " y el operador 1 vale: " + op1); //op1 es 12
		x = ++op1; //
		System.out.println("La x vale: " + x 
				+ " y el operador 1 vale: " + op1);
	}

}
