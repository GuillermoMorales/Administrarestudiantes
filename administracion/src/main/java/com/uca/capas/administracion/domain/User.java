package com.uca.capas.administracion.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Entity
@Table(schema = "public", name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "user_id_user_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_id_user_seq", sequenceName = "public.user_id_user_seq", allocationSize = 1)
    @Column(name = "id_user")
    private Integer id_user;

    @Size(message = "El campo no debe de tener más de 15 caracteres", max = 15)
    @Size(message = "El campo no debe de tener menos de 5 caracteres", min = 5)
    @Pattern(regexp = "^\\S.*$", message = "Usuario no puede estar vacío")
    @NotEmpty(message = "El campo no debe estar vacío")
    @Column(name = "username")
    private String username;

    @Pattern(regexp = "^\\S.*$", message = "Contraseña no tener solo espacio")
    @Size(message = "El campo no debe de tener menos de 8 caracteres", min = 8)
    @NotEmpty(message = "El Contraseña no debe estar vacío")
    @Column(name = "")
    private String pass;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "inserted")
    private boolean inserted;

    @NotEmpty(message = "Este campo no puede estar vacío")
    @Pattern(regexp = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((2[1-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((2[1-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((2[1-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((2[1-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$", message = "Formato debe ser dd/mm/yyyy")
    @Column(name = "birth_date")
    private Date fecha;

    @Size(message = "El campo no debe de tener más de 15 caracteres", max = 15)
    @Size(message = "El campo no debe de tener menos de 5 caracteres", min = 5)
    @Pattern(regexp = "^\\S.*$", message = "Nombre no puede estar vacío")
    @NotEmpty(message = "El campo no debe estar vacío")
    @Column(name = "name")
    private String name;

    @Size(message = "El campo no debe de tener más de 15 caracteres", max = 15)
    @Size(message = "El campo no debe de tener menos de 5 caracteres", min = 5)
    @Pattern(regexp = "^\\S.*$", message = "Apellido no puede estar vacío")
    @NotEmpty(message = "El campo no debe estar vacío")
    @Column(name = "userlastname")
    private String userlastname;

    @Size(message = "El campo no debe de tener más de 60 caracteres", max = 60)
    @Size(message = "El campo no debe de tener menos de 5 caracteres", min = 5)
    @Pattern(regexp = "^\\S.*$", message = "Direccion no puede estar vacío")
    @NotEmpty(message = "El campo no debe estar vacío")
    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_municipality_fk")
    private Municipality municipality;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_authority"))
    private Set<Authority> authority;

//Getters y Setters


    public Date getFecha() {
        return fecha;
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
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public boolean isInserted() {
        return inserted;
    }

    public void setInserted(boolean inserted) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }


}