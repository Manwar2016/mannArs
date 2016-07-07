package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.PassengerDTO;

public class ViewUpdateBookingRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet resultSet, int index) throws SQLException {
		// TODO Auto-generated method stub
		
		PassengerDTO passenger=new PassengerDTO();
		passenger.setBookingId(resultSet.getString(1));
		passenger.setPassengerId(resultSet.getInt(2));
		passenger.setFirstName(resultSet.getString(3));
		passenger.setLastName(resultSet.getString(4));
		passenger.setEmailId(resultSet.getString(5));
		passenger.setMobileNo(resultSet.getString(6));
		passenger.setGender(resultSet.getString(7));
		return passenger;
	}

}
