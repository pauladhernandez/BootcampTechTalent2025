package UD09_Ejercicio1.copy;

public class Television extends Electrodomestico {

    // Constantes
    private static final int RESOLUCION_POR_DEFECTO = 20;
    private static final boolean SINTONIZADOR_TDT_POR_DEFECTO = false;

    // Atributos
    private int resolucion;
    private boolean sintonizadorTDT;

    // Constructores
    public Television() {
        super(); // Llama al constructor por defecto de la clase padre
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso); // Constructor con precio y peso
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(double precioBase, double peso, String color, char consumoEnergetico, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, peso, color, consumoEnergetico); // Constructor completo
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    // Métodos getters
    public int getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    // Método para calcular el precio final
    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal(); // Llama al método de la clase padre
        if (resolucion > 40) {
            precioFinal += precioFinal * 0.30; // Incrementa el precio un 30% si resolución > 40 pulgadas
        }
        if (sintonizadorTDT) {
            precioFinal += 50; // Incrementa el precio si tiene sintonizador TDT
        }
        return precioFinal;
    }
}
