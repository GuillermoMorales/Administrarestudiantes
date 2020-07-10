package com.uca.capas.administracion.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.administracion.domain.S_Expedient;



public interface S_ExpedientRepository extends JpaRepository<S_Expedient, Integer>{
	Optional<S_Expedient> findById(Integer id);
	
	@Query(value = "SELECT * from public.subject_expedient where expedient_id_fk = :expedient_id_fk", nativeQuery = true)
    public Optional<S_Expedient> findSubExpedientsById(@Param("expedient_id_fk") Integer expedient_id_fk);
	
	

}
