package UD09HerenciaEnJAVA.UD09_Ejercicio5;

public class Estudiante extends Persona {
 private double calificacion;

 public Estudiante(String nombre, int edad, char sexo, double calificacion) {
     super(nombre, edad, sexo);
     this.calificacion = calificacion;
 }

 public boolean estaDisponible() {
     return Math.random() > 0.5; // 50% de probabilidad de asistir
 }

 public boolean estaAprobado() {
     return calificacion >= 5;
 }

 public char getSexo() {
     return super.getSexo();
 }
} 
