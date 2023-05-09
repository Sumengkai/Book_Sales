package com.example.book_sales.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book_sales.Entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book,String>{
public List<Book> findByClassificationIn(List<String> list);
public List<Book> findByAuthorOrBookName(String author ,String bookname);
public List<Book> findTop5ByOrderBySalesDesc();
public List<Book> findByClassificationContaining(Set<String> listset);
}
