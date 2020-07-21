package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.Familiar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFamiliarDao extends CrudRepository<Familiar, Long> {
    @Query(value = "SELECT * FROM FAMILIAR app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<Familiar> findByFichaSocioeconomica(Long idFichaSocioeconomica);
}
