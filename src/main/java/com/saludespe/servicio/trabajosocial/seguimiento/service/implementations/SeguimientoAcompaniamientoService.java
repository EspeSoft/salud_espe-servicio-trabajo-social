package com.saludespe.servicio.trabajosocial.seguimiento.service.implementations;

import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.ISeguimientoAcompaniamientoDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.IVisitaDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoAcompaniamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SeguimientoAcompaniamientoService implements ISeguimientoAcompaniamientoService {

    @Autowired
    private ISeguimientoAcompaniamientoDAO dao;

    @Autowired
    public SeguimientoAcompaniamientoService(ISeguimientoAcompaniamientoDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public SeguimientoAcompaniamiento save(SeguimientoAcompaniamiento seguimientoAcompaniamiento) {
        return dao.save(seguimientoAcompaniamiento);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }


    @Override
    @Transactional
    public SeguimientoAcompaniamiento findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Seguimiento-Acompañamiento no econtrado para el id: " + id));

    }

    @Override
    public void deleteAll(List<SeguimientoAcompaniamiento> seguimientoAcompaniamientoList) {
        dao.deleteAll(seguimientoAcompaniamientoList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeguimientoAcompaniamiento> findBySeguimiento(Long idSeguimiento) { return dao.findBySeguimiento(idSeguimiento);
    }



}
