package com.example.backend.controllerNuovo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.dto.ImageDto;
import com.example.backend.entity.Image;
import com.example.backend.service.UploadService;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/upload")
	public String uploadImage(@RequestBody Image image) {
			return uploadService.uploadImage(image);
    }
	
	@GetMapping("/getImg")
	public List<ImageDto> getImage() {
		return uploadService.getImage();
	}
}
