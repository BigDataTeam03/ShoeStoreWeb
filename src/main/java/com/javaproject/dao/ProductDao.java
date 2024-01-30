package com.javaproject.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
            datasource = (DataSource) context.lookup("java:comp/env/jdbc/ShoeStore_Web");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DB 에서 상품에대한 모든 정보를 불러들이는 dao
    public ArrayList<ProductDto> productImageFetch() {
        ArrayList<ProductDto> resultArray = new ArrayList<>();
        
        System.out.println("DAO를 실행합니다.");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = datasource.getConnection();
            String query = "SELECT product_code, product_name, product_color, product_qty, " +
                           "product_size, product_price, product_imageName FROM product";
                        
            
            // group by 로 색상이 달라도 하나로 묶어줌. --> 안되지만 나중을 위해 남겨둠...
            String groupViewQuery = "SELECT product_name, product_price,SUM(product_qty) AS total_qty,"
            		+ " COUNT(product_color) AS color_count "
            		+ "FROM product "
            		+ "GROUP BY product_name";
            
            
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_code 		= resultSet.getInt("product_code");
                String product_name 	= resultSet.getString("product_name");
                String product_color 	= resultSet.getString("product_color");
                int product_qty 		= resultSet.getInt("product_qty");
                int product_size		= resultSet.getInt("product_size");
                int product_price 		= resultSet.getInt("product_price");
                String product_imageName 	= resultSet.getString("product_imageName");
  
                
                ProductDto dto = new ProductDto(
                		product_code, product_name, product_color,
                		product_qty, product_size, product_price,
                		product_imageName);
//                ProductDto groupDto = new ProductDto(product_name, product_price,product_imageName );
                System.out.println("result array 에 추가되는내용 입니다 ");
                
                resultArray.add(dto);

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
    
    
    // 선택된 상품에 대한 상품디테일을 조회하여 purchase.jsp의 콤보박스에서 db 에 존재하는 색깔, 사이즈를보여주게 하는 dao
    
    public void purchaseDetail(String selectedProductName) {
    	
        ArrayList<ProductDto> product_details = new ArrayList<>();
        
        System.out.println("DAO를 실행합니다.");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = datasource.getConnection();
            String selectQuery = "SELECT product_detail, product_qty FROM product ";

            String whereQuery =" where product_detail like %?%";
            
            preparedStatement = connection.prepareStatement(selectQuery+ whereQuery);
            preparedStatement.setString(1, selectedProductName);
            resultSet = preparedStatement.executeQuery();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
    public void update(int select_code,int select_qty) {
         
         System.out.println( " update DAO를 실행합니다.");
         
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         
         try {
             connection = datasource.getConnection();
             String updateQuery = "update product set product_qty = product_qty - ? where product_code =? ";
             
             preparedStatement = connection.prepareStatement(updateQuery);
             preparedStatement.setInt(1, select_qty);
             preparedStatement.setInt(2, select_code);
             
             System.out.println("실행한 쿼리입니다. ");
             System.out.println(preparedStatement.toString());
             
             preparedStatement.executeUpdate();
         }
         catch(Exception e) {
         	e.printStackTrace();
         }finally {
             try {
                 if (preparedStatement != null) preparedStatement.close();
                 if (connection != null) connection.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
  	  
    }
}// ㄷEND

	
//String product_name 	= resultSet.getString("product_name");
//int product_price 		= resultSet.getInt("product_price");
//String product_imageName 	= resultSet.getString("product_imageName");
//



// 상품 목록 시스오 
//System.out.println(String.format("Product Code: %d", product_code));
//System.out.println(String.format("Product Name: %s", product_name));
//System.out.println(String.format("Product Color: %s", product_color));
//System.out.println(String.format("Product Quantity: %d", product_qty));
//System.out.println(String.format("Product Size: %d", product_size));
//System.out.println(String.format("Product Price: %d", product_price));




/////////// 이미지를 만들어서 임의의 주소에 저장하는 코드 
//String imagePath = "/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/" + imageFileName;
//File file = new File(imagePath); // 내가 만든 이미지파일이름을 갖는 파일을 생성했다. 어디에???
//
//try (FileOutputStream output = new FileOutputStream(file);
//     InputStream input = resultSet.getBinaryStream("product_image")) {
//    
//    byte[] buffer = new byte[1024];
//    int bytesRead;
//    while ((bytesRead = input.read(buffer)) != -1) {
//        output.write(buffer, 0, bytesRead);
//    }
//}


/////////이미지가 제대로 들어가있는지 실제 주소는 어디에 넣는지 확인하는 코드
// 이미지가 저장될 디렉토리 경로 출력
//System.out.println("이미지 절대 경로: " + file.getAbsolutePath());
//String imageDirectoryPath =file.getAbsolutePath();
//String path = ProductDao.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//System.out.println(">>>> 이것은 파일 패스 가 아님  <<<");
//System.out.println(path);
//
//String path1 ="/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/WEB-INF";
//
//// 특정 폴더 내의 리소스 파일 목록 출력
//listResourcesInDirectory(path1); // "/images"는 웹 애플리케이션 내의 특정 폴더 경로로 변경하세요.
//

//
//// 특정 폴더 경로 설정
//String folderPath = path;
//fileFinder(folderPath);
