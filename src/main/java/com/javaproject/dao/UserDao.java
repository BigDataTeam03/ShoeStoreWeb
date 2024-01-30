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
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.Statement;

public class UserDao {

	
	// Field
	
	DataSource datasource;
	
	//Constructor
	public UserDao() {
		
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/ShoeStore_Web");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	// DB test 용으로 하나만 불러오는 다오
	public void login(String cust_id, String cust_pw) {
		
	}
	
	//Method
	// 유저체크
	public boolean checkUserId(String userId) {
        boolean passibleUser = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = datasource.getConnection();
            String query = "SELECT COUNT(*) FROM customer WHERE cust_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if(count == 0) {
                	passibleUser = false;
                } else {
                	passibleUser = true;
                }
                // 0이면 아이디 없음, 1이면 아이디 존재
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
        return passibleUser;
    }

	
	// 비번 체크
		public boolean checkUserPw(String userPw) {
	        boolean passibleUserPw = false;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        
	        try {
	            connection = datasource.getConnection();
	            String query = "SELECT cust_pw FROM customer WHERE cust_pw = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, userPw);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                String dbPw = resultSet.getString(1);
	                // 패스워드가 같으면 true 다르면 false
	                if(dbPw.equals(userPw)) {
	                	passibleUserPw = true;
	                } else {
	                	passibleUserPw = false;
	                }
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
	        return passibleUserPw;
	    }
	//회원가입 기능
	public void register(String cust_id, String cust_pw, String cust_name, String cust_telno)  {
	    
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	   System.out.println("쿼리문 실행5" + cust_id);
	    try {
	        connection = datasource.getConnection();
	        String query = "INSERT INTO customer (cust_id, cust_pw, cust_name, cust_telno) VALUES (?, ?, ?, ?)";
	        System.out.println(query);
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, cust_id);
	        preparedStatement.setString(2, cust_pw);
	        preparedStatement.setString(3, cust_name);
	        preparedStatement.setString(4, cust_telno);
	        
	       	preparedStatement.executeUpdate();		
	        
	       	System.out.println("쿼리문 실행10" + cust_id);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 닫기
	        try {
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

	    return;
	}
		
	
	

}
