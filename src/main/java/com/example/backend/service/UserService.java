package com.example.backend.service;

//import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.example.backend.dto.CategoryDto;
import com.example.backend.dto.ImageDto;
import com.example.backend.dto.SearchItem;
import com.example.backend.dto.TopicDto;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.TopicRepository;
import com.example.backend.repository.UploadRepository;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.Category;
import com.example.backend.entity.Topic;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private UploadRepository uploadRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	GridFsTemplate gridFsTemplate;
	
	public void saveArticle(UserDto userDto) throws IOException {
		User user = modelMapper.map(userDto,User.class);
//		User userAggiornato = saveImage(user);
		userRepository.save(user);
	}
	
//	    byte[] imageBytes   imageBytes
//	public ByteArrayInputStream displayImage(User user) throws IOException {
//		ByteArrayInputStream inputStream = new ByteArrayInputStream(user.getImgCopertina().getBytes());
//		return inputStream;
//	}
	
	public List<UserDto> getArticle() {
		List<UserDto> listUserDto = modelMapper.map(userRepository.findAll(),List.class);
		return listUserDto;
	}
	
	public void saveCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto,Category.class);
		categoryRepository.save(category);
	}
	
	public List<CategoryDto> getAllCategory() {
		List<CategoryDto> listCategory = modelMapper.map(categoryRepository.findAll(),List.class);
		return listCategory;
	}
	
	public void saveTopic(TopicDto topicDto) {
		Topic topic = modelMapper.map(topicDto,Topic.class);
		topicRepository.save(topic);
	}
	
	public List<TopicDto> getAllTopic() {
		List<TopicDto> listTopic = modelMapper.map(topicRepository.findAll(),List.class);
		return listTopic;
	}
	
	public List<UserDto> retrieveAllArticleByName(String searchItem) {
		List<UserDto> listUserDto = modelMapper.map(userRepository.findByTitleArticleContainingIgnoreCase(searchItem),List.class);
		
		return listUserDto;
	}
	
	public UserDto retrieveArticleByName(String searchItem) {
		String searchItemReplace = searchItem.replace("+", " ");
		String searchItemComplete = searchItemReplace.replace("=", "");
		
		UserDto UserDto = modelMapper.map(userRepository.findByParolaContenutaIgnorandoSpazi(searchItemComplete),UserDto.class);
		
		return UserDto;
	}
}
