package com.example.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.Image;

@Repository
public interface UploadRepository extends MongoRepository<Image, String> {

}
