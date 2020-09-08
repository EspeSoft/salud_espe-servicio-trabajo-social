package com.saludespe.servicio.trabajosocial.seguimiento.service.implementations;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.IVisitaDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class VisitaService implements IVisitaService {

    @Autowired
    private IVisitaDAO dao;

    @Autowired
    public VisitaService(IVisitaDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public Visita save(Visita visita) {
        return dao.save(visita);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public Visita findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Visita no econtrado para el id: " + id));

    }

    @Override
    public void deleteAll(List<Visita> visitaList) {
        dao.deleteAll(visitaList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Visita> findBySeguimiento(Long idSeguimiento) {
        return dao.findBySeguimiento(idSeguimiento);
    }
}
