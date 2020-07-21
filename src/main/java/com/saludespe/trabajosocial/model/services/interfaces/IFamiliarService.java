package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.Familiar;

import java.util.List;

public interface IFamiliarService {

    public Familiar save(Familiar familiar);

    public void delete(Long id);

    public Familiar findById(Long id);

    public List<Familiar> findAll();

    public List<Familiar> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
