package com.saludespe.servicio.trabajosocial.seguimiento.service.implementations;

import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.ISeguimientoAcompaniamientoDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoAcompaniamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class SeguimientoAcompaniamientoService implements ISeguimientoAcompaniamientoService {

    @Autowired
    private ISeguimientoAcompaniamientoDAO dao;

    @Override
    @Transactional
    public SeguimientoAcompaniamiento save(SeguimientoAcompaniamiento seguimientoAcompaniamiento) {
        return dao.save(seguimientoAcompaniamiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SeguimientoAcompaniamiento> findById(Long id){
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SeguimientoAcompaniamiento> findByPaciente(Long idPaciente){
        return dao.findByPaciente(idPaciente);
    }

}
