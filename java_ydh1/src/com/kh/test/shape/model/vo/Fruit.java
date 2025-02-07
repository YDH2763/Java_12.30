package com.kh.test.shape.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Fruit {
	private String name;
	private String color;
	
	public Fruit(String name, String color) {
		
		this.name = name;
		this.color = color;
	}
	

	
}
