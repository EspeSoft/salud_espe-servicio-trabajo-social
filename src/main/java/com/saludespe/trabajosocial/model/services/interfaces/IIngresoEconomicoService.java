package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;

import java.util.List;

public interface IIngresoEconomicoService {

    public IngresoEconomico save(IngresoEconomico ingresoEconomico);

    public void delete(Long id);

    public IngresoEconomico findById(Long id);

    public List<IngresoEconomico> findAll();
}
