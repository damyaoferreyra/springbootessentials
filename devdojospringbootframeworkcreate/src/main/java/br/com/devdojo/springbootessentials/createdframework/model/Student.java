package br.com.devdojo.springbootessentials.createdframework.model;


import javax.persistence.Entity;

/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

@Entity
public class Student extends AbstractEntity{

	private static final long serialVersionUID = 1355126095648326146L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
