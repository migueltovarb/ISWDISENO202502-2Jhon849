package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente findByCorreo(String correo);
}
