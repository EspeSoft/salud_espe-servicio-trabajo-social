package com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;

import java.util.List;
import java.util.Optional;

public interface ISeguimientoService {

    Seguimiento save(Seguimiento seguimiento);

    Seguimiento update(Seguimiento seguimiento);

    Seguimiento findById(Long id);

    List<Seguimiento> findByPaciente(Long idPaciente);

    void delete(Long id);

    void  deleteAll(List<Seguimiento> seguimientoList);




}
