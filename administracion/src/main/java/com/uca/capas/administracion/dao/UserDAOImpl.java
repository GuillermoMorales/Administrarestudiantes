package com.uca.capas.administracion.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;



public class UserDAOImpl {

	@PersistenceContext (unitName="modelo-persistence")
	EntityManager entityManager;
	

	
}
