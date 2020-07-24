package com.saludespe.servicio.trabajosocial.repository;

import com.saludespe.servicio.trabajosocial.model.AspectoVivienda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAspectoViviendaDAO extends CrudRepository<AspectoVivienda, Long> {
    @Query(value = "SELECT * FROM ASPECTOS_VIVIENDA app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
