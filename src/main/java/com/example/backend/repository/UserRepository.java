package com.example.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
