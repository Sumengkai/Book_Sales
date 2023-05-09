package com.example.book_sales.service.ifs;

import java.util.Map;
import java.util.Set;

import com.example.book_sales.vo.BookRes;

public interface Bookifs {
	//----
	// 新增書本,修改書本等資料
	public BookRes addAndUpdateBook(String isbn, String bookname, String author, Integer price, Integer stock,
			Set<String> listset);
	//----
	//分類搜尋
	public BookRes searchClassiFication(Set<String> listset);
	//----
	//更新書籍
	public BookRes updateBook(String isbn,String bookname,String author,Integer price,Integer stock,Set<String> listset);
	//----
	//購買書籍
	public BookRes buyBook(Map<String,Integer> map);
	//----
	//藉由三種方式查詢書籍
	public BookRes searchBookInfo(String isbn,String author,String bookname);
	//----
	//銷售排行前五
	public BookRes salesTop5();
}
