package UD09HerenciaEnJAVA.UD09HerenciaEnJAVA_Tareas;

import java.util.Random;

public class T9_Ejercicio06 {


	class Pelicula {
	    String titulo;
	    int duracion;
	    int edadMinima;
	    String director;

	    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
	        this.titulo = titulo;
	        this.duracion = duracion;
	        this.edadMinima = edadMinima;
	        this.director = director;
	    }
	}

	class Espectador {
	    String nombre;
	    int edad;
	    double dinero;

	    public Espectador(String nombre, int edad, double dinero) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.dinero = dinero;
	    }
	}

	class Asiento {
	    String etiqueta;
	    boolean ocupado;

	    public Asiento(String etiqueta) {
	        this.etiqueta = etiqueta;
	        this.ocupado = false;
	    }
	}

	class Cine {
	    Asiento[][] sala;
	    Pelicula pelicula;
	    double precioEntrada;
	    Random random;

	    public Cine(Pelicula pelicula, double precioEntrada) {
	        this.pelicula = pelicula;
	        this.precioEntrada = precioEntrada;
	        this.sala = new Asiento[8][9];
	        this.random = new Random();
	        inicializarSala();
	    }

	    private void inicializarSala() {
	        char[] columnas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 9; j++) {
	                sala[i][j] = new Asiento((8 - i) + " " + columnas[j]);
	            }
	        }
	    }

	    public boolean sentarEspectador(Espectador espectador) {
	        if (espectador.edad < pelicula.edadMinima || espectador.dinero < precioEntrada) {
	            return false;
	        }

	        while (true) {
	            int fila = random.nextInt(8);
	            int columna = random.nextInt(9);
	            if (!sala[fila][columna].ocupado) {
	                sala[fila][columna].ocupado = true;
	                System.out.println(espectador.nombre + " se ha sentado en " + sala[fila][columna].etiqueta);
	                return true;
	            }
	        }
	    }

	    public void mostrarSala() {
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 9; j++) {
	                System.out.print((sala[i][j].ocupado ? "[X]" : "[ ]") + " ");
	            }
	            System.out.println();
	        }
	    }
	}

	public class SimulacionCine {
	    public static void main(String[] args) {
	        Pelicula pelicula = new Pelicula("Matrix", 120, 13, "Wachowski");
	        Cine cine = new Cine(pelicula, 10.0);
	        Random random = new Random();

	        String[] nombres = {"Ana", "Luis", "Carlos", "Marta", "Pedro", "Lucía", "Juan", "Sofía"};
	        for (int i = 0; i < 10; i++) {
	            Espectador espectador = new Espectador(
	                nombres[random.nextInt(nombres.length)],
	                random.nextInt(50) + 5, 
	                random.nextDouble() * 20
	            );
	            cine.sentarEspectador(espectador);
	        }

	        cine.mostrarSala();
	    }
	}

}
