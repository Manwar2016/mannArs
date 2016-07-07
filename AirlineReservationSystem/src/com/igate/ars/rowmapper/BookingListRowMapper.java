package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.BookingInfoDTO;

public class BookingListRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet resultSet, int line) throws SQLException {
		BookingInfoDTO bookinginfoDTO = new BookingInfoDTO();
		bookinginfoDTO.setBookingId(resultSet.getString(1));
		bookinginfoDTO.setFlightNo(resultSet.getString(2));
		bookinginfoDTO.setArrivalCity(resultSet.getString(3));
		bookinginfoDTO.setDepartureCity(resultSet.getString(4));
		bookinginfoDTO.setCustomerEmail(resultSet.getString(5));
		bookinginfoDTO.setNumPassengers(resultSet.getString(6));
		bookinginfoDTO.setTotalFare(resultSet.getDouble(7));
		return bookinginfoDTO;
	}

}
