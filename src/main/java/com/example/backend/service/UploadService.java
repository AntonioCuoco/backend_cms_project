package com.example.backend.service;


import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dto.ImageDto;
import com.example.backend.entity.Image;
import com.example.backend.repository.UploadRepository;

@Service
public class UploadService {
		
		@Autowired
		private UploadRepository uploadRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		

	    public String uploadImage(Image image) {
	    	
	        if (image.getListImage().isEmpty()) {
	            return "Selezionare un'immagine/i da caricare.";
	        }

	        try {
	        	LocalDateTime currentDateTime = LocalDateTime.now();
	            String formattedDateTime = currentDateTime.toString();
	        	image.setDataDiInserimento(formattedDateTime);
	            uploadRepository.save(image);

	            return "Immagine caricata con successo.";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Errore durante il salvataggio delle immagini.";
	        }
	    }
	    
	    public List<ImageDto> getImage() {
			List<ImageDto> listImageDto = modelMapper.map(uploadRepository.findAll(),List.class);
			return listImageDto;
		}
	
}
