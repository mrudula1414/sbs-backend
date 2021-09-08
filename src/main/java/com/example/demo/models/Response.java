package com.example.demo.models;


import java.util.List;

public class Response {
	private List<Company> stocks;
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	
	public Response(){}
	
	public Response(List<Company> stocks, int totalPages,
						int pageNumber, int pageSize) {
		this.setStocks(stocks);
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public int getTotalPages() {
		return this.totalPages;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageNumber() {
		return this.pageNumber;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}

	public List<Company> getStocks() {
		return stocks;
	}

	public void setStocks(List<Company> stocks) {
		this.stocks = stocks;
	}

}
