package com.example.book_sales.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.book_sales.Entity.Book;
import com.example.book_sales.Repository.BookDao;
import com.example.book_sales.service.ifs.Bookifs;
import com.example.book_sales.vo.BookRes;

@Service
public class Bookimpl implements Bookifs {
	@Autowired
	private BookDao bookDao;

//-----
	private boolean checknull(String isbn, String bookname, String author, Integer price, Integer stock,
			Set<String> listset) {
		if (!StringUtils.hasText(isbn) || !StringUtils.hasText(bookname) || !StringUtils.hasText(author)) {
			return true;
		}
		if (price == null || stock == null) {
			return true;
		}
		if (listset.isEmpty()) {
			return true;
		}
		return false;
	}

//-----
//========================================================================================1.�s�W�ק���y
	@Override
	public BookRes addAndUpdateBook(String isbn, String bookname, String author, Integer price, Integer stock,
			Set<String> classificationlist) {
		BookRes res = new BookRes();
		boolean checknull = (new Bookimpl().checknull(isbn, bookname, author, price, stock, classificationlist));
		if (checknull) {
			res.setMaessage("���i�Ū�");
			return res;
		}
		Optional<Book> bookop = bookDao.findById(isbn);
		List<String> list = new ArrayList<>();
		for (var listsetfor : classificationlist) {
			list.add(listsetfor.trim());
		}
		String classification = list.toString().substring(1, list.toString().length() - 1);
		if (!bookop.isPresent()) {
			Book bookinfo = new Book(isbn, bookname, author, price, stock, classification);
			res.setBook(bookinfo);
			res.setMaessage("�s�W���\");
			bookDao.save(bookinfo);
			return res;
		}
		Book bookIsbnAndStock = bookop.get();
		Book bookinfo = new Book(bookIsbnAndStock.getIsbn(), bookname, author, price, bookIsbnAndStock.getStock(),
				bookIsbnAndStock.getSales(), classification);
		res.setBook(bookinfo);
		res.setMaessage("�ק令�\");
		bookDao.save(bookinfo);
		return res;
	}
//=====================================================================2.�����j�M(�٭n��)

	@Override
	public BookRes searchClassiFication(Set<String> listset) {
		BookRes res = new BookRes(); 

		List<Book> booklistAll = bookDao.findByClassificationContaining(listset);
		List<Book> bookinfo = new ArrayList<>();
		Set<Book> resBookInfo = new HashSet<>();
		if (listset.size() == 0) {
			res.setMaessage("��");
		}
		for (var booklistAllfor : booklistAll) {
			for (var listname : listset) {
				if (booklistAllfor.getClassification().contains(listname)) {
					Book book = new Book(booklistAllfor.getIsbn(), booklistAllfor.getBookName(),
							booklistAllfor.getAuthor(), booklistAllfor.getPrice(), booklistAllfor.getStock(),
							booklistAllfor.getClassification());
					resBookInfo.add(book);
				}
			}
		}
//		resBookInfo.addAll(bookinfo);
		res.setBooklist(resBookInfo);
		return res;
	}
//===============================================================================3.��s���y

	@Override
	public BookRes updateBook(String isbn, String bookname, String author, Integer price, Integer stock,
			Set<String> list) {
		Optional<Book> bookOp = bookDao.findById(isbn);
		BookRes res = new BookRes();
		List<String> listClassification = new ArrayList<>();
		if (!bookOp.isPresent()) {
			res.setMaessage("�䤣��ӥ���");
			return res;
		}
		for (var listsetfor : list) {
			listClassification.add(listsetfor.trim());
		}
		String classification = listClassification.toString().substring(1, listClassification.toString().length() - 1);
		Book book = bookOp.get();
		Book bookinfo = new Book(book.getIsbn(), bookname, author, price, stock, book.getSales(), classification);
		res.setBook(bookinfo);
		bookDao.save(bookinfo);
		return res;
	}

//===============================================================================4.�ʶR���y
	@Override
	public BookRes buyBook(Map<String, Integer> map) {
		BookRes res = new BookRes();
		if (map.isEmpty()) {
			res.setMaessage("�S���ʶR������y");
			return res;
		}
		Book book = new Book();
		int total = 0;
		List<String> bookinfo = new ArrayList<>();
		for (var mapfor : map.entrySet()) {
			Optional<Book> bookOp = bookDao.findById(mapfor.getKey());
			if (!bookOp.isPresent() || mapfor.getValue() == null) {
				bookinfo.add("�s��:" + mapfor.getKey() + "�d�L����" + "�μƶq�����");
				continue;
			} else { // ���N�i��
				book = bookOp.get();
				bookinfo.add("�ѦW�N�� : " + book.getIsbn() + "�ѦW:" + book.getBookName() + "�Ӯѻ��� : " + book.getPrice()
						+ "�ʶR�ƶq : " + mapfor.getValue() + " �`�@ : " + (mapfor.getValue() * book.getPrice()));
				total += book.getPrice() * mapfor.getValue();
				int stoclTotal = book.getStock() - mapfor.getValue();
				int sales = book.getSales() + mapfor.getValue();
				if (book.getStock() < mapfor.getValue()) {
					res.setMaessage("�ѦW:" + book.getBookName() + " �ƶq����");
					return res;
				}
				book.setStock(stoclTotal);
				book.setSales(sales);
				book = bookDao.save(book);
			}
		}
		res.setBuylist(bookinfo);
		res.setMaessage("�`�@ : " + total);
		return res;
	}
	// ===================================================5.�d�߮��y(�T�ؤ覡) isbn/�@��/�ѦW

	@Override
	public BookRes searchBookInfo(String isbn, String author, String bookname) {
		Optional<Book> bookOp = bookDao.findById(isbn);
		Set<Book> booksetlist = new HashSet<>();
		BookRes res = new BookRes();
		Book book = new Book();
		if (bookOp.isPresent()) {
			book = bookOp.get();
			res.setBook(book);
			return res;
		}

		List<Book> authorlist = bookDao.findByAuthorOrBookName(author, bookname);
		if (authorlist.isEmpty()) {
			res.setMaessage("�䤣��");
			return res;
		}
		for (var authorfor : authorlist) {
			booksetlist.add(authorfor);
		}
		res.setBooklist(booksetlist);

		return res;
	}
	// ===================================================6

	@Override
	public BookRes salesTop5() {
		List<Book> salesToplist = bookDao.findTop5ByOrderBySalesDesc();
		BookRes res = new BookRes();
		res.setToplist(salesToplist);
		return res;
	}

}
