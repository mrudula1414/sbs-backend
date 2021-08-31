package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MySharesRepository;


@Service
public class DataService {
	
	@Autowired
	private MySharesRepository mySharesRepository;
	
}
