package za.co.africa.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.africa.bookmanagement.model.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
