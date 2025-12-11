//package com.example.BookStoreMgmt.Controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.BookStoreMgmt.Entity.BorrowedBook;
//import com.example.BookStoreMgmt.Entity.Student;
//import com.example.BookStoreMgmt.Repository.BorrowedBookRepository;
//import com.example.BookStoreMgmt.Repository.StudentRepository;
//
//@Controller
//public class BorrowedBookController {
//
//	private final BorrowedBookRepository borrowRepository;
//	private final StudentRepository studentRepository;
//
//	public BorrowedBookController(BorrowedBookRepository borrowRepository, StudentRepository studentRepository) {
//		this.borrowRepository = borrowRepository;
//		this.studentRepository = studentRepository;
//	}
//
//	// ✅ Show list of borrowed books
//	@GetMapping("/borrowed_books_list")
//	public String showBorrowedList(Model model) {
//		List<BorrowedBook> borrowedBooks = borrowRepository.findAll();
//		model.addAttribute("borrowedBooks", borrowedBooks);
//		return "borrowed_books_list";
//	}
//
//	// ✅ Show add form
//	@GetMapping("/borrowed/add")
//	public String showAddBorrowForm(Model model) {
//		model.addAttribute("borrowedBook", new BorrowedBook());
//		model.addAttribute("students", studentRepository.findAll()); // Load dropdown
//		return "add_borrowed_book";
//	}
//
//	// ✅ Handle save
//	@PostMapping("/borrowed/save")
//	public String saveBorrowedBook(@ModelAttribute BorrowedBook borrowedBook) {
//		// If studentName was submitted, link it to real Student entity
//		if (borrowedBook.getStudentName() != null && !borrowedBook.getStudentName().isEmpty()) {
//			Student student = studentRepository.findByName(borrowedBook.getStudentName());
//			if (student != null) {
//				borrowedBook.setStudent(student);
//			}
//		}
//		borrowRepository.save(borrowedBook);
//		return "redirect:/borrowed_books_list";
//	}
//
//	// ✅ Handle delete
//	@GetMapping("/borrowed/delete/{id}")
//	public String deleteBorrowedBook(@PathVariable Long id) {
//		borrowRepository.deleteById(id);
//		return "redirect:/borrowed_books_list";
//	}
//}

package com.example.BookStoreMgmt.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookStoreMgmt.Entity.BorrowedBook;
import com.example.BookStoreMgmt.Entity.Student;
import com.example.BookStoreMgmt.Repository.BorrowedBookRepository;
import com.example.BookStoreMgmt.Repository.StudentRepository;

@Controller
public class BorrowedBookController {

	private final BorrowedBookRepository borrowRepository;
	private final StudentRepository studentRepository;

	public BorrowedBookController(BorrowedBookRepository borrowRepository, StudentRepository studentRepository) {
		this.borrowRepository = borrowRepository;
		this.studentRepository = studentRepository;
	}

	// Show list of borrowed books
	@GetMapping("/borrowed_books_list")
	public String showBorrowedList(Model model) {
		List<BorrowedBook> borrowedBooks = borrowRepository.findAll();
		model.addAttribute("borrowedBooks", borrowedBooks);
		return "borrowed_books_list";
	}

	// Show add form
	@GetMapping("/borrowed/add")
	public String showAddBorrowForm(Model model) {
		model.addAttribute("borrowedBook", new BorrowedBook());
		model.addAttribute("students", studentRepository.findAll());
		return "add_borrowed_book";
	}

	// Handle save
	@PostMapping("/borrowed/save")
	public String saveBorrowedBook(@ModelAttribute BorrowedBook borrowedBook) {
		if (borrowedBook.getStudent() != null && borrowedBook.getStudent().getId() != null) {
			Student student = studentRepository.findById(borrowedBook.getStudent().getId())
					.orElseThrow(() -> new RuntimeException("Student not found"));
			borrowedBook.setStudent(student);
		}
		borrowedBook.setStatus("Not Returned");
		borrowedBook.setReturnDate(null); // blank initially
		borrowRepository.save(borrowedBook);
		return "redirect:/borrowed_books_list";
	}

	// Delete borrowed book
	@GetMapping("/borrowed/delete/{id}")
	public String deleteBorrowedBook(@PathVariable Long id) {
		borrowRepository.deleteById(id);
		return "redirect:/borrowed_books_list";
	}

	// Return book action
	@GetMapping("/borrowed/return/{id}")
	public String returnBook(@PathVariable Long id) {
		BorrowedBook book = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setStatus("Returned");
		book.setReturnDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		borrowRepository.save(book);
		return "redirect:/borrowed_books_list";
	}
}
