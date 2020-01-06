package za.co.africa.bookmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.africa.bookmanagement.model.Book;
import za.co.africa.bookmanagement.model.Library;
import za.co.africa.bookmanagement.service.BookService;
import za.co.africa.bookmanagement.service.LibraryService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value ="/addbook/{id}", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Book> createBook(@PathVariable("id") int id , @RequestBody Book book){
		Library library = libraryService.findLibraryById(id);
		
		
		
			book.setLibrary(library);
			bookservice.createBook(book);
				
		return new ResponseEntity<>(book, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/getbook/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> getBookById(@PathVariable("id") int id){
		ResponseEntity<Object> responseEntity = null;
		Book book = bookservice.getBookById(id);
		if(book != null) {
			responseEntity = new ResponseEntity<>(book,HttpStatus.OK); 
			
		}else {
			responseEntity = new ResponseEntity<>("Book is not present", HttpStatus.OK);
		}			
				
		return responseEntity;
		
	}	
	@RequestMapping(value ="/getBoooks", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookservice.findAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/updateBook/{id}", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> updateBookById(@PathVariable("id") int id, @RequestBody Book book){
		
		ResponseEntity<Object> responseEntity = null;
		Book dataBook = bookservice.getBookById(id);
		Library library =libraryService.findLibraryById(book.getLibrary().getId());
		
		
		
		if(dataBook != null) {
			dataBook.setName(book.getName());
			dataBook.setAuthor(book.getAuthor());
			dataBook.setPrice(book.getPrice());
			
			if(library != null) {
				dataBook.setLibrary(library);
			}
			
			boolean isUpdated = bookservice.updateBook(dataBook);
			
			if(isUpdated) {
				responseEntity = new ResponseEntity<>(dataBook, HttpStatus.OK);
			}
		}

		return responseEntity;
	}
	
	@RequestMapping(value="deleteBook/{id}",method = RequestMethod.DELETE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> deleteBookById(@PathVariable("id") int id){
		 bookservice.deleteBookById(id);		
		return new ResponseEntity<Object>("Book Object deleted by id :"+id, HttpStatus.OK);
		
	}
}
	


