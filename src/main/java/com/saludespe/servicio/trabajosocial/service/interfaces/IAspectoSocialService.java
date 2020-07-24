package com.saludespe.servicio.trabajosocial.service.interfaces;

import com.saludespe.servicio.trabajosocial.model.AspectoSocial;

import java.util.List;

public interface IAspectoSocialService {

    AspectoSocial save(AspectoSocial aspectoSocial);

    void delete(Long id);

    AspectoSocial findById(Long id);
    void  deleteAll(List<AspectoSocial> aspectoSocials);

    List<AspectoSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}
