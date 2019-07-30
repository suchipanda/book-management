package za.co.africa.bookmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column
	private String name;	
	@Column
	private String author;
	@Column
	private double price;
	
	public Book() {}
	
	
	
	public Book(int id, String name, String author, double price,Library library) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.library = library;
	}



	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name ="library_id")
	private Library library;

	
	
	

}
