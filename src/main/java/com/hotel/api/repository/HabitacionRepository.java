package com.hotel.api.repository;

import com.hotel.api.models.Habitacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    // Repositorio básico para CRUD de habitaciones
}
