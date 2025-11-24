package com.hotel.api.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "checkouts")
public class CheckOut {

    @Id
    private String idCheckOut;

    private Date fecha;
    private String idReserva;
}
