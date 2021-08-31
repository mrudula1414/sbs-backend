package com.example.demo.controllers;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.UserActivity;
import com.example.demo.models.WatchListModel;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserActivityRepository;
import com.example.demo.repository.WatchListRepository;



@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class WatchListController {
	
	@Autowired
	private CompanyRepository companyRepository;
	

	@Autowired
	private UserActivityRepository userActivityRepository;
	
	@Autowired
	private WatchListRepository watchListRepository;
	
	public LocalDateTime getDateAndTime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		  return now;
	}
	@GetMapping("/add-watchlist")
	public Map<String, String>  addWatchList(@RequestParam String email, @RequestParam int id)
	{
		List<Company> allCompany = (List<Company>)companyRepository.findAll();
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		
		try 
		{
			Iterator<WatchListModel> iter1 = allWatchList.iterator();
			while(iter1.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter1.next();
				if(email.equals(wl.getUser_id())&&(id == wl.getCompany_id()))
				{
					HashMap<String, String> map = new HashMap<>();
					map.put("status", "company exist");
					return map;
				}
			}
			
			Iterator<Company> iter2 = allCompany.iterator();
			while(iter2.hasNext())
			{
				Company cm = (Company) iter2.next();
				if(id == cm.getCompany_id())
				{
					UserActivity u1=new UserActivity();
					
					u1.setItem("Changes in watchlist");
					u1.setRemarks("Added "+cm.getName()+"to your watchlist ");
					u1.setStockid(id);
					u1.setTime(getDateAndTime());
					u1.setUserid(email);
					u1.setAction("Add stock to watchlist");
			
					//UserActivity u1=new User()
					WatchListModel wl = new WatchListModel(cm.getCompany_id(),cm.getName(),email, cm.getOpen_rate(),cm.getClose_rate(),cm.getPeak_rate(),cm.getLeast_rate(),cm.getCurrent_rate(),cm.getYear_low(),cm.getYear_high(),cm.getMarket_cap(),cm.getP_e_ratio(),cm.getVolume());
					watchListRepository.save(wl);
					userActivityRepository.save(u1);
				}
			}
		}
		catch(Exception e)		
		{	
			HashMap<String, String> map = new HashMap<>();
			map.put("status", e.getMessage());
			return map;
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		return map;
	}
	
	@GetMapping("/watch-list")
	public List<WatchListModel> watchList(@RequestParam("email") String email)
	{
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		List<WatchListModel> myWatchList = new ArrayList<WatchListModel>();
		try 
		{
			Iterator<WatchListModel> iter = allWatchList.iterator();
			while(iter.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter.next();
				if(email.equals(wl.getUser_id()))
				{
					System.out.print(wl);
					myWatchList.add(wl);
					
				}
			}
		}
		catch(Exception e)		
		{	System.out.print("Exception : ");	
			System.out.print(e.getMessage());
		}
		
		return myWatchList;
	}
	@GetMapping("/remove-watchlist")
	public Map<String, String>  removeWatchList(@RequestParam String email, @RequestParam int id)
	{
		HashMap<String, String> map = new HashMap<>();		
		List<Company> allCompany = (List<Company>)companyRepository.findAll();
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		
		try 
		{
			Iterator<WatchListModel> iter1 = allWatchList.iterator();
			while(iter1.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter1.next();
				if(email.equals(wl.getUser_id())&&(id == wl.getCompany_id()))
				{
					watchListRepository.delete(wl);
				
					UserActivity u1=new UserActivity();
					
					u1.setItem("Changes in watchlist");
					u1.setRemarks("Removed "+wl.getName()+"  from your watchlist");
					u1.setStockid(wl.getCompany_id());
					u1.setTime(getDateAndTime());
					u1.setUserid(email);
					u1.setAction("Remove stock from watchlist");
					userActivityRepository.save(u1);
					map.put("status", "success");
					return map;
				}
			}
			
			
		}
		catch(Exception e)		
		{	
			map.put("status", e.getMessage());
			return map;
		}
		
		map.put("status", "success");
		return map;
	}

}
