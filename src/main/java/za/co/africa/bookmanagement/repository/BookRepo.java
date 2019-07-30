package za.co.africa.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import za.co.africa.bookmanagement.model.Book;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface BookRepo extends JpaRepository<Book, Integer> {

}
