package com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.implementations;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces.IFichaSocioeconomicaService;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository.IFichaSocioeconomicaDAO;
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
    @Transactional(readOnly = true)
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