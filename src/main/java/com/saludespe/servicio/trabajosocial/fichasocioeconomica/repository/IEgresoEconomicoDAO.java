package com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.EgresoEconomico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEgresoEconomicoDAO extends CrudRepository<EgresoEconomico, Long>{
    @Query(value = "SELECT * FROM EGRESOS_ECONOMICOS app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);
}