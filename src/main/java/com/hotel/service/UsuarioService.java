package com.hotel.service;

import com.hotel.models.Usuario;
import com.hotel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario registrar(Usuario u) {
        return repo.save(u);
    }

    public Usuario login(String username, String password) {
        Usuario user = repo.findByUsername(username);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        return user;
    }
}
