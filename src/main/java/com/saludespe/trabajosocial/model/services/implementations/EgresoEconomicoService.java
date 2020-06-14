package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IEgresoEconomicoDAO;
import com.saludespe.trabajosocial.model.entities.EgresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IEgresoEconomicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EgresoEconomicoService implements IEgresoEconomicoService {
    
    @Autowired
    private IEgresoEconomicoDAO dao;

    @Override
    public EgresoEconomico save(EgresoEconomico egreso) {
        return dao.save(egreso);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public EgresoEconomico findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<EgresoEconomico> findAll() {
        return (List<EgresoEconomico>)dao.findAll();
    }
    

}