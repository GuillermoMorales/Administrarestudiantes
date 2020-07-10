package com.uca.capas.administracion.repositories;

import com.uca.capas.administracion.domain.S_Expedient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface S_ExpedientRepository extends JpaRepository<S_Expedient, Integer> {
    Optional<S_Expedient> findById(Integer id);

    @Query(value = "SELECT * FROM subject_expedient WHERE expedient_id_fk = :id AND result = :result", nativeQuery = true)
    public List<S_Expedient> getByResult(@Param("id") Integer id, @Param("result") String result);

    @Query(value = "SELECT AVG(score) FROM subject_expedient WHERE expedient_id_fk = :id", nativeQuery = true)
    public List<S_Expedient> getAverage(@Param("id") Integer id);

    @Query(value = "SELECT * from public.subject_expedient where expedient_id_fk = :expedient_id_fk", nativeQuery = true)
    public List<S_Expedient> findSubExpedientsById(@Param("expedient_id_fk") Integer expedient_id_fk);
}
