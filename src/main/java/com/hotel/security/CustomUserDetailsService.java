package com.hotel.security;

import com.hotel.models.Usuario;
import com.hotel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByUsername(username);
        if (u == null)
            throw new UsernameNotFoundException("Usuario no encontrado");

        return new CustomUserDetails(u);
    }
}
