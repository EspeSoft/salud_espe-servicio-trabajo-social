package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.ProblemaDetectado;

import java.util.List;

public interface IProblemaDetectadoService {

    ProblemaDetectado save(ProblemaDetectado problemaDetectado);

    void delete(Long id);

    ProblemaDetectado findById(Long id);

    void deleteAll(List<ProblemaDetectado> problemasDetectados);

    List<ProblemaDetectado> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
