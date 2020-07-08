package com.uca.capas.administracion.repositories;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.administracion.domain.Expedient;




public interface ExpedientRepository extends JpaRepository<Expedient, Integer> {
	
	//Este metodo devolvera una lista de Expedients cuyo nombre sea IGUAL al enviado como parametro
	public List<Expedient> findByName(String cadena) throws DataAccessException;
    
    public List<Expedient> findBySurname(String cadena) throws DataAccessException;

    //Devuelve una lista de Expedients cuyo nombre Y apellido sea IGUAL a los enviados como parametro
    //public List<Expedient> findBySnombresAndSapellidos(String nombre, String apellido);

    //Devuelve una lista de Expedients cuyo nombre cumpla con el criterio dado (desde el controlador)
    public List<Expedient> findByNameLike(String valor);

    @Query(value = "SELECT * from public.expedient", nativeQuery = true)
    public List<Expedient> findAllExpedients();

    @Query(value = "SELECT * from public.expedient where id = :expedient", nativeQuery = true)
    public Expedient findExpedientById(@Param("expedient") Integer expedient);

    @Query(value = "SELECT * from public.expedient where name = ?1 or surname = ?2", nativeQuery = true)
    public List<Expedient> findExpedientsNombreApel(String name, String surname);

    public List<Expedient> findAll(Sort sort);

    
    //Devuelve los Expedients que sean activos (propiedad booleana bactivo = True)
    //No recibe ningún parametro
    //public List<Expedient> findByBactivoTrue();

    //Devuelve los Expedients que no esten activos (propiedad boolean bactivo = False)
    //No recibe ningún parametro
    //public List<Expedient> findByBactivoFalse();

    //Devuelve los Expedients cuya fecha de nacimiento sea posterior a la dada como parametro
    //public List<Expedient> findByFnacimientoAfter(Date fecha);

    //Devuelve los Expedients cuya fecha de nacimiento se encuentre entre los rangos enviados como parametro
    //f_nacimiento >= fecha1 AND f_nacimiento <= fecha2
    //o tambien como: f_nacimiento BETWEEN fecha1 AND fecha2
    //public List<Expedient> findByFnacimientoBetween(Date fecha1, Date fecha2);

    //Devuelve los Expedients que tengan la coleccion de nombres enviados como parametro
    //public List<Expedient> findBySnombresIn(List<String> nombres);

    }
