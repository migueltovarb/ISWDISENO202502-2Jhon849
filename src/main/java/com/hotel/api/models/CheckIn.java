package com.hotel.api.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "checkins")
public class CheckIn {

    @Id
    private String idCheckIn;

    private Date fecha;
    private String idReserva;
}
