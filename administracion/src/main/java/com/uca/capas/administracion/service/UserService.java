package com.uca.capas.administracion.service;

import org.springframework.dao.DataAccessException;

import com.uca.capas.administracion.domain.User;

public interface UserService {
	
	public void save(User user) throws DataAccessException;

}
