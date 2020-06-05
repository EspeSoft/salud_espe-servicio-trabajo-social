package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;

import java.util.List;

public interface IFichaSocioeconomicaService {
    
    public FichaSocioeconomica save(FichaSocioeconomica ficha);

	public void delete(Long id);
	
	public FichaSocioeconomica findById(Long id);
	
	public List<FichaSocioeconomica> findAll();
}