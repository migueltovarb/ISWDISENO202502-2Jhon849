package com.hotel.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.api.models.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
