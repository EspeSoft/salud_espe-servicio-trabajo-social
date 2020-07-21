package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IProblemaDAO;
import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.Problema;
import com.saludespe.trabajosocial.model.services.interfaces.IProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemaService implements IProblemaService {
    @Autowired
    private IProblemaDAO dao;
    @Override
    @Transactional
    public Problema save(Problema problema) {
        return dao.save(problema);
    }

    @Override
    @Transactional
    public Problema findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Problema no econtrado para el id: " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Problema> findAll() {
        return (List<Problema>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Problema> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
