package Juego_Grupal;

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
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tablero[i][j] = '~';
            }
        }
    }

    public boolean colocarBarco(Barco barco, int fila, int columna, boolean horizontal) {
        if (puedeColocar(barco, fila, columna, horizontal)) {
            barco.setOrientacion(horizontal);
            barco.setPosicion(fila, columna);

            for (int i = 0; i < barco.getTamaño(); i++) {
                if (horizontal) {
                    tablero[fila][columna + i] = 'B';
                } else {
                    tablero[fila + i][columna] = 'B';
                }
            }

            barcos.add(barco);
            return true;
        }
        return false;
    }

    private boolean puedeColocar(Barco barco, int fila, int columna, boolean horizontal) {
        if (horizontal) {
            if (columna + barco.getTamaño() > TAM) return false;
            for (int i = 0; i < barco.getTamaño(); i++) {
                if (tablero[fila][columna + i] != '~') return false;
            }
        } else {
            if (fila + barco.getTamaño() > TAM) return false;
            for (int i = 0; i < barco.getTamaño(); i++) {
                if (tablero[fila + i][columna] != '~') return false;
            }
        }
        return true;
    }

    public boolean recibirDisparo(int fila, int columna) {
        char celda = tablero[fila][columna];

        if (celda == 'B') {
            tablero[fila][columna] = 'X';
            for (Barco barco : barcos) {
                if (estaEnBarco(barco, fila, columna)) {
                    barco.recibirImpacto();
                    if (barco.estaHundido()) {
                        return true;
                    }
                    break;
                }
            }
            return true;
        } else if (celda == '~') {
            tablero[fila][columna] = 'O';
            return false;
        } else {
            return false;
        }
    }

    private boolean estaEnBarco(Barco barco, int fila, int columna) {
        int f = barco.getFila();
        int c = barco.getColumna();
        if (barco.esHorizontal()) {
            return (fila == f && columna >= c && columna < c + barco.getTamaño());
        } else {
            return (columna == c && fila >= f && fila < f + barco.getTamaño());
        }
    }

    public boolean quedanBarcos() {
        for (Barco barco : barcos) {
            if (!barco.estaHundido()) {
                return true;
            }
        }
        return false;
    }

    public char getCelda(int fila, int columna) {
        return tablero[fila][columna];
    }
}


