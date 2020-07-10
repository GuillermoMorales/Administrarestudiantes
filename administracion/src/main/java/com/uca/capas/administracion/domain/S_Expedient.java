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
	Integer seId;
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "subject_id_fk")
	Integer sId;
	
	
	
	@NotEmpty(message = "El campo nombre no puede quedar vacio")
	@Column(name = "expedient_id_fk")
	Integer eId;
	
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
	
	
	public Integer getSeId() {
		return seId;
	}
	public void setSeId(Integer seId) {
		this.seId = seId;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
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
