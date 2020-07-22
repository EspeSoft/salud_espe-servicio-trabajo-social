package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoSocial;

import java.util.List;

public interface IAspectoSocialService {

    AspectoSocial save(AspectoSocial aspectoSocial);

    void delete(Long id);

    AspectoSocial findById(Long id);
    void  deleteAll(List<AspectoSocial> aspectoSocials);

    List<AspectoSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}
