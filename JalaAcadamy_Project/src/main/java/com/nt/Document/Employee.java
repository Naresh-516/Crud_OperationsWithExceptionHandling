package com.nt.Document;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="Name cannot be Blank")
	private String name;
	@Email(message="Invalid Email")
	private String email;
	@NotNull
	private Long mobileNumber;
	@NotNull
	private Date dob;
	@NotNull
	private String gender;
	@NotNull
	private String address;
	@NotNull
	private String country;
	@NotNull
	private String city;
	@NotNull
	private String skills;
	

}
