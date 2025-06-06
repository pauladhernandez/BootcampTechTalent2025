package Juego_Grupal;

import javax.swing.JOptionPane;
import java.util.Random;

public class JuegoBatallaNaval {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¡Bienvenido a Batalla Naval!");

        String[] opciones = {"Jugador vs Jugador", "Jugador vs Computadora"};
        int opcion = JOptionPane.showOptionDialog(null, "Elige modo de juego:",
                "Batalla Naval", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        Jugador jugador1;
        Jugador jugador2;

        String nombre1 = JOptionPane.showInputDialog(null, "Nombre del Jugador 1:");
        jugador1 = new Jugador(nombre1);

        if (opcion == 0) {
            String nombre2 = JOptionPane.showInputDialog(null, "Nombre del Jugador 2:");
            jugador2 = new Jugador(nombre2);
        } else {
            jugador2 = new JugadorIA("Computadora");
            JOptionPane.showMessageDialog(null, "¡Enfrentarás a la computadora!");
        }

        colocarBarcosIniciales(jugador1);

        if (jugador2 instanceof JugadorIA) {
            colocarBarcosIA((JugadorIA) jugador2);
        } else {
            colocarBarcosIniciales(jugador2);
        }

        boolean juegoEnCurso = true;
        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (juegoEnCurso) {
            String tableroPropio = obtenerTableroComoString(actual.getTablero(), true);
            String tableroEnemigo = obtenerTableroComoString(oponente.getTablero(), false);

            JOptionPane.showMessageDialog(null, "Turno de " + actual.getNombre() +
                    "\n\nTu tablero:\n" + tableroPropio +
                    "\n\nTablero enemigo:\n" + tableroEnemigo);

            actual.disparar(oponente);

            if (!oponente.getTablero().quedanBarcos()) {
                JOptionPane.showMessageDialog(null, "¡" + actual.getNombre() + " ha ganado!");
                juegoEnCurso = false;
            } else {
                // Cambiar turnos
                Jugador temp = actual;
                actual = oponente;
                oponente = temp;
            }
        }

        JOptionPane.showMessageDialog(null, "Juego terminado. ¡Gracias por jugar!");
    }

    private static void colocarBarcosIniciales(Jugador jugador) {
        int[] tamaños = {5, 4, 3, 3, 2};

        for (int tamaño : tamaños) {
            boolean colocado = false;
            while (!colocado) {
                String entrada = JOptionPane.showInputDialog(null,
                        jugador.getNombre() + " - Coordenada inicial para barco de tamaño " + tamaño + " (Ejemplo: B4):");
                entrada = entrada.toUpperCase();

                int columna = entrada.charAt(0) - 'A';
                int fila = Integer.parseInt(entrada.substring(1)) - 1;

                int orientacion = JOptionPane.showConfirmDialog(null, "¿Horizontal?", "Orientación",
                        JOptionPane.YES_NO_OPTION);
                boolean horizontal = (orientacion == JOptionPane.YES_OPTION);

                Barco barco = new Barco(tamaño);
                colocado = jugador.getTablero().colocarBarco(barco, fila, columna, horizontal);

                if (!colocado) {
                    JOptionPane.showMessageDialog(null, "No se pudo colocar el barco. Intenta de nuevo.");
                } else {
                    String tablero = obtenerTableroComoString(jugador.getTablero(), true);
                    JOptionPane.showMessageDialog(null, "Tablero actualizado:\n" + tablero);
                }
            }
        }
    }

    private static void colocarBarcosIA(JugadorIA jugadorIA) {
        JOptionPane.showMessageDialog(null, "La computadora está colocando sus barcos...");

        Random random = new Random();
        int[] tamaños = {5, 4, 3, 3, 2};

        for (int tamaño : tamaños) {
            boolean colocado = false;
            while (!colocado) {
                int fila = random.nextInt(10);
                int columna = random.nextInt(10);
                boolean horizontal = random.nextBoolean();

                Barco barco = new Barco(tamaño);
                colocado = jugadorIA.getTablero().colocarBarco(barco, fila, columna, horizontal);
            }
        }

        JOptionPane.showMessageDialog(null, "¡La computadora ha colocado sus barcos!");
    }

    private static String obtenerTableroComoString(Tablero tablero, boolean mostrarBarcos) {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int i = 0; i < 10; i++) {
            sb.append((char) ('A' + i)).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < 10; i++) {
            sb.append(String.format("%2d", i + 1));
            for (int j = 0; j < 10; j++) {
                char c = tablero.getCelda(i, j);
                if (c == 'B' && !mostrarBarcos) {
                    sb.append(" ~");
                } else {
                    sb.append(" ").append(c);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
