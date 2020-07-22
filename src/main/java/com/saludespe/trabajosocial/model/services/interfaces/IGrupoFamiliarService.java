package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.GrupoFamiliar;

import java.util.List;

public interface IGrupoFamiliarService {

    GrupoFamiliar save(GrupoFamiliar familiar);

    void delete(Long id);
    void deleteAll(List<GrupoFamiliar> gruposFamiliares);

    GrupoFamiliar findById(Long id);

    List<GrupoFamiliar> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
