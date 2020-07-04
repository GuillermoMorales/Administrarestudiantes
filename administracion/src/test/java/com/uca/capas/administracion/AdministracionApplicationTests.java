package com.uca.capas.administracion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.uca.capas.administracion.domain.AuthoritiesUsers;
import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.repositories.AuthoritiesUserRepository;
import com.uca.capas.administracion.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdministracionApplicationTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private AuthoritiesUserRepository repo2;
	
	@Autowired 
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		/*User us = new User();
		us.setUsername("admin");
		us.setPass(encoder.encode("123"));	
		us.setEnabled(true);
		User retorno = repo.save(us);*/
		
		AuthoritiesUsers id = new AuthoritiesUsers();
		id.setId_user(1);		
		id.setId_authority(1);
		AuthoritiesUsers retorno2 = repo2.save(id);
		
		
		//assertTrue(retorno.getPass().equalsIgnoreCase(us.getPass()));
		
		
	}

}
