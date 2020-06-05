package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IFichaSocioeconomicaDAO;
import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FichaSocioeconomicaService implements IFichaSocioeconomicaService {

    @Autowired
    private IFichaSocioeconomicaDAO dao;

    @Override
    public FichaSocioeconomica save(FichaSocioeconomica ficha) {
        return dao.save(ficha);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public FichaSocioeconomica findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<FichaSocioeconomica> findAll() {
        return (List<FichaSocioeconomica>)dao.findAll();
    }
}