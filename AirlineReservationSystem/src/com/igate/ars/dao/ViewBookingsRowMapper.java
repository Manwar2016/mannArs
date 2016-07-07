package com.igate.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.BookingInfoDTO;
import com.igate.ars.dto.FlightInfoDTO;

public class ViewBookingsRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet resultSet, int index) throws SQLException {
		// TODO Auto-generated method stub
		
		BookingInfoDTO bookingInfo=new BookingInfoDTO();
		
		bookingInfo.setBookingId(resultSet.getString(1));
		bookingInfo.setFlightNo(resultSet.getString(2));
		bookingInfo.setArrivalCity(resultSet.getString(3));
		bookingInfo.setDepartureCity(resultSet.getString(4));
		bookingInfo.setCustomerEmail(resultSet.getString(5));
		bookingInfo.setNumPassengers(resultSet.getString(6));
		bookingInfo.setTotalFare(resultSet.getDouble(7));
		

		return bookingInfo;
	}
	
	

}
