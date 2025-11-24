package com.hotel.api.repository;

import com.hotel.api.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Usuario findByUsername(String username);

    
}

