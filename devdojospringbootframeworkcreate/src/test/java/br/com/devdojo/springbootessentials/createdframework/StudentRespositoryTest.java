package br.com.devdojo.springbootessentials.createdframework;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.devdojo.springbootessentials.createdframework.model.Student;
import br.com.devdojo.springbootessentials.createdframework.repository.IStudentRepository;
import br.com.devdojo.springbootessentials.createdframework.repository.IUserRespository;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
/**
 * 
 * @author ferreira
 * @since 11/04/2020
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE) // used for DB current
public class StudentRespositoryTest {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private IUserRespository userRespository;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void createShouldPersistData() {
		
		Student student = new Student("joao", "joao.feijao@email.com");
		this.studentRepository.save(student);
		
		assertThat(student.getId()).isNotNull();
		assertThat(student.getName()).isNotEmpty();
		assertThat(student.getEmail()).isEqualTo("joao.feijao@email.com");
		
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Student s = new Student("Bob", "bob@hotmail.com");
		studentRepository.save(s);
		studentRepository.delete(s);
		assertThat(studentRepository.findById(s.getId())).isEmpty();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
		Student s = new Student("Bob", "bob@hotmail.com");
		studentRepository.save(s);
		
		s.setName("joao");
		s.setEmail("joao@hotmail.com");
		
		s = studentRepository.save(s);
		
		assertThat(s.getName()).isEqualTo("joao");
		assertThat(s.getEmail()).isEqualTo("joao@hotmail.com");
	}
	
	@Test
	public void findByNameIgnoreCaseContainingShouldIgnoreCase() {
		Student bob = new Student("Bob", "bob@hotmail.com");
		Student joao = new Student("Bob", "joao@hotmail.com");
		studentRepository.save(bob);
		studentRepository.save(joao);
		
		List<Student> students = studentRepository.findByNameIgnoreCaseContaining("bob");
		assertThat(students.size()).isEqualTo(2);
	}
	
	@Test
	public void createWhenNameIsNullShouldThrowConstraintViolationException() {
		Assertions.assertThrows(ConstraintViolationException.class, 
				()-> {studentRepository.save(new Student()); entityManager.flush();});
	}
	
	@Test
	public void createWhenEmailIsNullShouldThrowConstraintViolationException() {

		Student student = new Student();
		student.setName("Bob");
		
		Assertions.assertThrows(ConstraintViolationException.class, 
				()-> {studentRepository.save(student); entityManager.flush(); });
	}
	
	@Test
	public void createWhenEmailIsNotValidShouldThrowContaintViolationExcception() {
		
		Student student = new Student();
		student.setName("Bob");
		student.setEmail("bob@");
		Assertions.assertThrows(ConstraintViolationException.class, 
				()-> {studentRepository.save(student); entityManager.flush();});		
	}
	
}
