package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.UserDTO;



public class LoginRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet resultSet, int index) throws SQLException {
		// TODO Auto-generated method stub
		
		UserDTO user=new UserDTO();
		user.setUserName(resultSet.getString(1));
		user.setPassword(resultSet.getString(2));
		user.setRole(resultSet.getString(3));
		user.setUserId(resultSet.getString(4));
		return user;
	}

	
	
	
}
