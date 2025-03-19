package UD07ArraylistyHashtable.UD_07_Tareas;

import java.util.ArrayList;
import java.util.Scanner;

public class t7{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> carrito = new ArrayList<>();

        int numArticulos = obtenerNumeroDeArticulos(scanner);
        añadirArticulosAlCarrito(scanner, carrito, numArticulos);

        double precioTotalBruto = calcularPrecioTotalBruto(carrito);
        double precioConIva = calcularPrecioConIva(scanner, precioTotalBruto);

        mostrarResultados(numArticulos, precioTotalBruto, precioConIva);

        double cantidadPagada = obtenerCantidadPagada(scanner);
        calcularYMostrarCambio(precioConIva, cantidadPagada);

        scanner.close();
    }

    private static int obtenerNumeroDeArticulos(Scanner scanner) {
        System.out.print("Ingrese el número de artículos en el carrito: ");
        return scanner.nextInt();
    }

    private static void añadirArticulosAlCarrito(Scanner scanner, ArrayList<Double> carrito, int numArticulos) {
        for (int i = 0; i < numArticulos; i++) {
            System.out.print("Ingrese el precio del artículo " + (i + 1) + ": ");
            double precio = scanner.nextDouble();
            carrito.add(precio);
        }
    }

    private static double calcularPrecioTotalBruto(ArrayList<Double> carrito) {
        double precioTotalBruto = 0.0;
        for (double precio : carrito) {
            precioTotalBruto += precio;
        }
        return precioTotalBruto;
    }

    private static double calcularPrecioConIva(Scanner scanner, double precioTotalBruto) {
        System.out.println("Introduce tipo iva(21% o 4%): ");
        double Iva = scanner.nextDouble();
        double iva1 = 0.21;
        double iva2 = 0.04;
        double precioConIva;

        if (Iva == 21) {
            precioConIva = precioTotalBruto * (1 + iva1);
            System.out.println("IVA aplicado: " + (iva1 * 100) + "%");
        } else if (Iva == 4) {
            precioConIva = precioTotalBruto * (1 + iva2);
            System.out.println("IVA aplicado: " + (iva2 * 100) + "%");
        } else {
            System.out.println("Tipo de IVA no válido. Se aplicará el IVA del 21% por defecto.");
            precioConIva = precioTotalBruto * (1 + iva1);
            System.out.println("IVA aplicado: " + (iva1 * 100) + "%");
        }
        return precioConIva;
    }

    private static void mostrarResultados(int numArticulos, double precioTotalBruto, double precioConIva) {
        System.out.println("Número de artículos comprados: " + numArticulos);
        System.out.println("Precio total bruto: " + precioTotalBruto + " €");
        System.out.println("Precio total con IVA: " + precioConIva + " €");
    }

    private static double obtenerCantidadPagada(Scanner scanner) {
        System.out.print("Ingrese la cantidad pagada por el cliente: ");
        return scanner.nextDouble();
    }

    private static void calcularYMostrarCambio(double precioConIva, double cantidadPagada) {
        double cambio = cantidadPagada - precioConIva;
        if (cambio < 0) {
            System.out.println("El cliente no ha pagado suficiente. Faltan " + (-cambio) + " €.");
        } else {
            System.out.println("Cambio a devolver: " + cambio + " €");
        }
    }
}
