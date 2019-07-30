package za.co.africa.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.africa.bookmanagement.model.Library;
import za.co.africa.bookmanagement.repository.LibraryRepo;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo; 

	public Library createLibrary(Library library) {
		return libraryRepo.save(library);
		
	}

	public Library findLibraryById(int id) {
		return libraryRepo.findById(id).orElse(null);
		
		
	}

	public List<Library> findAllLibrary() {		
		return libraryRepo.findAll();
	}

}
