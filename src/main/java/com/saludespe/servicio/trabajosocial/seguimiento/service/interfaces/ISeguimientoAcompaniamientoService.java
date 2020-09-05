package com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces;

import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;

import java.util.Optional;

public interface ISeguimientoAcompaniamientoService {

    SeguimientoAcompaniamiento save(SeguimientoAcompaniamiento seguimientoAcompaniamiento);

    void delete(Long id);

    Optional<SeguimientoAcompaniamiento> findById(Long id);

    Optional<SeguimientoAcompaniamiento> findByPaciente(Long idPaciente);

}
