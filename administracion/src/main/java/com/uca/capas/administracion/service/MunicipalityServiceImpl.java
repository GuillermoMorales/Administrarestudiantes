package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.Municipality;
import com.uca.capas.administracion.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    @Autowired
    MunicipalityRepository repo;

    @Override
    public List<Municipality> showAll() throws DataAccessException {
        return repo.findAll();
    }
}
