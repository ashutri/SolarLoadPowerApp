package com.SolarProject.Models;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
public class LoadPowerData {

	private String timeStamp;
	private Double loadPower;
	public LoadPowerData()
	{
		
	}
	
	public LoadPowerData(String timeStamp, Double loadPower) {
		super();
		this.timeStamp = timeStamp;
		this.loadPower = loadPower;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String date) {
		this.timeStamp = date;
	}
	public Double getLoadPower() {
		return loadPower;
	}
	public void setLoadPower(Double loadPower) {
		this.loadPower = loadPower;
	}

	
}
