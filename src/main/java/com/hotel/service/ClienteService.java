package com.hotel.service;

import com.hotel.models.Cliente;
import com.hotel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente crear(Cliente c) {
        return repo.save(c);
    }

    public Cliente actualizar(String id, Cliente datos) {
        Cliente c = repo.findById(id).orElseThrow();
        c.setNombre(datos.getNombre());
        c.setApellido(datos.getApellido());
        c.setCorreo(datos.getCorreo());
        c.setTelefono(datos.getTelefono());
        return repo.save(c);
    }

    public Cliente obtener(String id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }
}
