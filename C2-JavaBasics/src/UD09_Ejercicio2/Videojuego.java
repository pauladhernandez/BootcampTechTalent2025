package UD09_Ejercicio2;

public class Videojuego implements Entregable {

    private static final int HORAS_ESTIMADAS_DEFECTO = 10;
    private static final boolean ENTREGADO_DEFECTO = false;

    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compania;

    public Videojuego() {
        this.titulo = "";
        this.horasEstimadas = HORAS_ESTIMADAS_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.compania = "";
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.compania = "";
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.compania = compania;
        this.entregado = ENTREGADO_DEFECTO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
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
        Videojuego otro = (Videojuego) a;
        return Integer.compare(this.horasEstimadas, otro.getHorasEstimadas());
    }

    @Override
    public String toString() {
        return "Videojuego {" +
                "Título = " + titulo +
                ", Horas Estimadas = " + horasEstimadas +
                ", Entregado = " + entregado +
                ", Género = " + genero +
                ", Compañía = " + compania +
                '}';
    }
}
