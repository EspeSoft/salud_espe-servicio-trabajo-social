package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IEgresoEconomicoDAO;
import com.saludespe.trabajosocial.model.entities.EgresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IEgresoEconomicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EgresoEconomicoService implements IEgresoEconomicoService {
    
    @Autowired
    private IEgresoEconomicoDAO dao;


    @Override
    @Transactional
    public EgresoEconomico save(EgresoEconomico egresoEconomico) {
        return dao.save(egresoEconomico);
    }

    @Override
    @Transactional
    public EgresoEconomico findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Egreso económico no econtrado para el id: " + id));
    }

    @Override
    public void deleteAll(List<EgresoEconomico> egresoEconomicos) {
        dao.deleteAll(egresoEconomicos);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }

}