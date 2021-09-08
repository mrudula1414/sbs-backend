package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchlists")
public class Watchlists {
	   @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String userid;
	public Watchlists(String name, String userid) {
		super();
		this.name = name;
		this.userid = userid;
	}
	
	public Watchlists() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	} 
	

}
