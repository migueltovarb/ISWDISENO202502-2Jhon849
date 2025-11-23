package com.hotel.service;

import com.hotel.models.Habitacion;
import com.hotel.models.Reserva;
import com.hotel.repository.HabitacionRepository;
import com.hotel.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repo;

    @Autowired
    private HabitacionRepository habitacionRepo;

    public boolean habitacionDisponible(String idHab, LocalDate ingreso, LocalDate salida) {

        List<Reserva> reservas = repo.findByIdHabitacionAndFechaIngresoLessThanEqualAndFechaSalidaGreaterThanEqual(
                idHab, salida, ingreso
        );

        return reservas.isEmpty();
    }

    public Reserva crear(Reserva r) {

        if (!habitacionDisponible(r.getIdHabitacion(), r.getFechaIngreso(), r.getFechaSalida())) {
            throw new RuntimeException("La habitación NO está disponible en esas fechas.");
        }

        Habitacion hab = habitacionRepo.findById(r.getIdHabitacion()).orElseThrow();
        double precio = hab.getPrecioNoche();

        long dias = r.getFechaSalida().toEpochDay() - r.getFechaIngreso().toEpochDay();

        r.setTotal(precio * dias);
        r.setEstado("CONFIRMADA");

        return repo.save(r);
    }

    public Reserva obtener(String id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Reserva> listar() {
        return repo.findAll();
    }
}
