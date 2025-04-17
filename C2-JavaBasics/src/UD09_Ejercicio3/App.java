package UD09_Ejercicio3;

public class App {
    public static void main(String[] args) {
        // Crear dos objetos Libro
        Libro libro1 = new Libro("978-3-16-148410-0", "Cien Años de Soledad", "Gabriel García Márquez", 417);
        Libro libro2 = new Libro("978-0-123-45678-9", "1984", "George Orwell", 328);

        // Mostrar información de los libros
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());

        // Comparar cuál tiene más páginas
        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            System.out.println("El libro \"" + libro1.getTitulo() + "\" tiene más páginas.");
        } else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
            System.out.println("El libro \"" + libro2.getTitulo() + "\" tiene más páginas.");
        } else {
            System.out.println("Ambos libros tienen la misma cantidad de páginas.");
        }
    }
}
