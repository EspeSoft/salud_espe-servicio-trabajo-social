package com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces;

import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;

import java.util.List;
import java.util.Optional;

public interface ISeguimientoAcompaniamientoService {

    SeguimientoAcompaniamiento save(SeguimientoAcompaniamiento seguimientoAcompaniamiento);

    void delete(Long id);
    SeguimientoAcompaniamiento findById(Long id);
    void  deleteAll(List<SeguimientoAcompaniamiento> seguimientoAcompaniamientoList);

    List<SeguimientoAcompaniamiento> findBySeguimiento(Long idSeguimiento);

}
