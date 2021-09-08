package com.example.demo.controllers;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.MySharesModel;
import com.example.demo.models.UserActivity;
import com.example.demo.models.UserModel;
import com.example.demo.models.WatchListModel;
import com.example.demo.models.Watchlists;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserActivityRepository;
import com.example.demo.repository.WatchListRepository;
import com.example.demo.repository.WatchlistsRepository;



@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class WatchListController {
	
	@Autowired
	private CompanyRepository companyRepository;
	

	@Autowired
	private UserActivityRepository userActivityRepository;
	
	@Autowired
	private WatchlistsRepository watchlistsRepository;
	
	@Autowired
	private WatchListRepository watchListRepository;
	
	public LocalDateTime getDateAndTime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		  return now;
	}
	
	@GetMapping("/add-watchlist")
	public Map<String, String>  addWatchList(@RequestParam String email, @RequestParam int id,@RequestParam String watchlistname)
	{
		List<Company> allCompany = (List<Company>)companyRepository.findAll();
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		String watchlistName=watchlistname;
		
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
					u1.setRemarks("Added "+cm.getName()+" to your watchlist ");
					u1.setAmount(0);
					u1.setTime(getDateAndTime());
					u1.setUserid(email);
					u1.setAction("Add stock to watchlist");
			
					//UserActivity u1=new User()
					WatchListModel wl = new WatchListModel(cm.getCompany_id(),cm.getName(),email,watchlistName,cm.getOpen_rate(),cm.getClose_rate(),cm.getPeak_rate(),cm.getLeast_rate(),cm.getCurrent_rate(),cm.getYear_low(),cm.getYear_high(),cm.getMarket_cap(),cm.getP_e_ratio(),cm.getVolume());
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
	public List<WatchListModel> watchList(@RequestParam("email") String email,@RequestParam String watchlistname)
	{
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		List<WatchListModel> myWatchList = new ArrayList<WatchListModel>();
		
		try 
		{
			Iterator<WatchListModel> iter = allWatchList.iterator();
			while(iter.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter.next();
				if(email.equals(wl.getUser_id()) && wl.getWatchlistname().equals(watchlistname))
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
	@GetMapping("/watch-lists")
	public List<WatchListModel> completeWatchList(@RequestParam("email") String email)
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
					u1.setAmount(0);
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
	
	@PostMapping("/create-watchlist")
	public Map<String, String> createWatchlist(@RequestBody Map<String, Object> payload) //payload will be watchlistname and user email id
	{
		
		String email = (String) payload.get("email");
		String name = (String) payload.get("name");
		Watchlists watchlist = new Watchlists(name,email);
		watchlistsRepository.save(watchlist);
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		return map;
	}
	
	@GetMapping("/watchlists")
	public List<Watchlists> getAllWatchlists(@RequestParam("email") String email)
	{
		List<Watchlists> watchlists = new ArrayList<>();

		try 
		{
			watchlists=(List<Watchlists>)watchlistsRepository.findByUserid(email);
		}
		catch(Exception e)		
		{	System.out.print("Exception : ");	
			System.out.print(e.getMessage());
		}
		
		return watchlists;
	}
	
	
	//edit and delete

	

}
