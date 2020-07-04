package com.uca.capas.administracion.dao;

import org.springframework.dao.DataAccessException;

import com.uca.capas.administracion.domain.User;

public interface UserDAO {
	public void save(User c) throws DataAccessException;

}
