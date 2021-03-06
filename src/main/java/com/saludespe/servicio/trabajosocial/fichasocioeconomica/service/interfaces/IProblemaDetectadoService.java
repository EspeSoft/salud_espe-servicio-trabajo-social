package com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.ProblemaDetectado;

import java.util.List;

public interface IProblemaDetectadoService {

    ProblemaDetectado save(ProblemaDetectado problemaDetectado);

    void delete(Long id);

    ProblemaDetectado findById(Long id);

    void deleteAll(List<ProblemaDetectado> problemasDetectados);

    List<ProblemaDetectado> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
