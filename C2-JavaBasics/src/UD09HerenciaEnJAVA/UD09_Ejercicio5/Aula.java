package UD09HerenciaEnJAVA.UD09_Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Aula {
 private int id;
 private int maxEstudiantes;
 private String materiaDestinada;
 private Profesor profesor;
 private List<Estudiante> estudiantes;

 public Aula(int id, int maxEstudiantes, String materiaDestinada, Profesor profesor) {
     this.id = id;
     this.maxEstudiantes = maxEstudiantes;
     this.materiaDestinada = materiaDestinada;
     this.profesor = profesor;
     this.estudiantes = new ArrayList<>();
 }

 public void agregarEstudiante(Estudiante estudiante) {
     if (estudiantes.size() < maxEstudiantes) {
         estudiantes.add(estudiante);
     }
 }

 public boolean sePuedeDarClase() {
     if (!profesor.estaDisponible()) return false;
     if (!profesor.getMateria().equalsIgnoreCase(materiaDestinada)) return false;

     long disponibles = estudiantes.stream().filter(Estudiante::estaDisponible).count();
     return disponibles > (maxEstudiantes / 2);
 }

 public void mostrarAprobados() {
     long aprobadosM = estudiantes.stream()
         .filter(e -> e.estaDisponible() && e.estaAprobado() && e.getSexo() == 'M')
         .count();
     long aprobadosF = estudiantes.stream()
         .filter(e -> e.estaDisponible() && e.estaAprobado() && e.getSexo() == 'F')
         .count();

     System.out.println("Alumnos aprobados: " + aprobadosM);
     System.out.println("Alumnas aprobadas: " + aprobadosF);
 }
}
