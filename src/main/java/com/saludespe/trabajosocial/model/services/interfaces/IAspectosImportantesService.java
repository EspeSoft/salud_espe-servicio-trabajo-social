package com.saludespe.trabajosocial.model.services.interfaces;

import com.saludespe.trabajosocial.model.entities.AspectosImportantes;

import java.util.List;

public interface IAspectosImportantesService {

    public AspectosImportantes save(AspectosImportantes aspectosImportantes);

    public void delete(Long id);

    public AspectosImportantes findById(Long id);

    public List<AspectosImportantes> findAll();
}
