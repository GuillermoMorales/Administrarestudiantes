package com.uca.capas.administracion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;


import com.uca.capas.administracion.domain.S_Expedient;

public interface S_ExpedientService {
	
	public Optional<S_Expedient> findById(Integer id) throws DataAccessException;
	
	public List<S_Expedient> findSubExpedientsById(Integer expedient_id_fk) throws DataAccessException;
	


}
