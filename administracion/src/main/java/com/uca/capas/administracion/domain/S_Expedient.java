package com.uca.capas.administracion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "subject_expedient")
public class S_Expedient {
	
	@Id
	@GeneratedValue(generator="subject_expedient_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "subject_expedient_id_seq", sequenceName = "public.subject_expedient_id_seq", allocationSize = 1)
	@Column(name = "id")
	Integer id;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "subject_id_fk")
	Integer subject_id_fk;
	
	
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "expedient_id_fk")
	Integer expedient_id_fk;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "year")
	Integer year;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "semester")
	Integer semester;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "score")
	Integer score;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "result")
	String result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubject_id_fk() {
		return subject_id_fk;
	}

	public void setSubject_id_fk(Integer subject_id_fk) {
		this.subject_id_fk = subject_id_fk;
	}

	public Integer getExpedient_id_fk() {
		return expedient_id_fk;
	}

	public void setExpedient_id_fk(Integer expedient_id_fk) {
		this.expedient_id_fk = expedient_id_fk;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	

	

}
