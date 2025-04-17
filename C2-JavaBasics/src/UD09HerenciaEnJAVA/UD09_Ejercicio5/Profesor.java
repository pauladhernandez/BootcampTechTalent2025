package UD09HerenciaEnJAVA.UD09_Ejercicio5;

public class Profesor extends Persona {
 private String materia;

 public Profesor(String nombre, int edad, char sexo, String materia) {
     super(nombre, edad, sexo);
     this.materia = materia;
 }

 public boolean estaDisponible() {
     return Math.random() > 0.2; // 80% de probabilidad de estar disponible
 }

 public String getMateria() {
     return materia;
 }
}
