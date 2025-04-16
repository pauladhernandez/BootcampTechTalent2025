package UD09_Ejercicio2;

public interface Entregable {
    void entregar();
    void devolver();
    boolean isEntregado();
    int compareTo(Object a); // compara temporadas u horas estimadas
}

