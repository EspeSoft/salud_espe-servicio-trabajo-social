package com.saludespe.servicio.trabajosocial.seguimiento.controller;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
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
@RequestMapping(value="/seguimientos")
public class SeguimientoController {

    private static String notFoundMessage = "Seguimiento no encontrado para el id: ";

    @Autowired
    private ISeguimientoService service;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar seguimiento",
            notes = "Se debe enviar el body en formato Json",
            response = Seguimiento.class)
    public Seguimiento save(@Valid @RequestBody Seguimiento seguimiento) {
        Optional<Seguimiento> seguimiento1 = service.findByPaciente(seguimiento.getIdPaciente());
        if (!seguimiento1.isPresent()) {
            return service.save(seguimiento);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El paciente ya posee un seguimiento.");
        }
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    @ApiOperation(
            value = "Buscar seguimiento por id",
            notes = "Se debe enviar el id",
            response = Seguimiento.class)
    public Seguimiento retrieve(@PathVariable Long id) {
        Optional<Seguimiento> seguimiento = service.findById(id);
        if (seguimiento.isPresent()){
            return seguimiento.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }

    @GetMapping("/search")
    @ApiOperation(
            value = "Buscar seguimiento por Id del paciente",
            notes = "Enviar id del paciente",
            response = Seguimiento.class)
    public Seguimiento findByPaciente(@RequestParam Long idPaciente) {
        Optional<Seguimiento> seguimiento = service.findByPaciente(idPaciente);
        if (seguimiento.isPresent()){
            return seguimiento.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + idPaciente);
        }
    }
    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar seguimiento por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = Seguimiento.class)
    public Seguimiento update(@Valid @RequestBody Seguimiento seguimiento, @PathVariable Long id){
        Optional<Seguimiento> optional = service.findById(id);
        if (optional.isPresent()){
            Seguimiento seguimiento1 = optional.get();
            return service.save(seguimiento1);
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }
}
