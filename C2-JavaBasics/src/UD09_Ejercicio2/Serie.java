package UD09_Ejercicio2;

public class Serie implements Entregable {

    private static final int NUMERO_TEMPORADAS_POR_DEFECTO = 3;
    private static final boolean ENTREGADO_DEFECTO = false;

    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public Serie() {
        this.titulo = "";
        this.numeroTemporadas = NUMERO_TEMPORADAS_POR_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.creador = "";
    }

    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        this.numeroTemporadas = NUMERO_TEMPORADAS_POR_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
    }

    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.genero = genero;
        this.creador = creador;
        this.entregado = ENTREGADO_DEFECTO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public void entregar() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public int compareTo(Object a) {
        Serie otra = (Serie) a;
        return Integer.compare(this.numeroTemporadas, otra.getNumeroTemporadas());
    }

    @Override
    public String toString() {
        return "Serie { " +
                "Título = " + titulo + '\'' +
                ", numeroTemporadas = " + numeroTemporadas +
                ", entregado = " + entregado +
                ", genero = " + genero + '\'' +
                ", creador = " + creador + '\'' +
                '}';
    }
}
