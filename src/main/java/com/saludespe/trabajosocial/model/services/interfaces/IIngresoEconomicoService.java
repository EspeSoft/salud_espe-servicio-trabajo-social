package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;

import java.util.List;

public interface IIngresoEconomicoService {

    IngresoEconomico save(IngresoEconomico ingresoEconomico);

    void delete(Long id);

    void  deleteAll(List<IngresoEconomico> ingresosEconomicos);

     IngresoEconomico findById(Long id);

    List<IngresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
