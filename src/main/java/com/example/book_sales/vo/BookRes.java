package com.example.book_sales.vo;

import java.util.List;
import java.util.Set;

import com.example.book_sales.Entity.Book;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRes {
	@JsonProperty("Book_info")
	public Book book;
	public String maessage;
	public Set<Book> booklist;
	public List<String> buylist;
	public List<Book> toplist;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getMaessage() {
		return maessage;
	}

	public void setMaessage(String maessage) {
		this.maessage = maessage;
	}

	public Set<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(Set<Book> booklist) {
		this.booklist = booklist;
	}

	public List<String> getBuylist() {
		return buylist;
	}

	public void setBuylist(List<String> buylist) {
		this.buylist = buylist;
	}

	public List<Book> getToplist() {
		return toplist;
	}

	public void setToplist(List<Book> toplist) {
		this.toplist = toplist;
	}
	
	
	
}
