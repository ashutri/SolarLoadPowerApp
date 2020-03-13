package com.SolarProject.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SolarProject.Models.LoadPowerData;
import com.SolarProject.Models.SolarPowerData;

public class LoadRowMapper implements RowMapper<LoadPowerData> {

	@Override
	public LoadPowerData mapRow(ResultSet rs, int arg1) throws SQLException {
		LoadPowerData sp=new LoadPowerData();
		sp.setTimeStamp(rs.getString("time_stamp"));	
		sp.setLoadPower(rs.getDouble("load_power"));
		return sp;
	}

}
