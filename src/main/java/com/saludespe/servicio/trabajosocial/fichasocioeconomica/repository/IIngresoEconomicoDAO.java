package com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.IngresoEconomico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IIngresoEconomicoDAO extends CrudRepository<IngresoEconomico, Long> {
    @Query(value = "SELECT * FROM INGRESOS_ECONOMICOS app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    List<IngresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
