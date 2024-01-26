package com.javaproject.dto;

public class UserDto {
			String custid;
			String custpw;
			String name;
			String telno;
			
			
			
			
			
			
			
			public UserDto(String custid, String custpw, String name, String telno) {
				super();
				this.custid = custid;
				this.custpw = custpw;
				this.name = name;
				this.telno = telno;
			}







			public String getCustid() {
				return custid;
			}







			public void setCustid(String custid) {
				this.custid = custid;
			}







			public String getCustpw() {
				return custpw;
			}







			public void setCustpw(String custpw) {
				this.custpw = custpw;
			}







			public String getName() {
				return name;
			}







			public void setName(String name) {
				this.name = name;
			}







			public String getTelno() {
				return telno;
			}







			public void setTelno(String telno) {
				this.telno = telno;
			}
			
			
			
			
}
