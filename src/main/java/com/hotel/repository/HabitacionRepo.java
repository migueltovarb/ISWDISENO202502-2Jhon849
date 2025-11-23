package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Habitacion;

public interface HabitacionRepo extends MongoRepository<Habitacion, String> {}
