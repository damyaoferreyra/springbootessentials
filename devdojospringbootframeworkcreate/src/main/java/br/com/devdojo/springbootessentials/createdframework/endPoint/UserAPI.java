package br.com.devdojo.springbootessentials.createdframework.endPoint;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.devdojo.springbootessentials.createdframework.model.User;
import br.com.devdojo.springbootessentials.createdframework.repository.IUserRespository;

@RestController
@RequestMapping("v1")
public class UserAPI {

	private final IUserRespository userDAO;
	
	public UserAPI(IUserRespository userDAO) {
		this.userDAO = userDAO;
	}
	
	@PostMapping(path = "test/user")
	public ResponseEntity<?> save(@Valid @RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return new ResponseEntity<>(userDAO.save(user), HttpStatus.OK);
	}
}
