package com.saludespe.servicio.trabajosocial.seguimiento.service.implementations;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository.IFichaSocioeconomicaDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.repository.ISeguimientoDAO;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class SeguimientoService implements ISeguimientoService {

    @Autowired
    private ISeguimientoDAO dao;

    @Override
    @Transactional
    public Seguimiento save(Seguimiento seguimiento) {
        return dao.save(seguimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Seguimiento> findById(Long id){
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Seguimiento> findByPaciente(Long idPaciente){
        return dao.findByPaciente(idPaciente);
    }

}
