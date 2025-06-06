package Juego_Grupal;

import javax.swing.JOptionPane;
import java.util.Random;

public class JugadorIA extends Jugador {
    private Random random;

    public JugadorIA(String nombre) {
        super(nombre);
        random = new Random();
    }

    @Override
    public void disparar(Jugador oponente) {
        int fila = random.nextInt(10);
        int columna = random.nextInt(10);

        JOptionPane.showMessageDialog(null,
                getNombre() + " dispara a " + (char)('A' + columna) + (fila + 1));

        boolean acierto = oponente.getTablero().recibirDisparo(fila, columna);

        if (acierto) {
            JOptionPane.showMessageDialog(null, "¡IA acertó!");
        } else {
            JOptionPane.showMessageDialog(null, "IA falló.");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

