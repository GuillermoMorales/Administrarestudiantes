package com.uca.capas.administracion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import com.uca.capas.administracion.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	


}
