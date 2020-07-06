package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.Subject;
import com.uca.capas.administracion.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository repo;

    @Override
    public List<Subject> showAll() throws DataAccessException {
        return repo.findAll();
    }

    @Override
    public Optional<Subject> findById(Integer id) throws DataAccessException {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public void save(Subject school) throws DataAccessException {
        repo.save(school);
    }
}
