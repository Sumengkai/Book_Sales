package com.example.book_sales.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_sale")
public class Book {
	@Id
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "bookname")
	private String bookName;
	@Column(name = "author")
	private String author;
	@Column(name = "price")
	private int price;
	@Column(name = "stock")
	private int stock;
	@Column(name = "sales")
	private int sales;
	@Column(name = "classification")
	private String classification;

	// ---
	public Book() {
	}
	public Book(String isbn, String bookName, String author, int price, int stock, String classification) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.classification = classification;

	}


	public Book(String isbn, String bookName, String author, int price, int stock,int sales, String classification) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.sales=sales;
		this.classification = classification;

	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
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

}
