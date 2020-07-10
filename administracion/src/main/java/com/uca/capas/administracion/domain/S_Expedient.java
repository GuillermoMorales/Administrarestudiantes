package com.uca.capas.administracion.domain;

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

@Entity
@Table(schema = "public", name = "subject_expedient")
public class S_Expedient {
	
	@Id
	@GeneratedValue(generator="subject_expedient_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "subject_expedient_id_seq", sequenceName = "public.subject_expedient_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "subject_id_fk")
	private Integer subject_id_fk;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id")
    @JoinColumn(name = "subject_id_fk")
	private String subject;*/
	
	
	@Column(name = "expedient_id_fk")
	private Integer expedient_id_fk;
	
	
	@Column(name = "year")
	private Integer year;
	
	
	@Column(name = "semester")
	private Integer semester;
	
	
	@Column(name = "score")
	private Integer score;
	
	
	@Column(name = "result")
	private String result;
	
	

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
	

	/*public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}*/

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
