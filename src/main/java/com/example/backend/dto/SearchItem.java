package com.example.backend.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchItem {
	
	private String valueSearch;

	public String getValueSearch() {
		return valueSearch;
	}

	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}
}
