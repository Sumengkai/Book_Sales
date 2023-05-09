package com.example.book_sales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_sales.service.ifs.Bookifs;
import com.example.book_sales.vo.BookReq;
import com.example.book_sales.vo.BookRes;

@RestController
public class BookController {
	@Autowired
	private Bookifs bookifs;
	//==================================1
	@PostMapping(value = "/api/book1")
	public BookRes addAndUpdateBookInfo(@RequestBody BookReq req) {
		BookRes res = bookifs.addAndUpdateBook(req.getIsbn(), req.getBookName(), req.getAuthor(), req.getPrice(),
				req.getStock(), req.getClassificationList());
		return res;
	}

	// ==================================2
	@PostMapping(value = "/api/book2")
	public BookRes searchClassiFication(@RequestBody BookReq req) {
		BookRes res = bookifs.searchClassiFication(req.getClassificationList());
		return res;
	}
	//==================================3
	@PostMapping(value = "/api/book3")
	public BookRes updateBookinfo(@RequestBody BookReq req) {
		BookRes res =bookifs.updateBook(req.getIsbn(), req.getBookName(), req.getAuthor(), req.getPrice(), req.getStock(), req.getClassificationList());
		return res;
		}
	//==================================4
	@PostMapping(value = "/api/book4")
	public BookRes buyBook(@RequestBody BookReq req) {
		BookRes res = bookifs.buyBook(req.getBuymap());
		return res;
	}
	//==================================5
	@PostMapping(value = "/api/book5")
	public BookRes searchBookInfo(@RequestBody BookReq req) {
		BookRes res = bookifs.searchBookInfo(req.getIsbn(), req.getAuthor(), req.getBookName());
		return res;
		
	}
	//==================================6
	@PostMapping(value = "/api/book6")
	public BookRes findTopsales() {
		BookRes res = bookifs.salesTop5();
		return res;
		
	}
}
