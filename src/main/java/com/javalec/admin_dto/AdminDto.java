package com.javalec.admin_dto;

import java.io.FileInputStream;

public class AdminDto {
	
	
	//Field
	int pnum;
	String pname;
	String pcolor;
	int pqty;
	int psize;
	int pprice;
	FileInputStream image;
	
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}
	

	public AdminDto(int pnum, String pname, String pcolor, int pqty, int psize, int pprice) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.pcolor = pcolor;
		this.pqty = pqty;
		this.psize = psize;
		this.pprice = pprice;
	}

	
	public AdminDto(int pnum, String pname, String pcolor, int pqty, int psize, int pprice, FileInputStream image) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.pcolor = pcolor;
		this.pqty = pqty;
		this.psize = psize;
		this.pprice = pprice;
		this.image = image;
	}
	
	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public FileInputStream getImage() {
		return image;
	}

	public void setImage(FileInputStream image) {
		this.image = image;
	}
	

}
