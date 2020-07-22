package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IFichaSocioeconomicaDAO;
import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class FichaSocioeconomicaService implements IFichaSocioeconomicaService {

    @Autowired
    private IFichaSocioeconomicaDAO dao;

    @Override
    @Transactional
    public FichaSocioeconomica save(FichaSocioeconomica fichaSocioeconomica) {
        return dao.save(fichaSocioeconomica);
    }

    @Override
    @Transactional
    public Optional<FichaSocioeconomica> findById(Long id){
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FichaSocioeconomica> findByPaciente(Long idPaciente){
        return dao.findByPaciente(idPaciente);
    }
}