package com.javaproject.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class AdminDao {

	DataSource dataSource;

	public AdminDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ShoeStore_Web");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}



	// 검색
	public ArrayList<com.javaproject.dto.AdminDto> list() {
		ArrayList<com.javaproject.dto.AdminDto> dtos = new ArrayList<com.javaproject.dto.AdminDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select product_code, product_name, product_color, product_qty, product_size, product_price from product";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int product_code = resultSet.getInt("product_code");
				String product_name = resultSet.getString("product_name");
				String product_color = resultSet.getString("product_color");
				int product_qty = resultSet.getInt("product_qty");
				int product_size = resultSet.getInt("product_size");
				int product_price = resultSet.getInt("product_price");
			//	FileInputStream product_image = resultSet.("product_image");

				com.javaproject.dto.AdminDto dto = new com.javaproject.dto.AdminDto(product_code, product_name, product_color, product_qty, product_size, product_price);
				dtos.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
		}

		return dtos;
	}
	
	// 입력
	public void write(int newProductCode, String pName, String pColor, int pQty, int pSize, int pPrice, String filename) {
		
		
		int newPCode = newProductCode;
		System.out.println("---------쿼리에 넣어지는 변수들 ----------");
		System.out.println(String.format("newPcode ; %s",newPCode));
		
		System.out.println("write dao 를 실행합니다. ");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String insertQuery = "insert into product "
					//	 상품코드        상품명 		  상품 색상        상품재고수량     상품 사이즈 
					+ "(product_code, product_name, product_color, product_qty, product_size, "
					// 상품 가격    
					+ "product_price , product_imageName) "
					
					+ "values (?,?,?,?,?,?,?)"; 
			
			System.out.println("query 입니다. \n"+insertQuery);
			

			
			
			preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt   (1, newPCode);
			preparedStatement.setString(2, pName);
			preparedStatement.setString(3, pColor);
			preparedStatement.setInt   (4, pQty);
			preparedStatement.setInt   (5, pSize);
			preparedStatement.setInt   (6, pPrice);
			preparedStatement.setString   (7, filename);

			
			preparedStatement.executeUpdate();
			
			System.out.println(" insert query 문입니다.");
			System.out.println(preparedStatement.toString());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {	
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				
			}
		}
		
	
	
	
	}
	
	
}//END








