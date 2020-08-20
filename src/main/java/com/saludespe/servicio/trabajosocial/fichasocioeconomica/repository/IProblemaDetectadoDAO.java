package com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.ProblemaDetectado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProblemaDetectadoDAO extends CrudRepository<ProblemaDetectado, Long> {

    @Query(value = "SELECT * FROM PROBLEMAS_DETECTADOS app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    List<ProblemaDetectado> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
