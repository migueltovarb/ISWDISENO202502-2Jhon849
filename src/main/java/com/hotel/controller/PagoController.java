package com.hotel.controller;

import com.hotel.models.Pago;
import com.hotel.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin("*")
public class PagoController {

    @Autowired
    private PagoService service;

    @PostMapping
    public Pago pagar(@RequestBody Pago p) {
        return service.registrar(p);
    }
}
