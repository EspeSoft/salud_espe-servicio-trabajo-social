package com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;

import java.util.Optional;

public interface ISeguimientoService {

    Seguimiento save(Seguimiento seguimiento);

    void delete(Long id);

    Optional<Seguimiento> findById(Long id);

    Optional<Seguimiento> findByPaciente(Long idPaciente);

}
