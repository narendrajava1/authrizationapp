package com.auth.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.core.userdetails.User;

import com.auth.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);

//	Optional<User> findTopStartsWithByOrderByIdDesc(String id);

//	List<User> findStartsWithByOrderByIdDesc(Long id);
	Long deleteByUsername(String username);
}