package com.hotel.service;

import com.hotel.models.CheckIn;
import com.hotel.models.CheckOut;
import com.hotel.models.Reserva;
import com.hotel.repository.CheckInRepository;
import com.hotel.repository.CheckOutRepository;
import com.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CheckService {

    @Autowired
    private ReservaRepository reservaRepo;

    @Autowired
    private CheckInRepository checkInRepo;

    @Autowired
    private CheckOutRepository checkOutRepo;

    public CheckIn hacerCheckIn(String idReserva) {

        Reserva r = reservaRepo.findById(idReserva).orElseThrow();
        r.setCheckIn(true);
        reservaRepo.save(r);

        CheckIn in = new CheckIn();
        in.setIdReserva(idReserva);
        in.setFecha(LocalDate.now());

        return checkInRepo.save(in);
    }

    public CheckOut hacerCheckOut(String idReserva) {

        Reserva r = reservaRepo.findById(idReserva).orElseThrow();
        r.setCheckOut(true);
        reservaRepo.save(r);

        CheckOut out = new CheckOut();
        out.setIdReserva(idReserva);
        out.setFecha(LocalDate.now());

        return checkOutRepo.save(out);
    }
}
