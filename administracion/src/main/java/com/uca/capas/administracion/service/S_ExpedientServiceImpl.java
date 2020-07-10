package com.uca.capas.administracion.service;

import com.uca.capas.administracion.domain.S_Expedient;
import com.uca.capas.administracion.repositories.S_ExpedientRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class S_ExpedientServiceImpl implements S_ExpedientService {

    @Autowired
    S_ExpedientRepository repo;

    @Override
    public Optional<S_Expedient> findById(Integer id) throws DataAccessException {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }

    @Override
    public List<S_Expedient> findSubExpedientsById(Integer id) throws DataAccessException {
        // TODO Auto-generated method stub
        return repo.findSubExpedientsById(id);
    }

    @Override
    public List<S_Expedient> getByResult(Integer id, String result) throws DataAccessException {
        return repo.getByResult(id, result);
    }

    @Override
    public double getAvg(Integer id) throws DataAccessException {
        return repo.getAverage(id);
    }

    /*
    @Override
    public List<S_Expedient> findAllByExpedient_id_fkAndResult(Integer id, String result) {
        return repo.findAllByExpedient_id_fkAndResult(id, result);
    }
     */

}
