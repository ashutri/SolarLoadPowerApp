package com.SolarProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SolarProject.Dao.SolarPowerDao;
import com.SolarProject.Models.SolarPowerData;

@RestController
@RequestMapping("/v1/solar")
public class SolarPowerController {
	
	@Autowired
	private SolarPowerDao solarService;
	
	SolarPowerController() {
	}
	
	@GetMapping("/graph")
	public List<SolarPowerData> fetchData()
	{
		return solarService.findAll();		
	}

}
