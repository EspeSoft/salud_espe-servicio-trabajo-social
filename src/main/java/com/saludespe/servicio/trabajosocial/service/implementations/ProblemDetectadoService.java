package com.saludespe.servicio.trabajosocial.service.implementations;

import com.saludespe.servicio.trabajosocial.model.ProblemaDetectado;
import com.saludespe.servicio.trabajosocial.repository.IProblemaDetectadoDAO;
import com.saludespe.servicio.trabajosocial.service.interfaces.IProblemaDetectadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProblemDetectadoService implements IProblemaDetectadoService {

    @Autowired
    private IProblemaDetectadoDAO dao;

    @Override
    @Transactional
    public ProblemaDetectado save(ProblemaDetectado problemaDetectado) {
        return dao.save(problemaDetectado);
    }

    @Override
    @Transactional
    public ProblemaDetectado findById(Long id) {
        return dao.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Problema detectado no econtrado para el id: " + id));
    }

    @Override
    public void deleteAll(List<ProblemaDetectado> problemasDetectados) {
        dao.deleteAll(problemasDetectados);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProblemaDetectado> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
