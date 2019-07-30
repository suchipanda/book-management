package za.co.africa.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.africa.bookmanagement.model.Book;
import za.co.africa.bookmanagement.model.Library;
import za.co.africa.bookmanagement.service.LibraryService;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value ="/createlib", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> createLibrary(@RequestBody Library library){
		libraryService.createLibrary(library);
		return new ResponseEntity<>(library, HttpStatus.CREATED);
		
	}
	@RequestMapping(value ="/getAllLibrary", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Library>> getAllLibrary(){
		List<Library> libs = libraryService.findAllLibrary();
		return new ResponseEntity<>(libs, HttpStatus.OK);
		
	}
}
