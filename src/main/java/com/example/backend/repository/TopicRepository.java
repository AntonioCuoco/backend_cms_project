package com.example.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.Topic;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String>{
	
}