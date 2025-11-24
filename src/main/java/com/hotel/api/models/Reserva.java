package com.hotel.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;

    private String nombre;   // nombre del cliente
    private String tipo;     // tipo de habitación reservada
    private String entrada;  // fecha entrada: yyyy-MM-dd
    private String salida;   // fecha salida: yyyy-MM-dd
    private String estado;   // pendiente | checkin | checkout

    public Reserva() {
    }

    public Reserva(String nombre, String tipo, String entrada, String salida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.entrada = entrada;
        this.salida = salida;
        this.estado = "pendiente"; // estado inicial
    }

    // =========================
    //   GETTERS Y SETTERS
    // =========================

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntrada() {
        return entrada;
    }
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }
    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}

