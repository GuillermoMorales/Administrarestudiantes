package com.uca.capas.administracion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "authorities_users")
public class AuthoritiesUsers {

	@Id
	@GeneratedValue(generator="authorities_users_id_authorities_users_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "authorities_users_id_authorities_users_seq", sequenceName = "public.authorities_users_id_authorities_users_seq", allocationSize = 1)
	@Column(name="id_authorities_users")
	private Integer ids;

	@Column(name="id_user")
	private Integer id_user;
	
	@Column(name="id_authority")
	private Integer id_authority;

	public Integer getIds() {
		return ids;
	}

	public void setId_authorities_users(Integer id_authorities_users) {
		this.ids = id_authorities_users;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_authority() {
		return id_authority;
	}

	public void setId_authority(Integer id_authority) {
		this.id_authority = id_authority;
	}
	
	
}
