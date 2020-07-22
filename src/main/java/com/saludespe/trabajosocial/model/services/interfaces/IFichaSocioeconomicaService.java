package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;

import java.util.Optional;

public interface IFichaSocioeconomicaService {
    
	FichaSocioeconomica save(FichaSocioeconomica ficha);

	void delete(Long id);
	
	Optional<FichaSocioeconomica> findById(Long id);

	Optional<FichaSocioeconomica> findByPaciente(Long idPaciente);

}