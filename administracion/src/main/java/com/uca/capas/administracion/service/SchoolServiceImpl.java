package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.School;
import com.uca.capas.administracion.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository repo;

    @Override
    public List<School> showAll() throws DataAccessException {
        return repo.findAll();
    }

    @Override
    public Optional<School> findById(Integer id) throws DataAccessException {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public void save(School school) throws DataAccessException {
        repo.save(school);
    }
}
