package com.hotel.controller;

import com.hotel.models.Cliente;
import com.hotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente c) {
        return service.crear(c);
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable String id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable String id, @RequestBody Cliente datos) {
        return service.actualizar(id, datos);
    }
}
