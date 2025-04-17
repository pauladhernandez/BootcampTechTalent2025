package UD09HerenciaEnJAVA.UD09_Ejercicio1;

public class Ejercicio01_UD09 {

    public static void main(String[] args) {
        // Crear un array de Electrodomesticos con 10 posiciones
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        // Asignar valores a cada posición del array
        electrodomesticos[0] = new Electrodomestico(200, 30, "rojo", 'A');
        electrodomesticos[1] = new Lavadora(150, 25, "blanco", 'B', 40);
        electrodomesticos[2] = new Television(500, 10, "negro", 'C', 50, true);
        electrodomesticos[3] = new Electrodomestico(300, 80, "gris", 'D');
        electrodomesticos[4] = new Lavadora(100, 15, "azul", 'E', 20);
        electrodomesticos[5] = new Television(700, 20, "rojo", 'F', 60, false);
        electrodomesticos[6] = new Electrodomestico(150, 12, "blanco", 'B');
        electrodomesticos[7] = new Lavadora(250, 50, "negro", 'A', 35);
        electrodomesticos[8] = new Television(300, 18, "azul", 'C', 25, true);
        electrodomesticos[9] = new Electrodomestico(400, 70, "gris", 'D');

        // Variables para almacenar los precios totales
        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisores = 0;

        // Recorrer el array y calcular los precios finales
        for (Electrodomestico e : electrodomesticos) {
            double precioFinal = e.precioFinal();
            totalElectrodomesticos += precioFinal;

            if (e instanceof Lavadora) {
                totalLavadoras += precioFinal;
            } else if (e instanceof Television) {
                totalTelevisores += precioFinal;
            }
        }

        // Mostrar los resultados
        System.out.println("Precio total de Electrodomésticos: " + totalElectrodomesticos + " €");
        System.out.println("Precio total de Lavadoras: " + totalLavadoras + " €");
        System.out.println("Precio total de Televisores: " + totalTelevisores + " €");
    }
}
