package com.saludespe.servicio.trabajosocial.seguimiento.controller;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.SeguimientoAcompaniamiento;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoAcompaniamientoService;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="/seguimientos_acompaniamientos")
public class SeguimientoAcompaniamientoController {

    private static String notFoundMessage = "Seguimiento acompañamiento no encontrado para el id: ";

    @Autowired
    private ISeguimientoService seguimientoService;
    @Autowired
    private ISeguimientoAcompaniamientoService service;


    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar seguimiento acompañamiento",
            notes = "Se debe enviar el body en formato Json",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento save(@PathVariable Long idPaciente,
            @Valid @RequestBody SeguimientoAcompaniamiento seguimientoAcompaniamiento) {
        Optional<Seguimiento> seguimiento = seguimientoService.findByPaciente(idPaciente);
        if (!seguimiento.isPresent()) {
            seguimientoAcompaniamiento.setSeguimiento(seguimiento.get());
            return service.save(seguimientoAcompaniamiento);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El paciente ya posee un seguimiento acompañamiento.");
        }
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    @ApiOperation(
            value = "Buscar seguimiento acompañamiento por id",
            notes = "Se debe enviar el id",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento retrieve(@PathVariable Long id) {
        Optional<SeguimientoAcompaniamiento> seguimientoAcompaniamiento = service.findById(id);
        if (seguimientoAcompaniamiento.isPresent()){
            return seguimientoAcompaniamiento.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }

    @GetMapping("/search")
    @ApiOperation(
            value = "Buscar seguimiento acompañamiento por Id del paciente",
            notes = "Enviar id del paciente",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento findByPaciente(@RequestParam Long idPaciente) {
        Optional<SeguimientoAcompaniamiento> seguimientoAcompaniamiento = service.findByPaciente(idPaciente);
        if (seguimientoAcompaniamiento.isPresent()){
            return seguimientoAcompaniamiento.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + idPaciente);
        }
    }
    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar seguimiento acompañamiento por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = SeguimientoAcompaniamiento.class)
    public SeguimientoAcompaniamiento update(@Valid @RequestBody SeguimientoAcompaniamiento seguimientoAcompaniamiento, @PathVariable Long id){
        Optional<SeguimientoAcompaniamiento> optional = service.findById(id);
        if (optional.isPresent()){
            SeguimientoAcompaniamiento seguimientoAcompaniamiento1 = optional.get();
            return service.save(seguimientoAcompaniamiento1);
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }
}
