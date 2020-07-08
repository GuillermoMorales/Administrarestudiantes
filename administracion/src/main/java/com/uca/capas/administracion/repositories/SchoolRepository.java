package com.uca.capas.administracion.repositories;



import com.uca.capas.administracion.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    // public List<School> ();

    Optional<School> findById(Integer id);
    
    @Query(value = "SELECT * from public.school where municipality_fk = :school", nativeQuery = true)
    public List<School> findSchoolByMunicipality_fk(@Param("school") Integer school);

}
