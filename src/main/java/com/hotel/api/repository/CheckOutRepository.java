package com.hotel.api.repository;

import com.hotel.api.models.CheckOut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutRepository extends MongoRepository<CheckOut, String> {
}
