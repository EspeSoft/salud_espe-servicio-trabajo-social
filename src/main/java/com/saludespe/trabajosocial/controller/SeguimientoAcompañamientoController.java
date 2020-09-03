package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.SeguimientoAcompanamiento;
import com.saludespe.trabajosocial.model.services.interfaces.ISeguimientoAcompanamientoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(value="/seguimiento-acompanamiento")
@Validated
@RestController
public class SeguimientoAcompanamientoController {

    @Autowired
    private ISeguimientoAcompañamientoService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar un Acompañamiento por su Id",
            notes = "Debe proporcionar un id para buscar un seguimiento acompañamiento", response = SeguimientoAcompanamiento.class)
    public SeguimientoAcompanamieto retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Seguimiento acompañamiento no encontrado", ex);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de Seguimientos acompañamientos", notes = "", response = SeguimientoAcompanamiento.class)
    public List<SeguimientoAcompanamiento> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Seguimiento acompañamiento", notes = "Se guardará los datos de Seguimiento acompañamiento", response = SeguimientoAcompanamiento.class)
    public SeguimientoAcompanamiento save(@Valid @RequestBody SeguimientoAcompanamiento seguimientoAcompanamiento) {
        return service.save(seguimientoAcompanamiento);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de seguimiento acompañamiento", notes = "Debe proporcionar un id para eliminar un Seguimiento acompañamiento", response = SeguimientoAcompanamiento.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar Seguimiento acompañamiento por id", notes = "Se debe enviar el body y el id a actualizar", response = SeguimientoAcompanamiento.class)
    public SeguimientoAcompanamiento update(@PathVariable Long idPaciente, @Valid @RequestBody SeguimientoAcompanamiento seguimientoAcompanamiento, @PathVariable Long id){
       SeguimientoAcompanamiento newSeguimientoAcompanamiento= service.findById(id);
        newSeguimientoAcompanamiento= seguimientoAcompanamiento;
        return (service.save(newSeguimientoAcompanamiento));
    }


}
