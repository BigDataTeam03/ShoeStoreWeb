package com.javaproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaproject.dto.AdminDto;

public class AdminDao {

	DataSource dataSource;

	public AdminDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoe");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}



// 검색
	public ArrayList<AdminDto> list() {
		ArrayList<AdminDto> dtos = new ArrayList<AdminDto>();
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

				AdminDto dto = new AdminDto(product_code, product_name, product_color, product_qty, product_size, product_price);
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

	
	//입력
	
	

	public void write(String pName, String pColor, int pQty, int pSize, int pPrice ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into product (product_name, product_color, product_qty, product_size, product_price) values (?,?,?,?,?)"; 
				
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pName);
			preparedStatement.setString(2, pColor);
			preparedStatement.setInt(3, pQty);
			preparedStatement.setInt(4, pSize);
			preparedStatement.setInt(5, pPrice);
			
			preparedStatement.executeUpdate();
			
			
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








