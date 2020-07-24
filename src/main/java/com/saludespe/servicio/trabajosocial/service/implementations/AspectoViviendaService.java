package com.saludespe.servicio.trabajosocial.service.implementations;

import com.saludespe.servicio.trabajosocial.model.AspectoVivienda;
import com.saludespe.servicio.trabajosocial.repository.IAspectoViviendaDAO;
import com.saludespe.servicio.trabajosocial.service.interfaces.IAspectosViviendaService;
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
    public void deleteAll(List<AspectoVivienda> aspectoViviendas) {
      dao.deleteAll(aspectoViviendas);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AspectoVivienda> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
