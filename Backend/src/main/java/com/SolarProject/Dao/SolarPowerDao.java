package com.SolarProject.Dao;

import java.util.Date;
import java.util.List;

import com.SolarProject.Models.SolarHourData;
import com.SolarProject.Models.SolarPowerData;

public interface SolarPowerDao {

	public List<SolarPowerData> findAll();
	public List<SolarHourData> findAvgData();
	public Double findTotalAvgData();
	public String findMin(Date date);
}
