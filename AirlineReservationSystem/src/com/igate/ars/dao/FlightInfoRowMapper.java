package com.igate.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.FlightInfoDTO;

public class FlightInfoRowMapper implements RowMapper<FlightInfoDTO>{

	@Override
	public FlightInfoDTO mapRow(ResultSet resultSet, int line) throws SQLException {
		FlightInfoDTO flightInfoDTO= new FlightInfoDTO();
		flightInfoDTO.setFlightNo(resultSet.getString(1));
		flightInfoDTO.setAirline(resultSet.getString(2));
		flightInfoDTO.setArrivalCity(resultSet.getString(3));
		flightInfoDTO.setDepartureCity(resultSet.getString(4));
		flightInfoDTO.setDepartureDate(resultSet.getDate(5));
		flightInfoDTO.setArrivalDate(resultSet.getDate(6));
		flightInfoDTO.setDepartureTime(resultSet.getString(7));
		flightInfoDTO.setArrivalTime(resultSet.getString(8));
		flightInfoDTO.setFirstSeats(resultSet.getInt(9));
        flightInfoDTO.setFirstSeatFare(resultSet.getDouble(10));
        flightInfoDTO.setBusinessSeats(resultSet.getInt(11));
        flightInfoDTO.setBusinessSeatFare(resultSet.getDouble(12));
		return flightInfoDTO;
		
	}
	

}
