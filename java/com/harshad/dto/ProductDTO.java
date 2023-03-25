package com.harshad.dto;

import com.harshad.model.Product;

public class ProductDTO {

	private Long id;
	private String name;

	private int categoryId;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public ProductDTO(Long id, String name, int categoryId, double price, String description, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.description = description;
		this.imageName = imageName;
	}

	private double price;
	private String description;
	private String imageName;
	
	public ProductDTO() {
		
	}

	public Product findById(Long pid) {
		return null;
	}
}
