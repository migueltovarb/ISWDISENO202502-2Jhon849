package com.hotel.controller;

import com.hotel.models.Usuario;
import com.hotel.security.JwtUtil;
import com.hotel.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario u) {
        return service.registrar(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario u) {

        Usuario user = service.login(u.getUsername(), u.getPassword());
        if (user == null)
            return "CREDENCIALES_INVALIDAS";

        return jwtUtil.generarToken(user.getUsername(), user.getRol());
    }
}

