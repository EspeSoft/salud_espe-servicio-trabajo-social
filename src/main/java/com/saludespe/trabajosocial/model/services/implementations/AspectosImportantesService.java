package com.saludespe.trabajosocial.model.services.implementations;
import com.saludespe.trabajosocial.model.dao.IAspectosImportantesDAO;
import com.saludespe.trabajosocial.model.entities.AspectosImportantes;
import com.saludespe.trabajosocial.model.services.interfaces.IAspectosImportantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspectosImportantesService implements AspectosImportantesService{

    @Autowired
    private IAspectosImportantesDAO dao;

    @Override
    public AspectosImportantes save(AspectosImportantes aspectosImportantes) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AspectosImportantes findById(Long id) {
        return null;
    }

    @Override
    public List<AspectosImportantes> findAll() {
        return null;
    }
}
