package com.hotel.dto;

public class HabitacionDTO {

    private String nombre;
    private String tipo;
    private boolean disponible;

    public HabitacionDTO(String nombre, String tipo, boolean disponible) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.disponible = disponible;
}


    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public boolean isDisponible() { return disponible; }
}

