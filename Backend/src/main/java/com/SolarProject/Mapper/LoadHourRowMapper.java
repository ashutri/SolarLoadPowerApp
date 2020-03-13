package com.SolarProject.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SolarProject.Models.LoadHourData;

public class LoadHourRowMapper implements RowMapper<LoadHourData> {

	@Override
	public LoadHourData mapRow(ResultSet rs, int arg1) throws SQLException {
		LoadHourData lh=new LoadHourData();
		lh.setAvgPower(rs.getString("avg_power"));	
		lh.setHours(rs.getLong("hours"));
		return lh;
	}

}
