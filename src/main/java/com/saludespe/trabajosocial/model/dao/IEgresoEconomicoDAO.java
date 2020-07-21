package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.EgresoEconomico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEgresoEconomicoDAO extends CrudRepository<EgresoEconomico, Long>{
    @Query(value = "SELECT * FROM EGRESO_ECONOMICO app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);
}