package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.NecesidadCapacitacionSocial;
import com.saludespe.trabajosocial.model.services.interfaces.INecesidadCapacitacionSocialService;
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

@RequestMapping(value="/necesidades-capacitacion-social")
@Validated
@RestController
public class NecesidadCapacitacionSocialController {

    @Autowired
    private INecesidadCapacitacionSocialService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar una Necesidad de Capacitacion Social por su Id",
            notes = "Debe proporcionar un id para buscar una Necesidad de Capacitacion Social", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial findById(@Valid @PathVariable Long id) {
        return service.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Necesidad de Capacitacion Social no encontrada para el id: "+id));
    }
    @GetMapping("")
    @ApiOperation(value = "Buscar lista de Necesidad de Capacitacion Social", notes = "", response = NecesidadCapacitacionSocial.class)
    public List<NecesidadCapacitacionSocial> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Necesidad de Capacitacion Social", notes = "Se guardará los datos de Necesidad de Capacitacion Social", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial save(@Valid @RequestBody NecesidadCapacitacionSocial necesidadCapacitacionSocial) {
        return service.save(necesidadCapacitacionSocial);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Necesidad de Capacitacion Social", notes = "Debe proporcionar un id para eliminar una Necesidad de Capacitacion Social", response = NecesidadCapacitacionSocial.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar Necesidad de Capacitacion Social por id", notes = "Se debe enviar el body y el id a actualizar", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial update(@RequestBody NecesidadCapacitacionSocial necesidadCapacitacionSocial, @PathVariable Long id) {
        NecesidadCapacitacionSocial necesidadCapacitacionSocialEncontrada = service.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Necesidad de Capacitacion Social no encontrada para el id: "+id));
        if (necesidadCapacitacionSocialEncontrada != null) {
            necesidadCapacitacionSocialEncontrada=necesidadCapacitacionSocial;
            return service.save(necesidadCapacitacionSocialEncontrada);
        } else {
            return service.save(necesidadCapacitacionSocial);
        }
    }

}
