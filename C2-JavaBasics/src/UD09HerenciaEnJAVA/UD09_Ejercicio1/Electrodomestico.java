package UD09HerenciaEnJAVA.UD09_Ejercicio1;

public class Electrodomestico {

    // Constantes
    private static final String COLOR_POR_DEFECTO = "blanco";
    private static final char CONSUMO_POR_DEFECTO = 'F';
    private static final double PRECIO_BASE_POR_DEFECTO = 100;
    private static final double PESO_POR_DEFECTO = 5;

    private static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    private static final char[] CONSUMO_PERMITIDO = {'A', 'B', 'C', 'D', 'E', 'F'};

    // Atributos
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;

    // Constructores
    public Electrodomestico() {
        this(PRECIO_BASE_POR_DEFECTO, PESO_POR_DEFECTO, COLOR_POR_DEFECTO, CONSUMO_POR_DEFECTO);
    }

    public Electrodomestico(double precioBase, double peso) {
        this(precioBase, peso, COLOR_POR_DEFECTO, CONSUMO_POR_DEFECTO);
    }

    public Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
    }

    // Métodos getters
    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    // Métodos privados
    private String comprobarColor(String color) {
        for (String c : COLORES_DISPONIBLES) {
            if (c.equalsIgnoreCase(color)) {
                return c.toLowerCase();
            }
        }
        return COLOR_POR_DEFECTO;
    }

    private char comprobarConsumoEnergetico(char consumo) {
        for (char c : CONSUMO_PERMITIDO) {
            if (c == Character.toUpperCase(consumo)) {
                return c;
            }
        }
        return CONSUMO_POR_DEFECTO;
    }

    // Método para calcular el precio final
    public double precioFinal() {
        double incremento = 0;

        switch (consumoEnergetico) {
            case 'A': incremento += 100; break;
            case 'B': incremento += 80; break;
            case 'C': incremento += 60; break;
            case 'D': incremento += 50; break;
            case 'E': incremento += 30; break;
            case 'F': incremento += 10; break;
        }

        if (peso >= 0 && peso < 20) {
            incremento += 10;
        } else if (peso >= 20 && peso < 50) {
            incremento += 50;
        } else if (peso >= 50 && peso < 80) {
            incremento += 80;
        } else if (peso >= 80) {
            incremento += 100;
        }

        return precioBase + incremento;
    }
}
