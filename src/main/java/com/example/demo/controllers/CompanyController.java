package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.repository.CompanyRepository;

import com.example.demo.models.Response;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class CompanyController {


//	@GetMapping("/pageable")
//	public Page<Company> retrieveCustomerWithPaging(@Param(value = "page") int page, 
//												@Param(value = "size") int size){
//		Pageable requestedPage = PageRequest.of(page, size);
//		Page<Company> companies  = companyRepository.findAll(requestedPage);
//		return companies;
//	}
	@Autowired
	private CompanyRepository companyRepository;
	@GetMapping("/get-all")
	public List<Company> getAll()
	{
		List<Company> companyDetails = (List<Company>)companyRepository.findAll();
		return companyDetails;
	}
	
	@GetMapping("/get-one")
	public Optional <Company> getOne(@RequestParam int id)
	{
		return companyRepository.findById(id);
	}
	@GetMapping("/pageable/list")
	public List<Company> retrieveCustomerListWithPaging(@Param(value = "page") int page, 
													@Param(value = "size") int size){
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Company> companies  = companyRepository.findAll(requestedPage);
		return companies.toList();
	}
	@GetMapping("/custom/pageable")
	public Response retrieveCustomer(@Param(value = "page") int page, 
												@Param(value = "size") int size){
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Company> companies  = companyRepository.findAll(requestedPage);
		Response res = new Response(companies.getContent(), companies.getTotalPages(),
				companies.getNumber(), companies.getSize());
		
		return res;
	}
}
