package com.saludespe.servicio.trabajosocial.service.implementations;

import com.saludespe.servicio.trabajosocial.model.AspectoSocial;
import com.saludespe.servicio.trabajosocial.repository.IAspectoSocialDAO;
import com.saludespe.servicio.trabajosocial.service.interfaces.IAspectoSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AspectoSocialService implements IAspectoSocialService {

    @Autowired
    private IAspectoSocialDAO dao;

    @Override
    @Transactional
    public AspectoSocial save(AspectoSocial aspectoSocial) {

        return dao.save(aspectoSocial);
    }

    @Override
    @Transactional
    public AspectoSocial findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Necesidad de capacitación social no econtrado para el id: " + id));
    }

    @Override
    public void deleteAll(List<AspectoSocial> aspectoSocials) {
        dao.deleteAll(aspectoSocials);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AspectoSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
