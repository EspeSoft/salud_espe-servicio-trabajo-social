package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IAspectoViviendaDAO;
import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.services.interfaces.IAspectosViviendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AspectoViviendaService implements IAspectosViviendaService {
    @Autowired
    private IAspectoViviendaDAO dao;

    @Override
    @Transactional
    public AspectoVivienda save(AspectoVivienda aspectoVivienda) {
        return dao.save(aspectoVivienda);
    }

    @Override
    @Transactional
    public AspectoVivienda findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Aspecto de vivienda no econtrado para el id: " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AspectoVivienda> findAll() {
        return (List<AspectoVivienda>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
