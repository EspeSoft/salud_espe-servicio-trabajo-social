package com.saludespe.servicio.trabajosocial.seguimiento.controller;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoAcompaniamientoService;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.IVisitaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="/seguimientos/{idSeguimiento}/seguimientos-acompaniamientos")
public class SeguimientoAcompaniamientoController {

    @Autowired
    private ISeguimientoService seguimientoService;
    @Autowired
    private ISeguimientoAcompaniamientoService service;

    @Autowired
    public SeguimientoAcompaniamientoController(
            ISeguimientoAcompaniamientoService service,
            ISeguimientoService seguimientoService) {
        this.service = service;
        this.seguimientoService = seguimientoService;
    }


    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar seguimiento acompañamiento",
            notes = "Se debe enviar el body en formato Json",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento save(@PathVariable Long idSeguimiento,
            @Valid @RequestBody SeguimientoAcompaniamiento seguimientoAcompaniamiento) {
        Seguimiento seguimiento = seguimientoService.findById(idSeguimiento);
        seguimientoAcompaniamiento.setSeguimiento(seguimiento);
        return service.save(seguimientoAcompaniamiento);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Buscar seguimiento acompañamiento por id",
            notes = "Se debe enviar el id",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento retrieve(@PathVariable Long id) { return  service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar seguimiento acompañamiento por id", notes = "Se debe enviar el id", response = SeguimientoAcompaniamiento.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de seguimientos-acompañamientos",
            notes = "Se debe enviar una lista",
            response = Visita.class)
    public void deleteAll(@RequestBody List<SeguimientoAcompaniamiento> seguimientoAcompaniamientoList) {
        service.deleteAll(seguimientoAcompaniamientoList);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de seguimientos-acompañamientos por paciente", notes = "", response = SeguimientoAcompaniamiento.class)
    public List<SeguimientoAcompaniamiento> visitaList(@PathVariable Long idSeguimiento) {
        return service.findBySeguimiento(idSeguimiento);
    }
    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar seguimiento acompañamiento por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento update(
            @Valid @RequestBody SeguimientoAcompaniamiento seguimientoAcompaniamiento, @PathVariable Long id){
            SeguimientoAcompaniamiento seguimientoAcompaniamiento1 = service.findById(id);
            seguimientoAcompaniamiento1.setFecha(seguimientoAcompaniamiento.getFecha());
            seguimientoAcompaniamiento1.setDescripcion(seguimientoAcompaniamiento.getDescripcion());
            seguimientoAcompaniamiento1.setObservacion(seguimientoAcompaniamiento.getObservacion());
            return service.save(seguimientoAcompaniamiento1);
    }
}
