package com.example.BookStoreMgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStoreMgmt.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String studentName);
}
