package com.hotel.service;

import com.hotel.models.Habitacion;
import com.hotel.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository repo;

    public List<Habitacion> listar() {
        return repo.findAll();
    }

    public Habitacion obtener(String id) {
        return repo.findById(id).orElseThrow();
    }

    public Habitacion crear(Habitacion h) {
        return repo.save(h);
    }

    public Habitacion actualizarEstado(String id, String estado) {
        Habitacion h = obtener(id);
        h.setEstado(estado);
        return repo.save(h);
    }

    public List<Habitacion> disponibles() {
        return repo.findByEstado("disponible");
    }
}
