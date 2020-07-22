package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.EgresoEconomico;

import java.util.List;

public interface IEgresoEconomicoService {

   EgresoEconomico save(EgresoEconomico egreso);

	void delete(Long id);
	
	EgresoEconomico findById(Long id);

	void deleteAll(List<EgresoEconomico> egresoEconomicos);

	List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}