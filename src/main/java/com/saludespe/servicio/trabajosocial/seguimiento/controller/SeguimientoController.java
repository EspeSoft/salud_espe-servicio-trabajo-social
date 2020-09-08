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
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="/seguimientos")
public class SeguimientoController {

    private final ISeguimientoService service;

    @Autowired
    public SeguimientoController(ISeguimientoService service){
        this.service = service;
    }


    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar seguimiento",
            notes = "Se debe enviar el body en formato Json",
            response = Seguimiento.class)
    public Seguimiento save(@Valid @RequestBody Seguimiento seguimiento) {
        return service.save(seguimiento);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Buscar seguimiento por id",
            notes = "Se debe enviar el id",
            response = Seguimiento.class)
    public Seguimiento retrieve(@Valid @PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar seguimiento por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = Seguimiento.class)
    public Seguimiento update(@Valid @RequestBody Seguimiento seguimiento, @PathVariable Long id){
            Seguimiento seguimiento1 = service.findById(id);
            seguimiento1.setEstado(seguimiento.getEstado());
            seguimiento1.setFechaInicio(seguimiento1.getFechaInicio());
            return service.update(seguimiento1);
    }
    @GetMapping("")
    @ApiOperation(
            value = "Buscar seguimiento por Id Paciente",
            response = Seguimiento.class)
    public List<Seguimiento> findByPaciente(@RequestParam Long idPaciente) {
        return service.findByPaciente(idPaciente);
    }
}
