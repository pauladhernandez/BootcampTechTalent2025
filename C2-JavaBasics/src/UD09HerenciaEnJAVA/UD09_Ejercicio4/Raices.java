package UD09HerenciaEnJAVA.UD09_Ejercicio4;

public class Raices {
    private double a;
    private double b;
    private double c;

    // Constructor
    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método para obtener el discriminante
    public double getDiscriminante() {
        return (b * b) - (4 * a * c);
    }

    // Método para saber si tiene dos raíces
    public boolean tieneRaices() {
        return getDiscriminante() > 0;
    }

    // Método para saber si tiene una raíz
    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    // Método para obtener las dos raíces
    public void obtenerRaices() {
        if (tieneRaices()) {
            double discriminante = getDiscriminante();
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Raíz 1: " + raiz1);
            System.out.println("Raíz 2: " + raiz2);
        }
    }

    // Método para obtener una única raíz
    public void obtenerRaiz() {
        if (tieneRaiz()) {
            double raiz = -b / (2 * a);
            System.out.println("Única raíz: " + raiz);
        }
    }

    // Método general que calcula y muestra las soluciones
    public void calcular() {
        if (tieneRaices()) {
            obtenerRaices();
        } else if (tieneRaiz()) {
            obtenerRaiz();
        } else {
            System.out.println("No existen soluciones reales.");
        }
    }
}
