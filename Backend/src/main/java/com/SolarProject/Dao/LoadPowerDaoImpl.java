package com.SolarProject.Dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.SolarProject.Mapper.LoadHourRowMapper;
import com.SolarProject.Mapper.LoadRowMapper;
import com.SolarProject.Models.LoadHourData;
import com.SolarProject.Models.LoadPowerData;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class LoadPowerDaoImpl implements LoadPowerDao{
	NamedParameterJdbcTemplate template; 
	private static DecimalFormat df = new DecimalFormat("0.00");
	public LoadPowerDaoImpl(NamedParameterJdbcTemplate template) {  
		this.template = template;  
	}

	@Override
	public List<LoadPowerData> findAll()  {
		List<LoadPowerData> resList = template.query("select * from \"load_power_data\" ", new LoadRowMapper());
		if(resList.isEmpty())
		{
			resList=findLoadData();
		}

		return resList;
	}

	@Override
	public List<LoadHourData> findAvgData()  {
		
		List<LoadHourData> list = template.query("select * from \"load_hour_data\" ", new LoadHourRowMapper());
		
		return list;
	}
	
	@Override
	public Double findTotalAvgData()  {
		Double data=0.0;
		List<LoadHourData> list=this.findAvgData();
		for(int i=0;i<list.size();i++)
		{
			data+=Double.valueOf(list.get(i).getAvgPower());
		}
		data/=(double) list.size();
		data=Double.valueOf(df.format(data));
		return data;
	}

	@Override
	public String findMin(Date date)  {
		String res="";		

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		res=hours+":"+minutes;

		return res;
	}



	public List<LoadPowerData> findLoadData() 
	{
		File file = null;
		List<LoadPowerData> res=new ArrayList<>();
		List<String> avgData=new ArrayList<>();
		List<String> hrs=new ArrayList<>();
		int temp=1;
		Double avgResult=0.0;
		try {
			file = ResourceUtils.getFile("classpath:load_power_data.csv");

			FileReader filereader = new FileReader(file); 

			// create csvReader object and skip first Line 
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build(); 
			List<String[]> allRows = csvReader.readAll(); 
			
			for(int i=1;i<allRows.size();i++)
			{
				final String sql = "insert into \"load_power_data\" (\"time_stamp\", \"load_power\")"
						+ " values(:timeStamp,:loadPower)";
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date=df.parse(allRows.get(i)[0]);
				String time=this.findMin(date);
				String[] minHrs=time.split(":");
				String hr=minHrs[0];
				String min=minHrs[1];
				
				KeyHolder holder = new GeneratedKeyHolder();
				SqlParameterSource param = new MapSqlParameterSource()
						.addValue("timeStamp", time)
						.addValue("loadPower", Double.valueOf(allRows.get(i)[1]));
				template.update(sql,param, holder);
				avgResult+= Double.valueOf(allRows.get(i)[1]);
				if(Integer.parseInt(min)==0 && Integer.parseInt(hr)==temp)
				{
					temp++;
					avgResult/=60;
					final String sqlHrs = "insert into \"load_hour_data\" (\"avg_power\", \"hours\")"
							+ " values(:avgPower,:hours)";
				    KeyHolder holderHrs = new GeneratedKeyHolder();
					SqlParameterSource paramHrs = new MapSqlParameterSource()
							.addValue("avgPower", String.valueOf(avgResult))
							.addValue("hours", Long.valueOf(hr));
					template.update(sqlHrs,paramHrs, holderHrs);
				    avgResult=0.0;
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		res=findAll();
		
		return res;
	}


}
