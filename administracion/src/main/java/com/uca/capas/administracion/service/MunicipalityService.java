package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.Municipality;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MunicipalityService {
    public List<Municipality> showAll() throws DataAccessException;
}
