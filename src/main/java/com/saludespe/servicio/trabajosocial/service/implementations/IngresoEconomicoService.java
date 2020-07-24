package com.saludespe.servicio.trabajosocial.service.implementations;

import com.saludespe.servicio.trabajosocial.model.IngresoEconomico;
import com.saludespe.servicio.trabajosocial.repository.IIngresoEconomicoDAO;
import com.saludespe.servicio.trabajosocial.service.interfaces.IIngresoEconomicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class IngresoEconomicoService implements IIngresoEconomicoService {

    @Autowired
    private IIngresoEconomicoDAO dao;

    @Override
    @Transactional
    public IngresoEconomico save(IngresoEconomico ingresoEconomico) {
        return dao.save(ingresoEconomico);
    }

    @Override
    @Transactional
    public IngresoEconomico findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Ingreso economico no econtrado para el id: " + id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteAll(List<IngresoEconomico> ingresosEconomicos) {
        dao.deleteAll(ingresosEconomicos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngresoEconomico> findByFichaSocioeconomica(Long idFichaSocioeconomica) {
        return dao.findByFichaSocioeconomica(idFichaSocioeconomica);
    }
}
