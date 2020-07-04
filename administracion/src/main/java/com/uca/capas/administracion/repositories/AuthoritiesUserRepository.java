package com.uca.capas.administracion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.administracion.domain.AuthoritiesUsers;


public interface AuthoritiesUserRepository extends JpaRepository<AuthoritiesUsers, Integer> {
	
	AuthoritiesUsers findByIds(Integer id);
}
