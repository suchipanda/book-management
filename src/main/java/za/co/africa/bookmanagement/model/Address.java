package za.co.africa.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zip_Code;
	

}
