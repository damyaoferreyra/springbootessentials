package br.com.devdojo.springbootessentials.createdframework.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.devdojo.springbootessentials.createdframework.model.Student;

/**
 * 
 * @author Damiao Ferreira
 * @since 15/03/2020
 */

public interface IStudentRepository extends PagingAndSortingRepository<Student, Long>{
	
	List<Student> findByNameIgnoreCaseContaining(String name);
	
}
