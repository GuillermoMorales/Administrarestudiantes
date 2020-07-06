package com.uca.capas.administracion.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class SchoolDAOImpl {
    @PersistenceContext(unitName = "modelo-persistence")
    EntityManager entityManager;
}
