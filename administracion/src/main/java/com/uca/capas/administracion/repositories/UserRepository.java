package com.uca.capas.administracion.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import com.uca.capas.administracion.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);
	

}
