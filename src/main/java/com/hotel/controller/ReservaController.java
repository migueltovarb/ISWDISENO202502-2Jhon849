package com.hotel.controller;

import com.hotel.models.Reserva;
import com.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin("*")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    @PostMapping
    public Reserva crear(@RequestBody Reserva r) {
        return service.crear(r);
    }

    @GetMapping("/{id}")
    public Reserva obtener(@PathVariable String id) {
        return service.obtener(id);
    }
}
