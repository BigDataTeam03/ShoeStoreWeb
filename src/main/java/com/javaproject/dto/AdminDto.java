package com.javaproject.dto;

import java.io.FileInputStream;

public class AdminDto {
	
	
	//Field
	int product_code;
	String product_name;
	String product_color;
	int product_qty;
	int product_size;
	int product_price;
	FileInputStream product_image;
	
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminDto(int product_code, String product_name, String product_color, int product_qty, int product_size,
			int product_price) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_color = product_color;
		this.product_qty = product_qty;
		this.product_size = product_size;
		this.product_price = product_price;
	}
	
	public AdminDto(int product_code, String product_name, String product_color, int product_qty, int product_size,
			int product_price, FileInputStream product_image) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_color = product_color;
		this.product_qty = product_qty;
		this.product_size = product_size;
		this.product_price = product_price;
		this.product_image = product_image;
	}

	
	
	


	public AdminDto(String product_name, String product_color, int product_qty, int product_size, int product_price,
			FileInputStream product_image) {
		super();
		this.product_name = product_name;
		this.product_color = product_color;
		this.product_qty = product_qty;
		this.product_size = product_size;
		this.product_price = product_price;
		this.product_image = product_image;
	}


	public int getProduct_code() {
		return product_code;
	}


	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_color() {
		return product_color;
	}


	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}


	public int getProduct_qty() {
		return product_qty;
	}


	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}


	public int getProduct_size() {
		return product_size;
	}


	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public FileInputStream getProduct_image() {
		return product_image;
	}


	public void setProduct_image(FileInputStream product_image) {
		this.product_image = product_image;
	}




}
