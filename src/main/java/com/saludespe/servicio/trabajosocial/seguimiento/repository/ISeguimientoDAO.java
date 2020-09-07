package com.saludespe.servicio.trabajosocial.seguimiento.repository;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISeguimientoDAO extends CrudRepository<Seguimiento, Long> {
    @Query(value = "SELECT * FROM SEGUIMIENTOS ap WHERE ap.id_paciente = ?1", nativeQuery = true)
    Optional<Seguimiento> findByPaciente(Long idPaciente);

}
