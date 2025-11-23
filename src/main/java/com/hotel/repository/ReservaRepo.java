package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Reserva;

public interface ReservaRepo extends MongoRepository<Reserva, String> {}
