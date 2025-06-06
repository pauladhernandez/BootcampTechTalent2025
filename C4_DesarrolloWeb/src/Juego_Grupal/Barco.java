package Juego_Grupal;

public class Barco {
    private int tamaño;
    private int vidas;
    private boolean horizontal;
    private int fila;
    private int columna;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.vidas = tamaño;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getVidas() {
        return vidas;
    }

    public void recibirImpacto() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public boolean estaHundido() {
        return vidas == 0;
    }

    public boolean esHorizontal() {
        return horizontal;
    }

    public void setOrientacion(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
