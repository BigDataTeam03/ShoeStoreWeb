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
                int product_code 		= resultSet.getInt("product_code");
                String product_name 	= resultSet.getString("product_name");
                String product_color 	= resultSet.getString("product_color");
                int product_qty 		= resultSet.getInt("product_qty");
                int product_size		= resultSet.getInt("product_size");
                int product_price 		= resultSet.getInt("product_price");
                // 상품 목록 시스오 
//                System.out.println(String.format("Product Code: %d", product_code));
//                System.out.println(String.format("Product Name: %s", product_name));
//                System.out.println(String.format("Product Color: %s", product_color));
//                System.out.println(String.format("Product Quantity: %d", product_qty));
//                System.out.println(String.format("Product Size: %d", product_size));
//                System.out.println(String.format("Product Price: %d", product_price));
                
                String imageFileName = "image_" + product_code + ".png";
                System.out.println("저장되는 이미지 파일 이름: " + imageFileName);
            
               
                
                
                
                /////////// 이미지를 만들어서 임의의 주소에 저장하는 코드 
                String imagePath = "/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/" + imageFileName;
                File file = new File(imagePath); // 내가 만든 이미지파일이름을 갖는 파일을 생성했다. 어디에???
                
                try (FileOutputStream output = new FileOutputStream(file);
                     InputStream input = resultSet.getBinaryStream("product_image")) {
                    
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                }
              
                
                /////////이미지가 제대로 들어가있는지 실제 주소는 어디에 넣는지 확인하는 코드
                // 이미지가 저장될 디렉토리 경로 출력
                System.out.println("이미지 절대 경로: " + file.getAbsolutePath());
                String imageDirectoryPath =file.getAbsolutePath();
                String path = ProductDao.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                System.out.println(">>>> 이것은 파일 패스 가 아님  <<<");
                System.out.println(path);
                
                String path1 ="/Users/forrestdpark/Desktop/JavaProgram/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShoeStoreWeb_big3/WEB-INF";
                
                // 특정 폴더 내의 리소스 파일 목록 출력
                listResourcesInDirectory(path1); // "/images"는 웹 애플리케이션 내의 특정 폴더 경로로 변경하세요.
                
                
                
                // 특정 폴더 경로 설정
                String folderPath = path;
                fileFinder(folderPath);
                
                
                
                
                ProductDto dto = new ProductDto(
                	//  상품 코드      :   상품 이름    :  상품 이미지 
                		product_code, product_name, imageFileName,
                	//  상품 수량      :   상품 사이즈  :   상품 가격    :  상품 색상?	
                        product_qty,  product_size, product_price, product_color);
                
//                
//                // 절대 경로
//                String absolutePath = "/Users/forrestdpark/eclipse/jee-2023-12/Eclipse.app/Contents/MacOS/image_1.png";
//
//            
                
    
                
                
                
                
                
                
                
                resultArray.add(dto);

                
                
                
                // 저장된 이미지 파일들을 해당 디렉토리에서 검색
//                File imageDirectory = new File(imageDirectoryPath);
//                File[] imageFiles = imageDirectory.listFiles();
//
//                if (imageFiles != null && imageFiles.length > 0) {
//                    System.out.println("저장된 이미지 파일들:");
//
//                    // 저장된 이미지 파일들의 이름 출력
//                    for (File imageFile : imageFiles) {
//                        if (imageFile.isFile()) {
//                            System.out.println(imageFile.getName());
//                        }
//                    }
//                } else {
//                    System.out.println("저장된 이미지 파일이 없습니다.");
//                }
//                
                
                
                
                
                
                
                
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
    

    private void fileFinder(String folderPath) {
    	
    	System.out.println(" 파일 파인더 실행 ");

        // 폴더 객체 생성
        File folder = new File(folderPath);

        // 폴더가 존재하는지 확인
        if (folder.exists() && folder.isDirectory()) {
            // 폴더 내의 파일 목록 가져오기
            File[] files = folder.listFiles();

            // 파일 목록 출력
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("파일 이름: " + file.getName());
                        System.out.println("파일 경로: " + file.getAbsolutePath());
                        System.out.println("파일 크기: " + file.length() + " bytes");
                        System.out.println("--------------------------------------");
                    }
                }
            } else {
                System.out.println("폴더 내에 파일이 존재하지 않습니다.");
            }
        } else {
            System.out.println("폴더가 존재하지 않거나 디렉토리가 아닙니다.");
        }
    }

    private void listResourcesInDirectory(String directoryPath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(directoryPath);
            if (inputStream != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    System.out.println("폴더 내의 리소스 목록:");
                    System.out.println(reader.lines().collect(Collectors.joining("\n")));
                }
            } else {
                System.out.println("폴더 내에 리소스가 존재하지 않습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}// ㄷEND
