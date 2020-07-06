package com.uca.capas.administracion.repositories;

import com.uca.capas.administracion.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findById(Integer id);
}
