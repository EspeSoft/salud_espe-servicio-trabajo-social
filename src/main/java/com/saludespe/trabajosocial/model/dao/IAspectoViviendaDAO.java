package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAspectoViviendaDAO extends CrudRepository<AspectoVivienda, Long> {
    @Query(value = "SELECT * FROM ASPECTO_VIVIENDA app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
