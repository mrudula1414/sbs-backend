package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchlistdetails")
public class WatchlistDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userid;
	private int watchlist_id;
	private int company_id;
	
	
	public WatchlistDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WatchlistDetails(String userid, int watchlist_id, int company_id) {
		super();
		this.userid = userid;
		this.watchlist_id = watchlist_id;
		this.company_id = company_id;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getWatchlist_id() {
		return watchlist_id;
	}
	public void setWatchlist_id(int watchlist_id) {
		this.watchlist_id = watchlist_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	} 
	
	
	

}
