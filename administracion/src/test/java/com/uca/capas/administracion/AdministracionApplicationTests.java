package com.uca.capas.administracion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdministracionApplicationTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		User us = new User();
		us.setUsername("inmovil");
		us.setPass(encoder.encode("123"));	
		us.setEnabled(false);
		User retorno = repo.save(us);
		
		assertTrue(retorno.getPass().equalsIgnoreCase(us.getPass()));
		
	}

}
