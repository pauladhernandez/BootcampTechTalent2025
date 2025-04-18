package UD08POO.UD08POO_Tareas;

public class Serie {

	private static final int NUMERO_TEMPORADAS_POR_DEFECTO = 3;
	private static final boolean ENTREGADO_DEFECTO = false;

	private String titulo;
	private int numeroTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	// Constructor por defecto
    public Serie() {
        this.titulo = "";
        this.numeroTemporadas = NUMERO_TEMPORADAS_POR_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.creador = "";
    }

    // Constructor con título y creador
    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        this.numeroTemporadas = NUMERO_TEMPORADAS_POR_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
    }

    // Constructor con todos los atributos excepto 'entregado'
    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.genero = genero;
        this.creador = creador;
        this.entregado = ENTREGADO_DEFECTO;
    }

    // Getters y Setters 
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

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
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
}

