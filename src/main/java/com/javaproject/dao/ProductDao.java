package com.javaproject.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaproject.dto.ProductDto;

public class ProductDao {
    
    // 필드
    DataSource datasource;

    // 생성자
    public ProductDao() {
        try {
            Context context = new InitialContext();
            datasource = (DataSource) context.lookup("java:comp/env/jdbc/shoe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductDto> productImageFetch() {
        ArrayList<ProductDto> resultArray = new ArrayList<>();
        
        System.out.println("DAO를 실행합니다.");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = datasource.getConnection();
            String query = "SELECT product_code, product_name, product_color, product_qty, " +
                           "product_size, product_price, product_image FROM product";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_code = resultSet.getInt("product_code");
                String product_name = resultSet.getString("product_name");
                String product_color = resultSet.getString("product_color");
                int product_qty = resultSet.getInt("product_qty");
                int product_size = resultSet.getInt("product_size");
                int product_price = resultSet.getInt("product_price");
                
                System.out.println(String.format("Product Code: %d", product_code));
                System.out.println(String.format("Product Name: %s", product_name));
                System.out.println(String.format("Product Color: %s", product_color));
                System.out.println(String.format("Product Quantity: %d", product_qty));
                System.out.println(String.format("Product Size: %d", product_size));
                System.out.println(String.format("Product Price: %d", product_price));
                
                String imageFileName = "image_" + product_code + ".jpg";
                System.out.println("이미지 파일 이름: " + imageFileName);
                
                File file = new File(imageFileName);
                
                ProductDto dto = new ProductDto(product_code, product_name, product_color,
                                                product_qty, product_size, product_price, imageFileName);
                resultArray.add(dto);
                
                try (FileOutputStream output = new FileOutputStream(file);
                     InputStream input = resultSet.getBinaryStream("product_image")) {
                    
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultArray;
    }
}
