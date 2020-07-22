package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;

import java.util.List;

public interface IAspectosViviendaService {
    AspectoVivienda save(AspectoVivienda aspectoVivienda);

    void  delete(Long id);

    AspectoVivienda findById(Long id);

    void deleteAll(List<AspectoVivienda> aspectoViviendas);

    List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
