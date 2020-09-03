package com.saludespe.servicio.trabajosocial.seguimiento.repository;

import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISeguimientoAcompaniamientoDAO extends CrudRepository<SeguimientoAcompaniamiento, Long> {
    @Query(value = "SELECT * FROM SEGUIMIENTOS_ACOMPANIAMIENTOS ap WHERE ap.id_paciente = ?1", nativeQuery = true)
    Optional<SeguimientoAcompaniamiento> findByPaciente(Long idPaciente);

}
