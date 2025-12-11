package com.example.BookStoreMgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStoreMgmt.Entity.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList,Integer>{

}
