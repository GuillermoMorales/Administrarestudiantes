package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.Subject;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    public List<Subject> showAll() throws DataAccessException;

    public Optional<Subject> findById(Integer id) throws DataAccessException;

    public void save(Subject subject) throws DataAccessException;
}
