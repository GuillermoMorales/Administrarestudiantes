package com.uca.capas.administracion.domain;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(schema = "public", name = "expedient")
public class Expedient {

	@Id
	@GeneratedValue(generator="expedient_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "expedient_id_seq", sequenceName = "public.expedient_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "name")
    private String name;
	
	@NotEmpty(message = "El campo apellido no puede quedar vacio")
	@Column(name = "surname")
    private String surname;

	@NotEmpty(message = "El campo carnet no puede quedar vacio")
	@Length(min = 8, max = 8, message="Debe tener 8 caracteres")
	@Column(name = "carnet")
    private String carnet;
	
	@NotEmpty(message = "El campo direccion no puede quedar vacio")
	@Length(min = 10, max = 100, message="Debe entre 10 a 100 caracteres")
	@Column(name = "address")
    private String address;
	
	@NotEmpty(message = "El campo telefono de casa no puede quedar vacio")
	@Length(min = 8, max = 8, message="Debe tener 8 caracteres")
	@Column(name = "home_phone")
    private String home_phone;
	
	@NotEmpty(message = "El campo movil no puede quedar vacio")
	@Length(min = 8, max = 8, message="Debe tener 8 caracteres")
	@Column(name = "mobile_phone")
    private String mobile_phone;
	
	@NotEmpty(message = "El campo nombre de mama no puede quedar vacio")
	@Column(name = "mothers_name")
    private String mothers_name;
	
	@NotEmpty(message = "El campo nombre de papa no puede quedar vacio")
	@Column(name = "fathers_name")
    private String fathers_name;
	
	@NotNull(message = "El campo nombre de escuela no puede quedar vacio")
	@Column(name = "school_fk")
    private Integer school_fk;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id")
    @JoinColumn(name="school_fk")
    private School school;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private Date birth_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getMothers_name() {
		return mothers_name;
	}

	public void setMothers_name(String mothers_name) {
		this.mothers_name = mothers_name;
	}

	public String getFathers_name() {
		return fathers_name;
	}

	public void setFathers_name(String fathers_name) {
		this.fathers_name = fathers_name;
	}

	public Integer getSchool_fk() {
		return school_fk;
	}

	public void setSchool_fk(Integer school_fk) {
		this.school_fk = school_fk;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
	public String getBirthDelegate(){
		if(this.birth_date == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String shortdate = sdf.format(this.birth_date.getTime());
			return shortdate;
		}
	}
	
	public String getAgeDelegate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.birth_date);
		if (this.birth_date == null) return "";
		else {
			LocalDate localFnacimiento = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
			int edad = Period.between(localFnacimiento, LocalDate.now()).getYears();
			return new Integer(edad).toString();
		}
	}
	
	
    
	
}