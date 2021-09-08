package com.example.demo.models;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "useractivity")
public class UserActivity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userid;
	private LocalDateTime time;
	private String action;
	private String remarks;
	private String item;
	private int amount;
	public UserActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserActivity(String userid, LocalDateTime time, String action, String item, int amount,String remarks) {
		super();
		
		this.userid = userid;
		this.time = time;
		this.action = action;
		this.item = item;
		this.amount = amount;
		this.remarks=remarks;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
