package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Pago;

public interface PagoRepository extends MongoRepository<Pago, String> {
}
