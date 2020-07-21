package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.NecesidadCapacitacionSocial;

import java.util.List;
import java.util.Optional;

public interface INecesidadCapacitacionSocialService {

    public NecesidadCapacitacionSocial save(NecesidadCapacitacionSocial necesidadCapacitacionSocial);

    public void delete(Long id);

    public NecesidadCapacitacionSocial findById(Long id);

    public List<NecesidadCapacitacionSocial> findAll();

    public List<NecesidadCapacitacionSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}
