package com.sg.presentation.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Donacion")
public class Donacion {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String firstName;
	private String pass;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String emailId;
	
	public Donacion() {
		
	}
	
	public Donacion(String firstName, String pass, String emailId) {
		this.firstName = firstName;
		this.pass = pass;
		this.emailId = emailId;
	}
}
