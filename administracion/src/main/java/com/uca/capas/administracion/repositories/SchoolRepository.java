package com.uca.capas.administracion.repositories;

import com.uca.capas.administracion.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    // public List<School> ();

    Optional<School> findById(Integer id);

}
