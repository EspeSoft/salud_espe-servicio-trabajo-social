package com.saludespe.servicio.trabajosocial.seguimiento.service.implementations;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.ISeguimientoDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class SeguimientoService implements ISeguimientoService {


    private final ISeguimientoDAO dao;

    @Autowired
    public SeguimientoService(ISeguimientoDAO dao){
        this.dao = dao;
    }


    @Override
    public Seguimiento save(Seguimiento seguimiento) {
        return dao.save(seguimiento);
    }

    @Override
    @Transactional
    public Seguimiento update(Seguimiento seguimiento) {
        return dao.save(seguimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Seguimiento findById(Long id) {
        return dao.findById(id).orElseThrow(()->
                new EntityNotFoundException("Seguimiento no econtrada para el id: " + id));
    }
    @Override
    @Transactional(readOnly = true)
    public List<Seguimiento> findByPaciente(Long idPaciente) {
        return dao.findByIdPaciente(idPaciente);
    }



}
