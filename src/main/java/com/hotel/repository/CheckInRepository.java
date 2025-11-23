package com.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.models.CheckIn;

public interface CheckInRepository extends MongoRepository<CheckIn, String> {
}
