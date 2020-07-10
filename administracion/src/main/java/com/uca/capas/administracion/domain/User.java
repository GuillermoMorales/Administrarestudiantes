package com.uca.capas.administracion.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;




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
	private Boolean enabled;
	
	@Column(name="inserted")
	private Boolean inserted;
	
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "birth_date")
	private Date fecha;
	
	@Size(message="El campo no debe de tener más de 15 caracteres", max=15)
	@Size(message="El campo no debe de tener menos de 5 caracteres", min=5)
	@Pattern(regexp="^\\S.*$",message="Nombre no puede estar vacío")
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="name")
	private String name;
	
	@Size(message="El campo no debe de tener más de 15 caracteres", max=15)
	@Size(message="El campo no debe de tener menos de 5 caracteres", min=5)
	@Pattern(regexp="^\\S.*$",message="Apellido no puede estar vacío")
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="userlastname")
	private String userlastname;
	
	@Size(message="El campo no debe de tener más de 60 caracteres", max=60)
	@Size(message="El campo no debe de tener menos de 5 caracteres", min=5)
	@Pattern(regexp="^\\S.*$",message="Direccion no puede estar vacío")
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="adress")
	private String adress;
	
	@Pattern(regexp="^\\S.*$",message="Rol no puede estar vacío")
	@NotEmpty(message="El campo no debe estar vacío")
	@Column(name="role")
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_municipality_fk")
	private Municipality municipality;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_authority"))
	private Set<Authority> authority;

//Getters y Setters
	

	public Date getFecha() {
		return fecha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Municipality getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getInserted() {
		return inserted;
	}

	public void setInserted(Boolean inserted) {
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

	

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	
	//Delegate para conversion de fecha
		public String getFechaDelegate(){
			if(this.fecha == null){
				return "";
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String shortdate = sdf.format(this.fecha.getTime());
				return shortdate;
			}
		}
	
	public String getEdadDelegate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.fecha);
		if (this.fecha == null) return "";
		else {
			LocalDate localFnacimiento = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
			int edad = Period.between(localFnacimiento, LocalDate.now()).getYears();
			return new Integer(edad).toString();
		}
	}
	
	public String getBactivoDelegate(){
		if(this.enabled== null){
			return "";
		}
		else{
			if(this.enabled) return "ACTIVO";
			else return "INACTIVO";
		}
	}

	
	
}
