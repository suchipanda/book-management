package za.co.africa.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column
	private String name;	
	@Column
	private String author;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="library_id")
	private Library library;

	
	
	

}
