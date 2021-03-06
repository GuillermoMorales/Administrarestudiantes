package com.uca.capas.administracion.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(schema = "public", name = "school")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class School {
    @Id()
    @GeneratedValue(generator = "school_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "school_id_seq", sequenceName = "public.school_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "municipality_fk")
    private Integer municipality_fk;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id")
    @JoinColumn(name = "municipality_fk")
    private Municipality municipality;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Expedient> expedients;

    public List<Expedient> getExpedients() {
        return expedients;
    }

    public void setExpedients(List<Expedient> expedients) {
        this.expedients = expedients;
    }

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

    public Integer getMunicipality_fk() {
        return municipality_fk;
    }

    public void setMunicipality_fk(Integer municipality_fk) {
        this.municipality_fk = municipality_fk;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}