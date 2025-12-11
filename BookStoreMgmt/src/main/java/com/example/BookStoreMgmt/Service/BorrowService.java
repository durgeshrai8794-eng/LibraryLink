package com.example.BookStoreMgmt.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStoreMgmt.Entity.BorrowedBook;
import com.example.BookStoreMgmt.Repository.BorrowedBookRepository;

@Service
public class BorrowService {

	private final BorrowedBookRepository borrowRepository;

	public BorrowService(BorrowedBookRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}

	public List<BorrowedBook> getAllBorrowRecords() {
		return borrowRepository.findAll();
	}

	public BorrowedBook saveBorrow(BorrowedBook borrow) {
		return borrowRepository.save(borrow);
	}

	public void returnBook(Long id) {
		BorrowedBook borrow = borrowRepository.findById(id).orElseThrow();
		borrow.setReturnDate(true);
		borrowRepository.save(borrow);
	}
}
