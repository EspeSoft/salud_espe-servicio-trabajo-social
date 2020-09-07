package com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.GrupoFamiliar;

import java.util.List;

public interface IGrupoFamiliarService {

    GrupoFamiliar save(GrupoFamiliar familiar);

    void delete(Long id);
    void deleteAll(List<GrupoFamiliar> gruposFamiliares);

    GrupoFamiliar findById(Long id);

    List<GrupoFamiliar> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
