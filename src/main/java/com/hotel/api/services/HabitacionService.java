package com.hotel.api.services;

import com.hotel.api.models.Habitacion;
import com.hotel.api.models.Reserva;
import com.hotel.api.repository.HabitacionRepository;
import com.hotel.api.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepo;
    private final ReservaRepository reservaRepo;

    public HabitacionService(HabitacionRepository habitacionRepo, ReservaRepository reservaRepo) {
        this.habitacionRepo = habitacionRepo;
        this.reservaRepo = reservaRepo;
    }

    // ============================================================
    //   DISPONIBILIDAD
    // ============================================================
    public List<Habitacion> obtenerDisponibles(LocalDate entrada, LocalDate salida) {

        List<Habitacion> habitaciones = habitacionRepo.findAll();
        List<Reserva> reservas = reservaRepo.findAll();

        return habitaciones.stream()
                .filter(h -> estaDisponible(h, reservas, entrada, salida))
                .toList();
    }

    private boolean estaDisponible(Habitacion h, List<Reserva> reservas,
                                   LocalDate entrada, LocalDate salida) {

        for (Reserva r : reservas) {

            // Si el tipo no coincide → ignorar
            if (!r.getTipo().equalsIgnoreCase(h.getTipo())) continue;

            // Si hay fechas nulas → ignorar
            if (r.getEntrada() == null || r.getSalida() == null ||
                r.getEntrada().isEmpty() || r.getSalida().isEmpty()) {
                continue;
            }

            LocalDate rEntrada = LocalDate.parse(r.getEntrada());
            LocalDate rSalida = LocalDate.parse(r.getSalida());

            // Si se solapan las fechas, la habitación NO está disponible
            boolean seSolapan =
                    !(salida.isBefore(rEntrada) || entrada.isAfter(rSalida));

            if (seSolapan) return false;
        }
        return true;
    }


    // ============================================================
    //   CRUD COMPLETO
    // ============================================================

    public List<Habitacion> listar() {
        return habitacionRepo.findAll();
    }

    public Optional<Habitacion> obtener(String id) {
        return habitacionRepo.findById(id);
    }

    public Habitacion crear(Habitacion h) {
        return habitacionRepo.save(h);
    }

    public Habitacion editar(String id, Habitacion h) {
        Habitacion existe = habitacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        existe.setTipo(h.getTipo());
        existe.setPrecio(h.getPrecio());
        existe.setOcupada(h.isOcupada());

        return habitacionRepo.save(existe);
    }

    public void eliminar(String id) {
        habitacionRepo.deleteById(id);
    }
}
