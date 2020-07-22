package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IIngresoEconomicoDAO extends CrudRepository<IngresoEconomico, Long> {
    @Query(value = "SELECT * FROM INGRESOS_ECONOMICOS app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<IngresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
