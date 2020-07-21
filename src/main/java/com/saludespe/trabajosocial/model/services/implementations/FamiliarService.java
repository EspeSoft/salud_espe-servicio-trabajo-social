package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IFamiliarDao;
import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.Familiar;
import com.saludespe.trabajosocial.model.services.interfaces.IFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FamiliarService implements IFamiliarService {

    @Autowired
    private IFamiliarDao dao;

    @Override
    @Transactional
    public Familiar save(Familiar familiar) {
        return dao.save(familiar);
    }

    @Override
    @Transactional
    public Familiar findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Familiar no econtrado para el id: " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Familiar> findAll() {
        return (List<Familiar>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Familiar> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }

}
