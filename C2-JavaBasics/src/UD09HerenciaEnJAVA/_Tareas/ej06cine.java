package UD09HerenciaEnJAVA._Tareas;

import java.util.Scanner;

class ej06cine {
    String titulo;
    int duracion;
    int edadMinima;
    String director;

    public ej06cine(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public void mostrarDetalles() {
        System.out.println("\nPelícula en exhibición:");
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Edad mínima: " + edadMinima + " años");
        System.out.println("Director: " + director);
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
    int fila;
    char columna;
    boolean ocupado;

    public Asiento(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
    }
}

class Cine {
    ej06cine pelicula;
    double precioEntrada;
    Asiento[][] asientos;

    public Cine(ej06cine pelicula, double precioEntrada, int filas, int columnas) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(filas - i, (char) ('A' + j)); // Ajuste para que la fila sea numérica descendente
            }
        }
    }

    public void mostrarAsientos() {
        System.out.println("\nEstado de los asientos:");
        for (Asiento[] fila : asientos) {
            for (Asiento asiento : fila) {
                System.out.print(asiento.ocupado ? "[X] " : "[" + asiento.fila + asiento.columna + "] ");
            }
            System.out.println();
        }
    }

    public boolean puedeEntrar(Espectador espectador) {
        if (espectador.edad < pelicula.edadMinima) {
            System.out.println(espectador.nombre + " no puede entrar a ver la película por ser menor de edad.");
            return false;
        } else if (espectador.dinero < precioEntrada) {
            System.out.println(espectador.nombre + " no tiene suficiente dinero para la entrada.");
            return false;
        }
        return true;
    }

    public boolean esAsientoValido(int fila, char columna) {
        int filaIndex = asientos.length - fila;
        int colIndex = columna - 'A';

        if (filaIndex < 0 || filaIndex >= asientos.length || colIndex < 0 || colIndex >= asientos[0].length) {
            System.out.println(" El asiento " + fila + columna + " no es válido. Intenta de nuevo.");
            return false;
        }
        if (asientos[filaIndex][colIndex].ocupado) {
            System.out.println("️ El asiento " + fila + columna + " ya está ocupado. Intenta con otro.");
            return false;
        }
        return true;
    }

    public void sentarEspectador(Espectador espectador, Scanner scanner) {
        int fila;
        char columna;

        do {
            mostrarAsientos();
            System.out.print("️ Elige una fila (1-" + asientos.length + "): ");
            while (!scanner.hasNextInt()) { 
                System.out.println(" Entrada inválida. Ingresa un número para la fila.");
                scanner.next();
            }
            fila = scanner.nextInt();

            System.out.print(" Elige una columna (A-" + (char) ('A' + asientos[0].length - 1) + "): ");
            columna = scanner.next().toUpperCase().charAt(0);

        } while (!esAsientoValido(fila, columna));

        int filaIndex = asientos.length - fila;
        int colIndex = columna - 'A';

        asientos[filaIndex][colIndex].ocupado = true;
        System.out.println("✅ " + espectador.nombre + " se ha sentado en el asiento " + fila + columna);
    }
}

