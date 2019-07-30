package za.co.africa.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.africa.bookmanagement.model.Book;
import za.co.africa.bookmanagement.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;

	public Book createBook(Book book) {
		return bookRepo.save(book);
		
		
	}

	public Book getBookById(int id) {
		return bookRepo.findById(id).orElse(new Book());
		
	}

	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}

	public boolean updateBook(Book dataBook) {
		bookRepo.save(dataBook);
		return true;
	}

	public void deleteBookById(int id) {
		bookRepo.deleteById(id);
		
	}
	

}
