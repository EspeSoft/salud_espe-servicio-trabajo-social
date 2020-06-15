package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.Problema;

import java.util.List;
import java.util.Optional;

public interface IProblemaService {
    public Problema save(Problema problema);

    public void delete(Long id);

    public Optional<Problema> findById(Long id);

    public List<Problema> findAll();
}
