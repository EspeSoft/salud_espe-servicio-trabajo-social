package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.EgresoEconomico;

import java.util.List;

public interface IEgresoEconomicoService {

    public EgresoEconomico save(EgresoEconomico egreso);

	public void delete(Long id);
	
	public EgresoEconomico findById(Long id);
	
	public List<EgresoEconomico> findAll();

	public List<EgresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica);


}