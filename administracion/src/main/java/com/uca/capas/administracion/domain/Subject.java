package com.uca.capas.administracion.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(schema = "public", name = "subject")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Subject {
    @Id()
    @GeneratedValue(generator = "subject_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "subject_id_seq", sequenceName = "public.subject_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    @NotEmpty(message = "El codigo no debe estar vacío")
    private String code;

    @Column(name = "description")
    @NotEmpty(message = "La descripcion no debe estar vacía")
    private String description;

    @Column(name = "status")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}