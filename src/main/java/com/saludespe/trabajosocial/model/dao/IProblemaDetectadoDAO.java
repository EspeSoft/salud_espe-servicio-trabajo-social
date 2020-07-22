package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.ProblemaDetectado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProblemaDetectadoDAO extends CrudRepository<ProblemaDetectado, Long> {

    @Query(value = "SELECT * FROM PROBLEMAS_DETECTADOSapp WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<ProblemaDetectado> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
