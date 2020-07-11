package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.Familiar;
import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IFamiliarService;
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

@RequestMapping(value="/familiar")
@Validated
@RestController
public class FamiliarController {
    @Autowired
    private IFamiliarService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar un Familiar por su Id",
            notes = "Debe proporcionar un id para buscar un Familia", response = Familiar.class)
    public Familiar retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Familiar no encontrado", ex);
        }
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de Necesidad de Capacitacion Social", notes = "", response = Familiar.class)
    public List<Familiar> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Familiares", notes = "Se guardará los datos de Familiares en Trabajo Social", response = Familiar.class)
    public Familiar save(@Valid @RequestBody Familiar familiar) {
        return service.save(familiar);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Familiares", notes = "Debe proporcionar un id para eliminar una Familiar de Trabajo Social", response = Familiar.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar Familiar por id", notes = "Se debe enviar el body y el id a actualizar", response = Familiar.class)
    public Familiar update(@Valid @RequestBody Familiar familiar, @PathVariable Long id){
        Familiar newFamiliar= service.findById(id);
        newFamiliar= familiar;
        return (service.save(newFamiliar));
    }

}
