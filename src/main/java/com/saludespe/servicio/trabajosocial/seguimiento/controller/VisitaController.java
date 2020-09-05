package com.saludespe.servicio.trabajosocial.seguimiento.controller;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.IVisitaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="{idPaciente}/visitas")
public class VisitaController {
    private static String visitaNotFoundMessage = "No existe un registro  para el paciente: ";

    @Autowired
    private IVisitaService service;

    @Autowired
    private ISeguimientoService seguimientoService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar visita",
            notes = "Se debe enviar el body en formato Json",
            response = Visita.class)
    public Visita save(@PathVariable Long idPaciente,
                              @Valid @RequestBody Visita visita) {
        Optional<Seguimiento> seguimiento = seguimientoService.findByPaciente(idPaciente);
        if (seguimiento.isPresent()){
            visita.setSeguimiento(seguimiento.get());
            return  service.save(visita);
        }else  {
            throw new EntityNotFoundException(visitaNotFoundMessage + idPaciente);
        }

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar visita por id",
            notes = "Se debe enviar el id",
            response = Visita.class)
    public Visita retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar visita por id", notes = "Se debe enviar el id", response = Visita.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de visitas",
            notes = "Se debe enviar una lista",
            response = Visita.class)
    public void deleteAll(@RequestBody List<Visita> visitaList) {
        service.deleteAll(visitaList);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de visitas por paciente", notes = "", response = Visita.class)
    public List<Visita> visitaList(@PathVariable Long idPaciente) {
        Optional<Seguimiento> seguimiento = seguimientoService.findByPaciente(idPaciente);
        if(seguimiento.isPresent()){
            return service.findBySeguimiento(seguimiento.get().getId());
        }else {
            throw new EntityNotFoundException(visitaNotFoundMessage + idPaciente);
        }
    }


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar visita por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = Visita.class)
    public Visita update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody Visita visita, @PathVariable Long id){
        Optional<Seguimiento> seguimiento = seguimientoService.findByPaciente(idPaciente);
        if (seguimiento.isPresent()){
            Visita visita1 = service.findById(id);
            visita1.setMotivo(visita.getMotivo());
            visita1.setFechaVisita(visita.getFechaVisita());
            visita1.setDireccionVisita(visita.getDireccionVisita());
            visita1.setHoraVisita(visita.getHoraVisita());
            visita1.setActividadesPorRealizar(visita.getActividadesPorRealizar());
            visita1.setEconomiaFamiliar(visita.getEconomiaFamiliar());
            visita1.setAsignacionHogar(visita.getAsignacionHogar());
            visita1.setEducacion(visita.getEducacion());
            visita1.setSalud(visita.getSalud());
            visita1.setFamilia(visita.getFamilia());
            visita1.setObservaciones(visita.getObservaciones());
            visita1.setHorasReposo(visita.getHorasReposo());
            visita1.setDiasReposo(visita.getDiasReposo());
            visita.setFamiliar(visita.getFamiliar());
            return service.save(visita1);
        }else{
            throw new EntityNotFoundException(visitaNotFoundMessage + idPaciente);
        }
    }
}
