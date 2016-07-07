package com.igate.ars.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ars.dto.AirportDTO;


public class AirportRowMapper implements RowMapper<AirportDTO> {

	@Override
	public AirportDTO mapRow(ResultSet resultSet, int line) throws SQLException {
		AirportDTO airportDTO = new AirportDTO();
		airportDTO.setAirportId(resultSet.getString(1));
		airportDTO.setAirportName(resultSet.getString(2));
		airportDTO.setCity(resultSet.getString(3));
		return airportDTO;
	}
	

}
