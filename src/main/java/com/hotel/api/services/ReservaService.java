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
public class ReservaService {

    private final ReservaRepository reservaRepo;
    private final HabitacionRepository habitacionRepo;

    public ReservaService(ReservaRepository reservaRepo, HabitacionRepository habitacionRepo) {
        this.reservaRepo = reservaRepo;
        this.habitacionRepo = habitacionRepo;
    }

    // ============================================================
    //   CREAR RESERVA (con validación completa)
    // ============================================================
    public Reserva crearReserva(Reserva reserva) {

        // 1. Validar que el tipo de habitación exista
        boolean tipoExiste = habitacionRepo.findAll().stream()
                .anyMatch(h -> h.getTipo().equalsIgnoreCase(reserva.getTipo()));

        if (!tipoExiste) {
            throw new IllegalArgumentException("El tipo de habitación no existe.");
        }

        // 2. Validar fechas correctas
        if (reserva.getEntrada() == null || reserva.getSalida() == null ||
            reserva.getEntrada().isEmpty() || reserva.getSalida().isEmpty()) {
            throw new IllegalArgumentException("Las fechas de entrada y salida son obligatorias.");
        }

        LocalDate entrada = LocalDate.parse(reserva.getEntrada());
        LocalDate salida = LocalDate.parse(reserva.getSalida());

        if (!salida.isAfter(entrada)) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la de entrada.");
        }

        // 3. Validar disponibilidad en ese tipo de habitación
        List<Reserva> reservasExistentes = reservaRepo.findByTipo(reserva.getTipo());

        for (Reserva r : reservasExistentes) {

            if (r.getEntrada() == null || r.getSalida() == null) continue;

            LocalDate rEntrada = LocalDate.parse(r.getEntrada());
            LocalDate rSalida = LocalDate.parse(r.getSalida());

            boolean seSolapan =
                    !(salida.isBefore(rEntrada) || entrada.isAfter(rSalida));

            if (seSolapan) {
                throw new IllegalStateException("No hay habitaciones disponibles en ese rango de fechas.");
            }
        }

        // 4. Crear reserva
        reserva.setEstado("pendiente");
        return reservaRepo.save(reserva);
    }

    // ============================================================
    //   OBTENER RESERVA
    // ============================================================
    public Optional<Reserva> obtener(String id) {
        return reservaRepo.findById(id);
    }

    // ============================================================
    //   LISTAR TODAS LAS RESERVAS
    // ============================================================
    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }

    // ============================================================
    //   CHECK-IN
    // ============================================================
    public Reserva checkIn(String id) {
        Reserva r = reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        r.setEstado("checkin");
        return reservaRepo.save(r);
    }

    // ============================================================
    //   CHECK-OUT
    // ============================================================
    public Reserva checkOut(String id) {
        Reserva r = reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        r.setEstado("checkout");
        return reservaRepo.save(r);
    }

    // ============================================================
    //   ELIMINAR RESERVA
    // ============================================================
    public void eliminar(String id) {
        if (!reservaRepo.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepo.deleteById(id);
    }
}
