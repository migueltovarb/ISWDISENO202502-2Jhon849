package com.hotel.api.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String idCliente;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
}
