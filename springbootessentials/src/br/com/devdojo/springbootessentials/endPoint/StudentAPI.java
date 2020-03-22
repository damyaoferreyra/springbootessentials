package br.com.devdojo.springbootessentials.endPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.springbootessentials.model.Student;
import br.com.devdojo.springbootessentials.util.DateUtil;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;

@RestController
@RequestMapping("student")
public class StudentAPI {

	@Autowired
	private DateUtil dateUtil;
	
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Student> listAll() {
		System.out.println(dateUtil.formatLocalDateTimeToDatebaseStyle(LocalDateTime.now()));
		return asList(new Student("Deku"), new Student("Todoroki"));
	}
}
