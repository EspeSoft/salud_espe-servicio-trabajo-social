package com.saludespe.servicio.trabajosocial.service.implementations;

import com.saludespe.servicio.trabajosocial.model.GrupoFamiliar;
import com.saludespe.servicio.trabajosocial.repository.IGrupoFamiliarDao;
import com.saludespe.servicio.trabajosocial.service.interfaces.IGrupoFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GrupoFamiliarService implements IGrupoFamiliarService {

    @Autowired
    private IGrupoFamiliarDao dao;

    @Override
    @Transactional
    public GrupoFamiliar save(GrupoFamiliar familiar) {
        return dao.save(familiar);
    }

    @Override
    @Transactional
    public GrupoFamiliar findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Familiar no econtrado para el id: " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteAll(List<GrupoFamiliar> gruposFamiliares) {
        dao.deleteAll(gruposFamiliares);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GrupoFamiliar> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }

}
