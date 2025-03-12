
package UD06MetodosyArrays.UD_06_Tareas;

public class T6_Ejercicio05 {

    public static void main(String[] args) {
        int numeroDecimal = 0; 
        String numeroBinario = decimalABinario(numeroDecimal);
        System.out.println("El binario de " + numeroDecimal + " es: " + numeroBinario);
    }

    public static String decimalABinario(int numero) {
        if (numero == 0) {
            return "0";
        }

        StringBuilder binario = new StringBuilder();
		while (numero > 0) {
            int resto = numero % 2;
            binario.insert(0, resto);
            numero = numero / 2;
        }
        return binario.toString();
    }
}
