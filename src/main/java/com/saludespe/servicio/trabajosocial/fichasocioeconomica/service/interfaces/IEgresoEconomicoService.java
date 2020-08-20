package com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.EgresoEconomico;

import java.util.List;

public interface IEgresoEconomicoService {

   EgresoEconomico save(EgresoEconomico egreso);

	void delete(Long id);
	
	EgresoEconomico findById(Long id);

	void deleteAll(List<EgresoEconomico> egresoEconomicos);

	List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}