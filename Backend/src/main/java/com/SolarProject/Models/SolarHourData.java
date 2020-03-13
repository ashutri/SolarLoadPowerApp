package com.SolarProject.Models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SolarHourData {

	private String avgPower;
	private Long hours;
	
	public SolarHourData()
	{
		
	}	
	
	
	public SolarHourData(String avgPower, Long hours) {
		super();
		this.avgPower = avgPower;
		this.hours = hours;
	}

	public String getAvgPower() {
		return avgPower;
	}

	public void setAvgPower(String avgPower) {
		this.avgPower = avgPower;
	}

	public Long getHours() {
		return hours;
	}

	public void setHours(Long hours) {
		this.hours = hours;
	}

}
