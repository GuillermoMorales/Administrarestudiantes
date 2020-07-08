package com.uca.capas.administracion.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.capas.administracion.dao.ExpedientDAO;
import com.uca.capas.administracion.domain.Expedient;
import com.uca.capas.administracion.repositories.ExpedientRepository;

@Service
public class ExpedientServiceImpl implements ExpedientService {


	@Autowired
	ExpedientRepository expedientRepository;

	@PersistenceContext(unitName = "modelo-persistence")
	EntityManager entityManager;

	@Override
	public List<Expedient> findByName(String cadena) {
		// TODO Auto-generated method stub
		
		return expedientRepository.findByName(cadena);
	}

	@Override
	public List<Expedient> findBySurname(String cadena) {
		// TODO Auto-generated method stub
		
		return expedientRepository.findBySurname(cadena);
	}

	@Override
	public Expedient findById(Integer id) {
		// TODO Auto-generated method stub
		return expedientRepository.getOne(id);
	}

	@Override
	public List<Expedient> findByNameLike(String valor) {
		// TODO Auto-generated method stub
		return expedientRepository.findByNameLike(valor);
	}

	@Override
	public List<Expedient> findAllExpedients() {
		// TODO Auto-generated method stub
		return expedientRepository.findAllExpedients();
	}

	@Override
	public List<Expedient> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return expedientRepository.findAll();
	}

	@Override
	public void save(Expedient expedient) throws DataAccessException {
		// TODO Auto-generated method stub
		expedientRepository.save(expedient);
	}


}
