package br.com.devdojo.springbootessentials.createdframework.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.springbootessentials.createdframework.error.ResourceNotFoundException;
import br.com.devdojo.springbootessentials.createdframework.model.Student;
import br.com.devdojo.springbootessentials.createdframework.repository.IStudentRepository;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

/**
 * 
 * @author Damiao Ferreira
 * @since 14/03/2020
 */

@RestController
@RequestMapping("v1")
public class StudentAPI {
	
	private final IStudentRepository studentDAO;
	
	@Autowired
	public StudentAPI(IStudentRepository iStudentRepository) {
		this.studentDAO = iStudentRepository;
	}
	
	// list all student - with pagination
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = "default/students")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
	}
	
	// list specific student 
	//@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@GetMapping(path = "default/students/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") long id){
		verifyIfStudentExists(id);
		
		Optional<Student> student = studentDAO.findById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping(path = "default/students/findStudentByName/{name}")
	public ResponseEntity<?> findByStudentByName(@PathVariable("name") String name){
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}
	
	// create student	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping(path = "admin/students")
	public ResponseEntity<?> save(@Valid @RequestBody Student student){
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}
	
	// update from student
	@PutMapping(path = "admin/students")
	public ResponseEntity<?> update(@RequestBody Student student){
		verifyIfStudentExists(student.getId());
		studentDAO.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// remove student from studentList, view user request
	@DeleteMapping (path = "admin/students/{id}")
	@PreAuthorize("hasRole('ADMIN')") // filter authorization for method
	public ResponseEntity<?> delete(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails userDetails){
		System.out.println("User request: "+userDetails.getUsername());
		verifyIfStudentExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	private void verifyIfStudentExists(long id) {
		
		if(studentDAO.findById(id).isEmpty()) // not found object
			throw new ResourceNotFoundException("Student not found for ID:"+id);
		
	}
}
