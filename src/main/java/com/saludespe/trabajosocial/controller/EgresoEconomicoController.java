package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.EgresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IEgresoEconomicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(value="/egreso-economico")
@Validated
@RestController
public class EgresoEconomicoController {
    
    @Autowired
    private IEgresoEconomicoService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar una Egreso Económico por su Id",
            notes = "Debe proporcionar un id para buscar un Egreso económico", response = EgresoEconomico.class)
    public EgresoEconomico retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Egreso económico no encontrado", ex);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de Egreso económico", notes = "", response = EgresoEconomico.class)
    public List<EgresoEconomico> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Egresos económicos", notes = "Se guardará los datos de egresos económicos", response = EgresoEconomico.class)
    public EgresoEconomico save(@Valid @RequestBody EgresoEconomico egresoEconomico) {
        return service.save(egresoEconomico);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Egresos económicos", notes = "Debe proporcionar un id para eliminar un Egreso económico", response = EgresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar Egreso económico por id", notes = "Se debe enviar el body y el id a actualizar", response = EgresoEconomico.class)
    public EgresoEconomico update(@PathVariable Long id, @Valid @RequestBody EgresoEconomico egresoEconomico, @PathVariable Long id){
        EgresoEconomico newEgresoEconomico = service.findById(id);
        newEgresoEconomico=egresoEconomico;
        return (service.save(newEgresoEconomico));
    }

}