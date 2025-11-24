package com.hotel.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.api.models.Room;

public interface RoomRepository extends MongoRepository<Room, String> {

}
