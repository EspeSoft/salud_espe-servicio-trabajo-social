package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.Problema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProblemaDAO  extends CrudRepository<Problema, Long> {

    @Query(value = "SELECT * FROM PROBLEMA app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<Problema> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
