package com.hotel.controller;

import com.hotel.models.Habitacion;
import com.hotel.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin("*")
public class HabitacionController {

    @Autowired
    private HabitacionService service;

    @GetMapping
    public List<Habitacion> listar() { return service.listar(); }

    @PostMapping
    public Habitacion crear(@RequestBody Habitacion h) { return service.crear(h); }

    @GetMapping("/disponibles")
    public List<Habitacion> disponibles() { return service.disponibles(); }

    @PutMapping("/{id}/estado/{estado}")
    public Habitacion actualizarEstado(@PathVariable String id, @PathVariable String estado) {
        return service.actualizarEstado(id, estado);
    }
}

