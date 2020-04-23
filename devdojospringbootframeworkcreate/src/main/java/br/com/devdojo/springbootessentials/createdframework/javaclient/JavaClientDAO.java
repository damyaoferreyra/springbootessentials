package br.com.devdojo.springbootessentials.createdframework.javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.devdojo.springbootessentials.createdframework.adapter.PageableResponse;
import br.com.devdojo.springbootessentials.createdframework.handler.RestResponseExceptionHandler;
import br.com.devdojo.springbootessentials.createdframework.model.Student;

/**
 * 
 * @author ferreira
 * @since 11/04/2020
 * Used access endPoint and create User admin
 */
public class JavaClientDAO {

	private RestTemplate restTemplate = new RestTemplateBuilder()
			.rootUri("http://localhost:8080/v1/default/students")
			.basicAuthentication("damiao.ferreira", "1234")
			.errorHandler(new RestResponseExceptionHandler())
			.build();
	private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
			.rootUri("http://localhost:8080/v1/admin/students")
			.basicAuthentication("damiao.ferreira", "1234")
			.errorHandler(new RestResponseExceptionHandler())
			.build();
	
	/**
	 * Search student for id
	 * @param id
	 * @return student
	 */
	public Student findById(long id){
//		ResponseEntity<Student> studentEntity = restTemplate.getForEntity("/{id}", Student.class, 20);
//		System.out.println(studentEntity); // studentEntity.getBody() : Student
		return restTemplate.getForObject("/{id}", Student.class, 20);
	}
	
	/**
	 * List the student order for id,desc and name, asc
	 * @return List the Student
	 */
	public List<Student> listAll(){
		/**
		 * If not used Pageable
		 */
//		Student[] students = restTemplate.getForObject("/", Student[].class);
//		System.out.println(Arrays.toString(students));
		
		ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/?sort=id,desc&sort=name,asc",HttpMethod.GET, null,
				new ParameterizedTypeReference<PageableResponse<Student>>() {});
		
		return exchange.getBody().getContent();
	}
	
	public Student save(Student student) {
		ResponseEntity<Student> exchangeAdmin = restTemplateAdmin.
				exchange("/",HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), Student.class);
		
//		//type 2: type Student
//		Student postForObject = restTemplateAdmin.postForObject("/", studentAdmin, Student.class);

//		//type 3: type ResponseEntity
//		ResponseEntity<Student> postForEntity = restTemplateAdmin.postForEntity("/", studentAdmin, Student.class);
		
		return exchangeAdmin.getBody();
	}
	
	public void update(Student student) {
		restTemplateAdmin.put("/", student);
	}
	
	public void delete(long id) {
		restTemplateAdmin.delete("/{id}", id);
	}
	
	private static HttpHeaders createJSONHeader() {
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
