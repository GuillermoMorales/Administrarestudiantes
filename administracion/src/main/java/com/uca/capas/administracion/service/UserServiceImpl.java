package com.uca.capas.administracion.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	@Transactional
	public void save(User user) throws DataAccessException
	{
		repo.save(user);
	}
}
