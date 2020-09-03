package com.saludespe.trabajosocial.model.services.implementations;
import com.saludespe.trabajosocial.model.dao.ISeguimientoAcompañamientoDAO;
import com.saludespe.trabajosocial.model.entities.SeguimientoAcompañamiento;
import com.saludespe.trabajosocial.model.services.interfaces.ISeguimientoAcompañamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguimientoAcompañamientoService implements ISeguimientoAcompañamientoService{

    @Autowired
    private ISeguimientoAcompañamientoDAO dao;

    @Override
    public SeguimientoAcompañamiento save(SeguimientoAcompañamiento seguimientoAcompañamiento) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public SeguimientoAcompañamiento findById(Long id) {
        return null;
    }

    @Override
    public List<SeguimientoAcompañamiento> findAll() {
        return null;
    }
}
