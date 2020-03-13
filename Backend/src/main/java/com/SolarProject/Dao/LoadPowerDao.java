package com.SolarProject.Dao;

import java.util.Date;
import java.util.List;

import com.SolarProject.Models.LoadHourData;
import com.SolarProject.Models.LoadPowerData;

public interface LoadPowerDao {

	public List<LoadPowerData> findAll();
	public List<LoadHourData> findAvgData();
	public Double findTotalAvgData();
	public String findMin(Date date);
}
