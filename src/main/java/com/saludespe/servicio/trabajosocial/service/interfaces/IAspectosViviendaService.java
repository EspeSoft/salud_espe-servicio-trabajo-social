package com.saludespe.servicio.trabajosocial.service.interfaces;

import com.saludespe.servicio.trabajosocial.model.AspectoVivienda;

import java.util.List;

public interface IAspectosViviendaService {
    AspectoVivienda save(AspectoVivienda aspectoVivienda);

    void  delete(Long id);

    AspectoVivienda findById(Long id);

    void deleteAll(List<AspectoVivienda> aspectoViviendas);

    List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
