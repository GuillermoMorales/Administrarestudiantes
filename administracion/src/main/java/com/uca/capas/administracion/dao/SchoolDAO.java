package com.uca.capas.administracion.dao;

import com.uca.capas.administracion.domain.School;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface SchoolDAO {
    public List<School> showAll() throws DataAccessException;
}
