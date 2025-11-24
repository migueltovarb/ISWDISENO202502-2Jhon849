package com.hotel.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "habitaciones")
public class Habitacion {

    @Id
    private String id;

    private String tipo;     // simple, doble, suite
    private double precio;
    private boolean ocupada;

    public Habitacion() {
    }

    public Habitacion(String tipo, double precio, boolean ocupada) {
        this.tipo = tipo;
        this.precio = precio;
        this.ocupada = ocupada;
    }

    // =========================
    //   GETTERS Y SETTERS
    // =========================

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
