package com.hotel.controller;

import com.hotel.models.CheckIn;
import com.hotel.models.CheckOut;
import com.hotel.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/check")
@CrossOrigin("*")
public class CheckController {

    @Autowired
    private CheckService service;

    @PutMapping("/{idReserva}/in")
    public CheckIn checkIn(@PathVariable String idReserva) {
        return service.hacerCheckIn(idReserva);
    }

    @PutMapping("/{idReserva}/out")
    public CheckOut checkOut(@PathVariable String idReserva) {
        return service.hacerCheckOut(idReserva);
    }
}
