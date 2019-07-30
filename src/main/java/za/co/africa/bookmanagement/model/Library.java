package za.co.africa.bookmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Library {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;	
	
	@OneToMany(mappedBy = "library",cascade = CascadeType.REMOVE,orphanRemoval= true)
	private List<Book> books;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
	
	public Library() {}	

	public Library(int id, String name, List<Book> books, Address address) {		
		this.id = id;
		this.name = name;
		this.books = books;
		this.address = address;
	}
	
	

	
	
	

}
