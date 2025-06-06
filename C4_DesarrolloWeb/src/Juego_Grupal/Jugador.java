package Juego_Grupal;


import javax.swing.JOptionPane;

public class Jugador {
    private String nombre;
    private Tablero tablero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void disparar(Jugador oponente) {
        String entrada = JOptionPane.showInputDialog(null,
                nombre + " - Coordenada para disparar (Ejemplo: B5):");

        entrada = entrada.toUpperCase();

        int columna = entrada.charAt(0) - 'A';
        int fila = Integer.parseInt(entrada.substring(1)) - 1;

        boolean acierto = oponente.getTablero().recibirDisparo(fila, columna);

        if (acierto) {
            JOptionPane.showMessageDialog(null, "¡Tocado!");
        } else {
            JOptionPane.showMessageDialog(null, "Agua...");
        }
    }
}
