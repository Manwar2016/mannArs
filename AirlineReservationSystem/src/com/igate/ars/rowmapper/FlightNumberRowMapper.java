package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.AirportDTO;
import com.igate.ars.dto.FlightInfoDTO;

public class FlightNumberRowMapper implements RowMapper<FlightInfoDTO> {

	@Override
	public FlightInfoDTO mapRow(ResultSet resultSet, int line) throws SQLException {
		FlightInfoDTO flightInfoDTO= new FlightInfoDTO();
		flightInfoDTO.setFlightNo(resultSet.getString(1));
		return flightInfoDTO;
	
	}

}
