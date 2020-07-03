package com.uca.capas.administracion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.uca.capas.administracion.domain.Authority;
import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User us = repo.findByUsername(username);
		//Mapear nuestra lista de Authority con la de spring security 
	    List grantList = new ArrayList();
	    
	    for (Authority authority: us.getAuthority()) {
	        // ROLE_USER, ROLE_ADMIN,..
	        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
	            grantList.add(grantedAuthority);
	    }
			
	    //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
	    UserDetails user = (UserDetails) new org.springframework.security.core.userdetails.User(us.getUsername(), us.getPass(), grantList);
	         return user;
	    }
		
	}


