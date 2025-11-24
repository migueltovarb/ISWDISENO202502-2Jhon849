package com.hotel.api.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.hotel.api.models.enums.MetodoPago;
import com.hotel.api.models.enums.EstadoPago;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pagos")
public class Pago {

    @Id
    private String idPago;

    private double monto;
    private Date fechaPago;
    private MetodoPago metodo;
    private EstadoPago estado;

    private String idReserva;
}
