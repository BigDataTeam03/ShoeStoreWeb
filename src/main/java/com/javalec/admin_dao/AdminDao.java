package com.javalec.admin_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.admin_dto.AdminDto;

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
			String query = "select pnum, pname, pcolor, pqty, psize, pprice from product";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int pnum = resultSet.getInt("pnum");
				String pname = resultSet.getString("pname");
				String pcolor = resultSet.getString("pcolor");
				int pqty = resultSet.getInt("pqty");
				int psize = resultSet.getInt("psize");
				int pprice = resultSet.getInt("pprice");
				// Timestamp bDate = resultSet.getTimestamp("image");

				AdminDto dto = new AdminDto(pnum, pname, pcolor, pqty, psize, pprice );
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

}// list()
