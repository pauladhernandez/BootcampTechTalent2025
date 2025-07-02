package com.videoclub.model;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String dni;

    public Cliente(int id, String nombre, String direccion, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    public Cliente(String nombre, String direccion, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
}