package Juego_Grupal;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private final int TAM = 10;
    private char[][] tablero;
    private List<Barco> barcos;

    public Tablero() {
        tablero = new char[TAM][TAM];
        barcos = new ArrayList<>();
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++)
                tablero[i][j] = '~';
    }

    public boolean colocarBarco(Barco barco, int fila, int columna, boolean horizontal) {
        if (!puedeColocar(barco, fila, columna, horizontal)) return false;
        barco.setOrientacion(horizontal);
        barco.setPosicion(fila, columna);
        for (int i = 0; i < barco.getTamaño(); i++) {
            if (horizontal) tablero[fila][columna + i] = 'B';
            else          tablero[fila + i][columna] = 'B';
        }
        barcos.add(barco);
        return true;
    }

    private boolean puedeColocar(Barco barco, int fila, int columna, boolean horizontal) {
        if (horizontal) {
            if (columna + barco.getTamaño() > TAM) return false;
            for (int i = 0; i < barco.getTamaño(); i++)
                if (tablero[fila][columna + i] != '~') return false;
        } else {
            if (fila + barco.getTamaño() > TAM) return false;
            for (int i = 0; i < barco.getTamaño(); i++)
                if (tablero[fila + i][columna] != '~') return false;
        }
        return true;
    }

    public boolean recibirDisparo(int fila, int columna) {
        char celda = tablero[fila][columna];
        if (celda == 'B') {
            tablero[fila][columna] = 'X';
            for (Barco b : barcos) {
                if (estaEnBarco(b, fila, columna)) {
                    b.recibirImpacto();
                    break;
                }
            }
            return true;
        } else if (celda == '~') {
            tablero[fila][columna] = 'O';
            return false;
        } else {
            return false; // ya disparado aquí
        }
    }

    private boolean estaEnBarco(Barco b, int fila, int columna) {
        int f = b.getFila(), c = b.getColumna();
        if (b.esHorizontal()) {
            return (fila == f && columna >= c && columna < c + b.getTamaño());
        } else {
            return (columna == c && fila >= f && fila < f + b.getTamaño());
        }
    }

    public boolean quedanBarcos() {
        for (Barco b : barcos)
            if (!b.estaHundido()) return true;
        return false;
    }

    public char getCelda(int fila, int columna) {
        return tablero[fila][columna];
    }

    /** Devuelve las coordenadas del barco recién hundido (no marcado aún). */
    public List<Point> getLastSunkCoordinates() {
        List<Point> sunk = new ArrayList<>();
        for (Barco b : barcos) {
            if (b.estaHundido() && !b.isMarkedSunk()) {
                int f = b.getFila(), c = b.getColumna();
                for (int i = 0; i < b.getTamaño(); i++) {
                    sunk.add(new Point(
                        f + (b.esHorizontal() ? 0 : i),
                        c + (b.esHorizontal() ? i : 0)
                    ));
                }
                b.setMarkedSunk(true);
                break;
            }
        }
        return sunk;
    }
}
