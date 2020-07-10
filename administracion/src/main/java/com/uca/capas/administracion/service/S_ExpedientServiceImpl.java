package com.uca.capas.administracion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.administracion.domain.S_Expedient;
import com.uca.capas.administracion.repositories.S_ExpedientRepository;

@Service
public class S_ExpedientServiceImpl implements S_ExpedientService{

	@Autowired
	S_ExpedientRepository repo;
	
	@Override
	public Optional<S_Expedient> findById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<S_Expedient> findSubExpedientsById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return repo.findSubExpedientsById(id);
	}

}
