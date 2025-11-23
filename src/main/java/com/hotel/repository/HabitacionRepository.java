package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Habitacion;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {

    List<Habitacion> findByEstado(String estado);

    List<Habitacion> findByTipo(String tipo);
}
