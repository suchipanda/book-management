package za.co.africa.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
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
	
	public Address() {}

	public Address(int id, String city, String state, String zip_Code) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.zip_Code = zip_Code;
	}
	
	

}
