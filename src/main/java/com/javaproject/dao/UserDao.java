package com.javaproject.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.javaproject.dto.UserDto;
import com.mysql.cj.xdevapi.Statement;

public class UserDao {

	
	// Field
	
	DataSource datasource;
	
	//Constructor
	public UserDao() {
		
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/shoe");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	// DB test 용으로 하나만 불러오는 다오
	public UserDto testDao() {
		UserDto result= null;
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		try {
			connection = datasource.getConnection();
			String query = "select cust_id, cust_pw, name, telno from customer";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
	
			
			if ( resultSet.next()) {
				String cust_id 	= resultSet.getString("cust_id");
				String cust_pw 	= resultSet.getString("cust_pw");
				String name 	= resultSet.getString("name");
				String telno 	= resultSet.getString("telno");
				
				result = new UserDto(cust_id, cust_pw, name, telno);
			
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	

			
	
	public boolean checkUsername(String username) {
        boolean passibleid = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = datasource.getConnection();
            String query = "SELECT COUNT(*) FROM customer WHERE cust_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                passibleid = (count == 0); // 0이면 중복 아이디 없음, 1 이상이면 중복 아이디 존재
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return passibleid;
    }

	
	
	
	
	//Method
}
