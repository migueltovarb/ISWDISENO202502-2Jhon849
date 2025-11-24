package com.hotel.api.controllers;

import com.hotel.api.models.Habitacion;
import com.hotel.api.services.HabitacionService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin(origins = "*")
public class HabitacionController {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    // 🔹 Disponibilidad por fecha
    @GetMapping("/disponibilidad")
    public List<Habitacion> disponibilidad(
            @RequestParam String entrada,
            @RequestParam String salida
    ) {
        LocalDate fechaEntrada = LocalDate.parse(entrada);
        LocalDate fechaSalida = LocalDate.parse(salida);
        return service.obtenerDisponibles(fechaEntrada, fechaSalida);
    }

    // 🔹 Listar todas las habitaciones
    @GetMapping
    public List<Habitacion> listar() {
        return service.listar();
    }

    // 🔹 Obtener una habitación por ID
    @GetMapping("/{id}")
    public Habitacion obtener(@PathVariable String id) {
        return service.obtener(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
    }

    // 🔹 Crear habitación
    @PostMapping
    public Habitacion crear(@RequestBody Habitacion h) {
        return service.crear(h);
    }

    // 🔹 Editar habitación
    @PutMapping("/{id}")
    public Habitacion editar(@PathVariable String id, @RequestBody Habitacion h) {
        return service.editar(id, h);
    }

    // 🔹 Eliminar habitación
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "Habitación eliminada correctamente";
    }
}

