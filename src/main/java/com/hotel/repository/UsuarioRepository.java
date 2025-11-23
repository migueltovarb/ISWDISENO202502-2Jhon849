package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Usuario findByUsername(String username);
}
