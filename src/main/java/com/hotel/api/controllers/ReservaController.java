package com.hotel.api.controllers;

import com.hotel.api.models.Reserva;
import com.hotel.api.services.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // 🔹 Crear reserva
    @PostMapping
    public Reserva crear(@RequestBody Reserva r) {
        return service.crearReserva(r);
    }

    // 🔹 Listar todas las reservas
    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    // 🔹 Obtener una reserva por ID
    @GetMapping("/{id}")
    public Reserva obtener(@PathVariable String id) {
        return service.obtener(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // 🔹 Check-in
    @PutMapping("/{id}/checkin")
    public String checkIn(@PathVariable String id) {
        service.checkIn(id);
        return "Check-in realizado correctamente.";
    }

    // 🔹 Check-out
    @PutMapping("/{id}/checkout")
    public String checkOut(@PathVariable String id) {
        service.checkOut(id);
        return "Check-out realizado correctamente.";
    }

    // 🔹 Eliminar reserva
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "Reserva eliminada correctamente.";
    }
}
