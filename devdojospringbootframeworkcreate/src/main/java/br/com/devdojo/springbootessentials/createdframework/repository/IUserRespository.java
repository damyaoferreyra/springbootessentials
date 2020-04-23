package br.com.devdojo.springbootessentials.createdframework.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.devdojo.springbootessentials.createdframework.model.User;

/**
 * 
 * @author ferreira
 * @since 07/04/2020
 */
public interface IUserRespository extends PagingAndSortingRepository<User, Long>{
	User findByUsernameIgnoreCaseContaining(String username);
}
