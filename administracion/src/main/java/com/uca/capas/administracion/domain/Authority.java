package com.uca.capas.administracion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_authority")
	private Long id_authority;
	
	@Column(name="authority")
	private String authority;
	
	public Long getId_authority() {
		return id_authority;
	}

	public void setId_authority(Long id_authority) {
		this.id_authority = id_authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}