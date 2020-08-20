package com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.IngresoEconomico;

import java.util.List;

public interface IIngresoEconomicoService {

    IngresoEconomico save(IngresoEconomico ingresoEconomico);

    void delete(Long id);

    void  deleteAll(List<IngresoEconomico> ingresosEconomicos);

     IngresoEconomico findById(Long id);

    List<IngresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
