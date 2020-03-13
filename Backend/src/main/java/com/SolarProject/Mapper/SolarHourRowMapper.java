package com.SolarProject.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SolarProject.Models.SolarHourData;
import com.SolarProject.Models.SolarPowerData;

public class SolarHourRowMapper implements RowMapper<SolarHourData> {

	@Override
	public SolarHourData mapRow(ResultSet rs, int arg1) throws SQLException {
		SolarHourData sh=new SolarHourData();
		sh.setAvgPower(rs.getString("avg_Power"));	
		sh.setHours(rs.getLong("hours"));
		return sh;
	}

}
