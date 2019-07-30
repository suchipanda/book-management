package za.co.africa.bookmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import za.co.africa.bookmanagement.model.Book;
import za.co.africa.bookmanagement.model.Library;
import za.co.africa.bookmanagement.repository.BookRepo;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepo bookRepo;
	
	@Test
	public void getBookByIdTest() {
		Optional<Book> book = Optional.of(new Book(1, "Java", "Santanu",200.7, new Library()));
		
				
		when(bookRepo.findById(1)).thenReturn(book);		
		Book actualBook = bookService.getBookById(1);
		assertEquals(book.get(), actualBook);
	}
	
	@Test
	public void createBookTest() {
		Book book = Book.builder()
				.id(1)
				.name("SpringBoot")
				.author("ABC")
				.library(new Library())
				.build();
		//Book count = 1;
		when(bookRepo.save(any(Book.class))).thenReturn(book);
		Book actualBook = bookService.createBook(book);
		assertEquals(book, actualBook);
	}
	
	@Test
	public void findAllBooksTest() {
		List<Book> books = Arrays.asList(
				new Book(1, "Java", "Santanu", 100.5,new Library()),
				new Book(2, "Angular", "Suchi", 200.5, new Library()),
				new Book(3, "Spring", "Chinu", 300.5, new Library()));				
			
			when(bookRepo.findAll()).thenReturn(books);
			List<Book> actualBooks= bookService.findAllBooks();
			assertEquals(books,actualBooks );
		
	}

}
