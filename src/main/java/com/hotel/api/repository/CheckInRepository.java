package com.hotel.api.repository;

import com.hotel.api.models.CheckIn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends MongoRepository<CheckIn, String> {
}
