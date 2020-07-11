package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.INecesidadCapacitacionSocialDAO;
import com.saludespe.trabajosocial.model.entities.NecesidadCapacitacionSocial;
import com.saludespe.trabajosocial.model.services.interfaces.INecesidadCapacitacionSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NecesidadCapacitacionSocialService implements INecesidadCapacitacionSocialService {

    @Autowired
    private INecesidadCapacitacionSocialDAO dao;

    @Override
    @Transactional
    public NecesidadCapacitacionSocial save(NecesidadCapacitacionSocial necesidadCapacitacionSocial) {
        return dao.save(necesidadCapacitacionSocial);
    }

    @Override
    @Transactional
    public void delete(Long id) { dao.deleteById(id);}

    @Override
    @Transactional(readOnly = true)
    public Optional<NecesidadCapacitacionSocial> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NecesidadCapacitacionSocial> findAll() {
        return (List<NecesidadCapacitacionSocial>)dao.findAll();
    }
}
