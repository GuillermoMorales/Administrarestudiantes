package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.School;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    public List<School> showAll() throws DataAccessException;

    public Optional<School> findById(Integer id) throws DataAccessException;

    public void save(School school) throws DataAccessException;
}
