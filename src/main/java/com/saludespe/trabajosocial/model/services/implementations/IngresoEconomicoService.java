package com.saludespe.trabajosocial.model.services.implementations;
import com.saludespe.trabajosocial.model.dao.IIngresoEconomicoDAO;
import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IIngresoEconomicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoEconomicoService implements IIngresoEconomicoService{

    @Autowired
    private IIngresoEconomicoDAO dao;

    @Override
    public IngresoEconomico save(IngresoEconomico ingresoEconomico) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public IngresoEconomico findById(Long id) {
        return null;
    }

    @Override
    public List<IngresoEconomico> findAll() {
        return null;
    }
}
