package com.example.backend.dto;

import java.io.ByteArrayInputStream;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@Id
	private String id;
	
	private String titleArticle;
	
	private String bodyArticle;
	
	private String imgCopertina;
	
	private String category;
	
	private String subTitle;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitleArticle() {
		return titleArticle;
	}

	public void setTitleArticle(String titleArticle) {
		this.titleArticle = titleArticle;
	}
	
	public String getBodyArticle() {
		return bodyArticle;
	}

	public void setBodyArticle(String bodyArticle) {
		this.bodyArticle = bodyArticle;
	}
	
	public String getImgCopertina() {
		return imgCopertina;
	}

	public void setImgCopertina(String imgCopertina) {
		this.imgCopertina = imgCopertina;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
}
