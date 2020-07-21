package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;

import java.util.List;

public interface IAspectosViviendaService {
    public AspectoVivienda save(AspectoVivienda aspectoVivienda);

    public void  delete(Long id);

    public AspectoVivienda findById(Long id);

    public List<AspectoVivienda> findAll();

    public List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
