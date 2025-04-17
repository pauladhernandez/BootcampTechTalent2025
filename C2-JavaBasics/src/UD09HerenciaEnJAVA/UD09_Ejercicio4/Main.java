package UD09HerenciaEnJAVA.UD09_Ejercicio4;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Raices con coeficientes
        Raices ecuacion1 = new Raices(1, -3, 2); // Tiene dos soluciones: x=1 y x=2
        Raices ecuacion2 = new Raices(1, 2, 1);  // Tiene una sola solución: x=-1
        Raices ecuacion3 = new Raices(1, 1, 5);  // No tiene soluciones reales

        System.out.println("Ecuación 1:");
        ecuacion1.calcular();

        System.out.println("\nEcuación 2:");
        ecuacion2.calcular();

        System.out.println("\nEcuación 3:");
        ecuacion3.calcular();
    }
}
