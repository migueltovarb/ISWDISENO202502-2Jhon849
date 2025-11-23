package com.hotel.service;

import com.hotel.models.Pago;
import com.hotel.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    private PagoRepository repo;

    public Pago registrar(Pago p) {
        p.setEstado("APROBADO");
        return repo.save(p);
    }
}
