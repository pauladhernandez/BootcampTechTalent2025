package UD08POO.UD08POO_Tareas;

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

	public Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = "";
		this.sexo = sexo;
		this.peso = 0.0;
		this.altura = 0.0;
	}

	public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public String getDNI() {
		return DNI;
	}
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void mostrar() {
		System.out.println("Su nombre es " + this.nombre + ", y tiene " + this.edad + " años. Su DNI es " + this.DNI
				+ ", su sexo es " + this.sexo + ", su peso es " + this.peso + " y su altura es " + this.altura + ".");
	}
	
	public static void main(String[] args) {
		Persona persona1 = new Persona("Concha", 24, "43764245P", 'M', 60, 1.62);
		Persona persona2 = new Persona("Alejo", 28, "98237485Z", 'H', 80, 1.80);
		Persona persona3 = new Persona("Maria", 24, "12345678A", 'M', 60, 1.59);
		persona1.mostrar();
		persona2.mostrar();
		persona3.mostrar();
	}
	
}
