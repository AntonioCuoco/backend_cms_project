package com.example.backend.dto;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

	@Id
	private String id;
	
	private ArrayList<String> listImage;
	

	private String dataDiInserimento;
	/* aggiungere data di inserimento */

	public String getDataDiInserimento() {
		return dataDiInserimento;
	}

	public void setDataDiInserimento(String dataDiInserimento) {
		this.dataDiInserimento = dataDiInserimento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getListImage() {
		return listImage;
	}

	public void setListImage(ArrayList<String> listImage) {
		this.listImage = listImage;
	}
}
