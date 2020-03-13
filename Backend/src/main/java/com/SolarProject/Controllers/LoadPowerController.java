package com.SolarProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SolarProject.Dao.LoadPowerDao;
import com.SolarProject.Models.LoadPowerData;

@RestController
@RequestMapping("/v1/load")
public class LoadPowerController {

	@Autowired
	private LoadPowerDao loadService;
	
	LoadPowerController() {
	}
	
	@GetMapping("/graph")
	public List<LoadPowerData> fetchData()
	{
		return loadService.findAll();		
	}
}
