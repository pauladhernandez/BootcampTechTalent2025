package UD09_Ejercicio2;

public class App {
    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        series[1] = new Serie("Friends", 10, "Comedia", "David Crane");
        series[2] = new Serie("Stranger Things", "Hermanos Duffer");
        series[3] = new Serie();
        series[4] = new Serie("Dark", 3, "Ciencia Ficción", "Baran bo Odar");

        videojuegos[0] = new Videojuego("The Witcher 3", 50, "RPG", "CD Projekt");
        videojuegos[1] = new Videojuego("Minecraft", 100, "Sandbox", "Mojang");
        videojuegos[2] = new Videojuego("FIFA 21", 30);
        videojuegos[3] = new Videojuego();
        videojuegos[4] = new Videojuego("GTA V", 60, "Acción", "Rockstar");

        // Entregar algunos
        series[1].entregar();
        series[4].entregar();
        videojuegos[0].entregar();
        videojuegos[4].entregar();
        videojuegos[2].entregar();

        // Contar entregados y devolverlos
        int seriesEntregadas = 0;
        int videojuegosEntregados = 0;

        for (Serie s : series) {
            if (s.isEntregado()) {
                seriesEntregadas++;
                s.devolver();
            }
        }

        for (Videojuego v : videojuegos) {
            if (v.isEntregado()) {
                videojuegosEntregados++;
                v.devolver();
            }
        }

        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);

        // Buscar Serie con más temporadas y Videojuego con más horas
        Serie serieMayor = series[0];
        for (int i = 1; i < series.length; i++) {
            if (series[i].compareTo(serieMayor) > 0) {
                serieMayor = series[i];
            }
        }

        Videojuego videojuegoMayor = videojuegos[0];
        for (int i = 1; i < videojuegos.length; i++) {
            if (videojuegos[i].compareTo(videojuegoMayor) > 0) {
                videojuegoMayor = videojuegos[i];
            }
        }

        System.out.println("\nSerie con más temporadas:\n" + serieMayor);
        System.out.println("\nVideojuego con más horas estimadas:\n" + videojuegoMayor);
    }
}
