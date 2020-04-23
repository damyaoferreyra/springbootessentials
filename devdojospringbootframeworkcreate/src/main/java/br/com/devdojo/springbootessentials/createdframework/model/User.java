package br.com.devdojo.springbootessentials.createdframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author ferreira
 * @since 07/04/2020
 *
 */
@Entity
public class User extends AbstractEntity{
	
	private static final long serialVersionUID = -1545807963333736386L;

	@NotEmpty
	@Column(unique = true)
	private String username;
	
	@NotEmpty
	@JsonIgnore
	private String password;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private boolean admin;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
