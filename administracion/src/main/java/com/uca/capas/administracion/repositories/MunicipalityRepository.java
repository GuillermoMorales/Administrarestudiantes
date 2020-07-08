package com.uca.capas.administracion.repositories;

import com.uca.capas.administracion.domain.Municipality;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {
	
	public List<Municipality> findAll(Sort sort);
	
}
