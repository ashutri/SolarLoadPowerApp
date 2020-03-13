package com.SolarProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SolarProject.Dao.LoadPowerDao;
import com.SolarProject.Dao.SolarPowerDao;
import com.SolarProject.Models.LoadHourData;
import com.SolarProject.Models.SolarHourData;
import com.SolarProject.Models.SolarPowerData;

@RestController
@RequestMapping("/v1")
public class MainController {
	
	
	@Autowired
	private SolarPowerDao solarService;
	
	@Autowired
	private LoadPowerDao loadService;
	
	MainController() {
	}
	
	@GetMapping("/fetchSolarHours")
	public List<SolarHourData> fetchSolarData()
	{
		return solarService.findAvgData();		
	}
	
	@GetMapping("/fetchLoadHours")
	public List<LoadHourData> fetchLoadData()
	{
		return loadService.findAvgData();		
	}
	
	@GetMapping("/totalSolarAvg")
	public Double totalSolarAvg()
	{
		return solarService.findTotalAvgData();		
	}
	
	@GetMapping("/totalLoadAvg")
	public Double totalLoadAvg()
	{
		return loadService.findTotalAvgData();		
	}

}
