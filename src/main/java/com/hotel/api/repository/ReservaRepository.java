package com.hotel.api.repository;

import com.hotel.api.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    // Buscar reservas por tipo de habitación (simple, doble, suite)
    List<Reserva> findByTipo(String tipo);
}
