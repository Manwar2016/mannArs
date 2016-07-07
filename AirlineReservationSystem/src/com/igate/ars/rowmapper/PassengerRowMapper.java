package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.PassengerDTO;

public class PassengerRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet resultSet, int line) throws SQLException {
		PassengerDTO passengerdto = new PassengerDTO();
		passengerdto.setFirstName(resultSet.getString(1));
		passengerdto.setLastName(resultSet.getString(2));
		passengerdto.setBookingId(resultSet.getString(3));
		passengerdto.setPassengerId(resultSet.getInt(4));
		passengerdto.setMobileNo(resultSet.getString(5));
		return passengerdto;
	}
	

}
