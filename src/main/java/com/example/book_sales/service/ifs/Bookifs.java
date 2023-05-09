package com.example.book_sales.service.ifs;

import java.util.Map;
import java.util.Set;

import com.example.book_sales.vo.BookRes;

public interface Bookifs {
	//----
	// �s�W�ѥ�,�ק�ѥ������
	public BookRes addAndUpdateBook(String isbn, String bookname, String author, Integer price, Integer stock,
			Set<String> listset);
	//----
	//�����j�M
	public BookRes searchClassiFication(Set<String> listset);
	//----
	//��s���y
	public BookRes updateBook(String isbn,String bookname,String author,Integer price,Integer stock,Set<String> listset);
	//----
	//�ʶR���y
	public BookRes buyBook(Map<String,Integer> map);
	//----
	//�ǥѤT�ؤ覡�d�߮��y
	public BookRes searchBookInfo(String isbn,String author,String bookname);
	//----
	//�P��Ʀ�e��
	public BookRes salesTop5();
}
