package br.com.devdojo.springbootessentials.createdframework.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devdojo.springbootessentials.createdframework.model.Student;

/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

public interface IStudentRepository extends CrudRepository<Student, Long>{
	
	List<Student> findByNameIgnoreCaseContaining(String name);
	
}
