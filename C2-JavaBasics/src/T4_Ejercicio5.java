
public class T4_Ejercicio5 {

	public static void main(String[] args) {
//		Declarar el valor 
		int A=10;
		int B=20;
		int C=30;
		int D=40;
		
		System.out.println("Valores iniciales: ");
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
		System.out.println("D = " + D);
		
//		Las variables intercambian el valor
		int tempB = B;
		B = C;
		C = A;
		A = D;
		D = tempB;
				
//		Resultados del intercambio de valores
		System.out.println("Valores después del intercambio: ");
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
		System.out.println("D = " + D);
		

	}

}
