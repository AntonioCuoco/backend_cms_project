package com.example.backend.controllerNuovo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.CategoryDto;
import com.example.backend.dto.ImageDto;
import com.example.backend.dto.SearchItem;
import com.example.backend.dto.TopicDto;
import com.example.backend.dto.UserDto;
import com.example.backend.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cms")
public class Controller {
	
	@Autowired
	private UserService service;

	
	@PostMapping("/postArticle")
	public void postArticle(@RequestBody UserDto user) throws IOException {
		service.saveArticle(user);
	}
	
	@GetMapping("/getArticle")
	public List<UserDto> getAllArticle() {
		return  service.getArticle();
	}
	
	@PostMapping("/postCategory")
	public void postCategory(@RequestBody CategoryDto categoryDto) {
		service.saveCategory(categoryDto);
	}
	
	@GetMapping("/getCategory")
	public List<CategoryDto> getAllCategory() {
		return  service.getAllCategory();
	}
	
	@PostMapping("/postTopic")
	public void postTopic(@RequestBody TopicDto topicDto) {
		service.saveTopic(topicDto);
	}
	
	@GetMapping("/getTopic")
	public List<TopicDto> getAllTopic() {
		return service.getAllTopic();
	}
	
	@PostMapping("/retrieveArticleByName")
	public List<UserDto> retrieveAllArticleByName(@RequestBody String search) {
		return service.retrieveAllArticleByName(search);
	}
	
	@PostMapping("/retrieveArticleByTitle")
	public UserDto retrieveArticleByTitle(@RequestBody String search) {
		return service.retrieveArticleByName(search);
	}
}
