package br.com.devdojo.springbootessentials.createdframework.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

// anotação para classe não se persistida
@MappedSuperclass
public class AbstractEntity implements Serializable{


	private static final long serialVersionUID = -3819017437658537967L;
	@Id
	@SequenceGenerator(name = "hibernate_seq", sequenceName = "hibernate_id_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
