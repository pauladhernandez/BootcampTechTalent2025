package UD09HerenciaEnJAVA._Tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ej06cineApp {
    public static void main(String[] args) {

        ej06cine pelicula = new ej06cine("Interstellar", 169, 12, "Christopher Nolan");
        Cine cine = new Cine(pelicula, 10.0, 8, 9);

        List<Espectador> espectadores = new ArrayList<>();
        Random random = new Random();

        // Generar espectadores aleatorios
        String[] nombres = { "Ivette", "Carlos", "Ana" };
        for (String nombre : nombres) {
            espectadores.add(new Espectador(nombre, random.nextInt(50) + 5, random.nextDouble() * 20));
        }

        Scanner scanner = new Scanner(System.in);

        // Mostrar los detalles de la película una sola vez
        pelicula.mostrarDetalles();

        for (Espectador espectador : espectadores) {
            if (cine.puedeEntrar(espectador)) {
                System.out.println("\n" + espectador.nombre + " (Edad: " + espectador.edad + ", Dinero: "
                        + espectador.dinero + ") puede elegir un asiento.");
                
                cine.sentarEspectador(espectador, scanner); // Ahora usa el método con validación
            } else {
                System.out.println(espectador.nombre + " no puede elegir asiento.\n");
            }
        }

        scanner.close();
    }
}
