package com.uca.capas.administracion.domain;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(schema = "public", name = "municipality")
public class Municipality {
    @Id
    @GeneratedValue(generator = "municipality_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "municipality_id_seq", sequenceName = "public.municipality_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer municipality_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "municipality")
    /*
    @JoinTable(
            name = "school",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
     */
    private Set<School> schools;

    public Integer getMunicipality_id() {
        return municipality_id;
    }

    public void setMunicipality_id(Integer municipality_id) {
        this.municipality_id = municipality_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }

}