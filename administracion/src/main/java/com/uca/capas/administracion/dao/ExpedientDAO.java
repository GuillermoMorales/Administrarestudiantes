package com.uca.capas.administracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.administracion.domain.Expedient;


public interface ExpedientDAO {
	
	//insert
	public int insertExpedientId(Expedient id);
	public void updateExpedient(Expedient id);
}
