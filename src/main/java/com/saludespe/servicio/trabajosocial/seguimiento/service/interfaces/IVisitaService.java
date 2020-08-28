package com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;

import java.util.List;

public interface IVisitaService {
    Visita save(Visita visita);

    void delete(Long id);

    Visita findById(Long id);
    void  deleteAll(List<Visita> visitaList);

    List<Visita> findBySeguimiento(Long idSeguimiento);

}
