package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    List<Reserva> findByIdCliente(String idCliente);

    List<Reserva> findByIdHabitacion(String idHabitacion);

    List<Reserva> findByIdHabitacionAndFechaIngresoLessThanEqualAndFechaSalidaGreaterThanEqual(
            String idHabitacion,
            LocalDate salida,
            LocalDate ingreso
    );
}

