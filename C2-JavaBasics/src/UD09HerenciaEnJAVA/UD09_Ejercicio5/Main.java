package UD09HerenciaEnJAVA.UD09_Ejercicio5;

public class Main {
 public static void main(String[] args) {
     Profesor profesor = new Profesor("Carlos Pérez", 40, 'M', "Matematicas");
     Aula aula = new Aula(1, 10, "Matematicas", profesor);

     for (int i = 0; i < 10; i++) {
         String nombre = "Estudiante" + (i + 1);
         int edad = 18 + (int)(Math.random() * 5);
         char sexo = Math.random() > 0.5 ? 'M' : 'F';
         double nota = Math.round((Math.random() * 10) * 100.0) / 100.0;
         Estudiante est = new Estudiante(nombre, edad, sexo, nota);
         aula.agregarEstudiante(est);
     }

     if (aula.sePuedeDarClase()) {
         System.out.println("La clase se puede dar.");
         aula.mostrarAprobados();
     } else {
         System.out.println("No se puede dar clase.");
     }
 }
}

