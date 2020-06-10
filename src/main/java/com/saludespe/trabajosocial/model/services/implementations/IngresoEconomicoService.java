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
        return dao.save(ingresoEconomico);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public IngresoEconomico findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<IngresoEconomico> findAll() {
        return (List<IngresoEconomico>)dao.findAll();
    }
}
