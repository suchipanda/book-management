package za.co.africa.bookmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import za.co.africa.bookmanagement.model.Address;
import za.co.africa.bookmanagement.model.Book;
import za.co.africa.bookmanagement.model.Library;
import za.co.africa.bookmanagement.repository.LibraryRepo;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {
	
	@InjectMocks
	LibraryService libraryService;
	
	@Mock
	LibraryRepo libraryRepo;
	
	@Test
	public void createLibraryTest() {
		List<Book> listBook = Arrays.asList(new Book(1, "Java", "ABC", 100.5,new Library()));
		Library expectedLibrary= Library.builder()
				.id(1)
				.name("Sandton")
				.books(listBook)
				.address(new Address())
				.build();
		when(libraryRepo.save(any(Library.class))).thenReturn(expectedLibrary);
		Library actualLibrary = libraryService.createLibrary(expectedLibrary);
		assertEquals(expectedLibrary, actualLibrary);
				
				
	}

}
