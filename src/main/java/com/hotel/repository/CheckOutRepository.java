package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.CheckOut;

public interface CheckOutRepository extends MongoRepository<CheckOut, String> {
}
