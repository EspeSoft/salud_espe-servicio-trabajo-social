package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.SeguimientoAcompanamiento;

import java.util.List;

public interface ISeguimientoAcompanamientoService {

    public SeguimientoAcompanamiento save(SeguimientoAcompanamiento SeguimientoAcompanamiento);

    public void delete(Long id);

    public SeguimientoAcompanamiento findById(Long id);

    public List<SeguimientoAcompanamiento> findAll();
}
