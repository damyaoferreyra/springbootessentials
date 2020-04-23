package br.com.devdojo.springbootessentials.createdframework.model;


import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

@Entity
public class Student extends AbstractEntity{

	private static final long serialVersionUID = 1355126095648326146L;
	
	// Overwrite the error message 
	@NotEmpty(message = "student name is required")
	private String name;
	
	@NotEmpty(message = "student e-mail is required")
	@Email(message = "input valid e-mail")
	private String email;
	
	public Student() {
		
	}
	
	public Student(String name,@Email String email) {
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
	
}
