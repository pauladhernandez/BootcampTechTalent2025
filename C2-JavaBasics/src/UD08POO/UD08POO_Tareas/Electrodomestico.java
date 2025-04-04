package UD08POO.UD08POO_Tareas;

public class Electrodomestico {

	private static final String COLOR_POR_DEFECTO = "blanco";
	private static final char CONSUMO_POR_DEFECTO = 'F';
	private static final double PRECIO_BASE_POR_DEFECTO = 100;
	private static final double PESO_POR_DEFECTO = 5;

	private static final String[] COLORES_DISPONIBLES = {"blanco", 
								"negro", "rojo", "azul", "gris"};
	private static final char[] CONSUMO_PERMITIDO = {'A', 
								'B', 'C', 'D', 'E', 'F'};
	
	// Atributos
	private double precioBase;
	private String color;
	private char consumoEnergetico;
	private double peso;

	// Constructores
	public Electrodomestico() {
		this(PRECIO_BASE_POR_DEFECTO, PESO_POR_DEFECTO, COLOR_POR_DEFECTO, CONSUMO_POR_DEFECTO);
		//this.precioBase = 100;

	}

	public Electrodomestico(double precioBase, double peso) {
        this(precioBase, peso, COLOR_POR_DEFECTO, CONSUMO_POR_DEFECTO);
	}
	
	public Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumo(consumoEnergetico);
}
	private String comprobarColor(String color) {
        for (String c : COLORES_DISPONIBLES) {
            if (c.equalsIgnoreCase(color)) {
                return c.toLowerCase();
            }
        }
        return COLOR_POR_DEFECTO;
	}
	
	private char comprobarConsumo(char consumo) {
        for (char c : CONSUMO_PERMITIDO) {
            if (c == Character.toUpperCase(consumo)) {
                return c;
            }
        }
        return CONSUMO_POR_DEFECTO;
    }
	
    
        
}
