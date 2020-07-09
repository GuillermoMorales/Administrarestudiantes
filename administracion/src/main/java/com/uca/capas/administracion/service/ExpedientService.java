package com.uca.capas.administracion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;


import com.uca.capas.administracion.domain.Expedient;



public interface ExpedientService {
	
	public List<Expedient> findByName(String name);
    
    public List<Expedient> findBySurname(String surname);
    
   

    public Optional<Expedient> findById(Integer id) throws DataAccessException;
    
    public List<Expedient> findByNameLike(String valor);
    
    public List<Expedient> findBySurnameLike(String valor);


    public List<Expedient> findAllExpedients();
    
   
    public List<Expedient> findAll(Sort sort);

    public void save(Expedient expedient) throws DataAccessException;
	
	
}
