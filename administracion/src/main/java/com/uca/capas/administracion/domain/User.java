package com.uca.capas.administracion.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(schema = "public", name = "user")
public class User {

	@Id
	@GeneratedValue(generator="user_id_user_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_user_seq", sequenceName = "public.user_id_user_seq", allocationSize = 1)
	@Column(name="id_user")
	private Integer id_user;

	@Size(message="El campo no debe de tener más de 15 caracteres", max=15)
	@Size(message="El campo no debe de tener menos de 5 caracteres", min=5)
	@Pattern(regexp="^\\S.*$",message="Usuario no puede estar vacío")
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="username")
	private String username;

	@Pattern(regexp="^\\S.*$",message="Contraseña no tener solo espacio")
	@Size(message="El campo no debe de tener menos de 8 caracteres", min=8)
	@NotEmpty(message="El Contraseña no debe estar vacío")
	@Column(name="pass")
	private String pass;

	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="inserted")
	private boolean inserted;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_authority"))
	private Set<Authority> authority;

//Getters y Setters
	

	public boolean isInserted() {
		return inserted;
	}

	public void setInserted(boolean inserted) {
		this.inserted = inserted;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}

	
	
}