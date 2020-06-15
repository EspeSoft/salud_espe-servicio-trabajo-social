package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.entities.Problema;
import com.saludespe.trabajosocial.model.services.interfaces.IProblemaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping(value="/problema")
@Validated
@RestController
public class ProblemaController {

    @Autowired
    private IProblemaService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar una Problema por su Id",
            notes = "Debe proporcionar un id para buscar un Problema", response = Problema.class)
    public Optional<Problema> retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Ingreso económico no encontrado", ex);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de Problema", notes = "", response = Problema.class)
    public List<Problema> list() { return service.findAll(); }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Problema", notes = "Se guardará los datos de Problema", response = Problema.class)
    public Problema save(@Valid @RequestBody Problema problema) {
        return service.save(problema);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Ingreso Económico", notes = "Debe proporcionar un id para eliminar un Problema", response = Problema.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar la lista de Problema", notes = "Debe proporcionar un id para actualizar un problema", response = Problema.class)
    public Problema update(@RequestBody Problema problema, @PathVariable Long id) {
        Problema problemaEncontrada = service.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Problema no encontrada para el id: "+id));
        if (problemaEncontrada != null) {
            problemaEncontrada=problema;
            return service.save(problemaEncontrada);
        } else {
            return service.save(problema);
        }
    }
}
