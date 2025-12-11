//package com.example.BookStoreMgmt.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class BorrowedBook {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private String bookTitle;
//	private String author;
//	private String borrowDate;
//	private String returnDate;
//
//	// ✅ temporary field for your form
//	private String studentName;
//
//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	private Student student; // link each borrowed book to a student
//
//	// ✅ Option 1: Add returned field (default false)
//	private boolean returned = false;
//
//	// ----- Getters and Setters -----
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getBookTitle() {
//		return bookTitle;
//	}
//
//	public void setBookTitle(String bookTitle) {
//		this.bookTitle = bookTitle;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public String getBorrowDate() {
//		return borrowDate;
//	}
//
//	public void setBorrowDate(String borrowDate) {
//		this.borrowDate = borrowDate;
//	}
//
//	public String getReturnDate() {
//		return returnDate;
//	}
//
//	public void setReturnDate(String returnDate) {
//		this.returnDate = returnDate;
//	}
//
//	public String getStudentName() {
//		return studentName;
//	}
//
//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	// ✅ Getter & Setter for returned
//	public boolean isReturned() {
//		return returned;
//	}
//
//	public void setReturned(boolean returned) {
//		this.returned = returned;
//	}
//
//	// ⚠️ Remove this unused method if possible, but I’ll keep it since you said
//	// don't change others
//	public void setReturnDate(boolean b) {
//		// TODO Auto-generated method stub
//	}
//}

package com.example.BookStoreMgmt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String bookTitle;
	private String author;
	private String borrowDate;
	private String returnDate; // stays blank until returned

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	private String status = "Not Returned"; // default

	// ----- Getters and Setters -----
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReturnDate(boolean b) {
		// TODO Auto-generated method stub

	}

	public Book getBook() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBook(Book book) {
		// TODO Auto-generated method stub

	}
}
