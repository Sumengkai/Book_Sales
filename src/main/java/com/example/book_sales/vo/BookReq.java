package com.example.book_sales.vo;

import java.util.Map;
import java.util.Set;

import javax.persistence.Column;


public class BookReq {
	private String isbn;
	private String bookName;
	private String author;
	private Integer price;
	private Integer stock;
	private int sales;
	private String classification;
	private Set<String>classificationList;
	private Map<String,Integer> buymap;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Set<String> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(Set<String> classificationlist) {
		this.classificationList = classificationlist;
	}

	public Map<String, Integer> getBuymap() {
		return buymap;
	}

	public void setBuymap(Map<String, Integer> buymap) {
		this.buymap = buymap;
	}

	
}
