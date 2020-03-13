package com.SolarProject.Models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SolarPowerData {

	private String timeStamp;
	private Double solarPower;
	
	public SolarPowerData()
	{
		
	}	
	
	
	public SolarPowerData(String timeStamp, Double solarPower) {
		super();
		this.timeStamp = timeStamp;
		this.solarPower = solarPower;
	}


	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String date) {
		this.timeStamp = date;
	}
	public Double getSolarPower() {
		return solarPower;
	}
	public void setSolarPower(Double solarPower) {
		this.solarPower = solarPower;
	}

	
}
