package com.saludespe.trabajosocial.model.services.implementations;

import com.saludespe.trabajosocial.model.dao.IFamiliarDao;
import com.saludespe.trabajosocial.model.entities.Familiar;
import com.saludespe.trabajosocial.model.services.interfaces.IFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarService implements IFamiliarService {

    @Autowired
    private IFamiliarDao dao;

    @Override
    public Familiar save(Familiar familiar) {
        return dao.save(familiar);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Familiar findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Familiar> findAll() {
        return (List<Familiar>)dao.findAll();
    }
}
