package com.example.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	List<User> findByTitleArticleContainingIgnoreCase(String searchString);
	User findByTitleArticleIgnoreCase(String searchString);
	@Query("{'titleArticle': { $regex: ?0, $options: 'i' }}")
    User findByParolaContenutaIgnorandoSpazi(String searchString);
}
