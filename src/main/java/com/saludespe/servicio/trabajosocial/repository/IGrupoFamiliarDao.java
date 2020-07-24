package com.saludespe.servicio.trabajosocial.repository;

import com.saludespe.servicio.trabajosocial.model.GrupoFamiliar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGrupoFamiliarDao extends CrudRepository<GrupoFamiliar, Long> {
    @Query(value = "SELECT * FROM GRUPOS_FAMILIARES app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    List<GrupoFamiliar> findByFichaSocioeconomica(Long idFichaSocioeconomica);
}
