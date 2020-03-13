package com.SolarProject.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SolarProject.Models.SolarPowerData;

public class SolarRowMapper implements RowMapper<SolarPowerData> {

	@Override
	public SolarPowerData mapRow(ResultSet rs, int arg1) throws SQLException {
		SolarPowerData sp=new SolarPowerData();
		sp.setTimeStamp(rs.getString("time_stamp"));	
		sp.setSolarPower(rs.getDouble("solar_power"));
		return sp;
	}

}
