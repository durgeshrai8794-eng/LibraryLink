package com.example.BookStoreMgmt.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BookStoreMgmt.Entity.Book;

@Repository 
public interface BookRepository extends JpaRepository<Book,Integer>{ 
	static Optional<Book> findById(Long id) { // TODO Auto-generated method stub 
		return null; 
	} 
}


