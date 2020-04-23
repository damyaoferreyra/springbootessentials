package br.com.devdojo.springbootessentials.createdframework.javaclient;

import java.util.List;

import br.com.devdojo.springbootessentials.createdframework.model.Student;

//import java.util.Arrays;
//import java.util.List;

/**
 * 
 * @author ferreira
 * @since 08/04/2020
 * 
 */
public class JavaSpringClientTest {

	public static void main(String[] args) {

		JavaClientDAO dao = new JavaClientDAO();
		System.out.println(dao.findById(20));
		
		List<Student> students = dao.listAll();
		System.out.println(students);
		
		dao.delete(20);
				
	}

}
