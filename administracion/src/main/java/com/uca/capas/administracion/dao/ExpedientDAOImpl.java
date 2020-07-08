package com.uca.capas.administracion.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.uca.capas.administracion.domain.Expedient;



public class ExpedientDAOImpl implements ExpedientDAO {
	@PersistenceContext(unitName = "modelo-persistence")
    EntityManager entityManager;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertExpedientId(Expedient e) {
		
		SimpleJdbcInsert jdbcInsert= new SimpleJdbcInsert(jdbcTemplate)
				.withSchemaName("public")
				.withTableName("expedient")
				//PK
				.usingGeneratedKeyColumns("id");
		
		//Valores del insert
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("name", e.getName());
		parametros.put("surname", e.getSurname());
		parametros.put("carnet", e.getCarnet());
		parametros.put("address", e.getAddress());
		parametros.put("home_phone", e.getHome_phone());
		parametros.put("mobile_phone", e.getMobile_phone());
		parametros.put("mothers_name", e.getMothers_name());
		parametros.put("fathers_name", e.getFathers_name());
		parametros.put("school_fk", e.getSchool_fk());
		
		
		
		//El metodo executeAndReturnKey devuelve la llave primaria generada en el insert
		Number id_generated=jdbcInsert.executeAndReturnKey(parametros);
		
		return id_generated.intValue();
		
	}

	private static final String sql= "UPDATE store.cliente SET s_nombres = ?, s_apellidos = ?, f_nacimiento = ?, b_activo = ? WHERE c_cliente=?";
	
	@Override
	public void updateExpedient(Expedient e) {
		// TODO Auto-generated method stub
		Object[] parametros = new Object[] {e.getName(), e.getSurname(),e.getCarnet(),e.getAddress(), e.getHome_phone(), e.getHome_phone(), e.getFathers_name(), e.getFathers_name(), e.getSchool()};
		jdbcTemplate.update(sql, parametros);
	}
	
}
