package com.saludespe.servicio.trabajosocial.seguimiento.repository;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.AspectoSocial;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVisitaDAO extends CrudRepository<Visita, Long> {
    @Query(value = "SELECT * FROM VISITAS app WHERE app.id_seguimiento = ?1", nativeQuery = true)
    List<Visita> findBySeguimiento(Long idSeguimiento);

}
