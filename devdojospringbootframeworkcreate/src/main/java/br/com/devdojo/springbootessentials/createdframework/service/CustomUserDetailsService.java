package br.com.devdojo.springbootessentials.createdframework.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.devdojo.springbootessentials.createdframework.model.User;
import br.com.devdojo.springbootessentials.createdframework.repository.IUserRespository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	private final IUserRespository userRepository;
	
	@Autowired
	public CustomUserDetailsService(IUserRespository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userRepository.findByUsernameIgnoreCaseContaining(username)).orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isAdmin() ? authorityListAdmin : authorityListUser);
	}
	
}
