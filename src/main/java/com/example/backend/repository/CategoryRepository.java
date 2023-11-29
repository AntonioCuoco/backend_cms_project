package com.example.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
	
}