package com.saludespe.servicio.trabajosocial.service.interfaces;

import com.saludespe.servicio.trabajosocial.model.FichaSocioeconomica;

import java.util.Optional;

public interface IFichaSocioeconomicaService {
    
	FichaSocioeconomica save(FichaSocioeconomica ficha);

	void delete(Long id);
	
	Optional<FichaSocioeconomica> findById(Long id);

	Optional<FichaSocioeconomica> findByPaciente(Long idPaciente);

}