package UD09_Ejercicio1;

public class Lavadora extends Electrodomestico {

    // Constante
    private static final int CARGA_POR_DEFECTO = 5;

    // Atributo
    private int carga;

    // Constructores
    public Lavadora() {
        super(); // Llama al constructor por defecto de la clase padre
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso); // Llama al constructor de la clase padre con precio y peso
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precioBase, double peso, String color, char consumoEnergetico, int carga) {
        super(precioBase, peso, color, consumoEnergetico); // Constructor completo
        this.carga = carga;
    }

    // Método getter
    public int getCarga() {
        return carga;
    }

    // Método para calcular el precio final
    
    public double precioFinal() {
        double precioFinal = super.precioFinal(); // Llama al método de la clase padre
        if (carga > 30) {
            precioFinal += 50; // Incrementa el precio si la carga es mayor a 30 kg
        }
        return precioFinal;
    }
}
