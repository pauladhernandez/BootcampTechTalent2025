package UD08POO.UD08POO.UD08POO_Tareas;

public class Persona {

	private static final char SEXO_POR_DEFECTO = 'H';

	// Atributos
	private String nombre;
	private int edad;
	private String DNI;
	private char sexo;
	private double peso;
	private double altura;

//Constructor 
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.DNI = "";
		this.sexo = SEXO_POR_DEFECTO;
		this.peso = 0.0;
		this.altura = 0.0;

	}
	
	public Persona (String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = "";
		this.sexo = sexo;
		this.peso = 0.0;
		this.altura = 0.0;
	}
	public Persona (String nombre, int edad, String DNI, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre=nombre;
	}
	public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
