package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IIngresoEconomicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(value="/ingreso-economico")
@Validated
@RestController
public class IngresoEconomicoController {

    @Autowired
    private IIngresoEconomicoService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar una Ingreso Ecómico por su Id",
            notes = "Debe proporcionar un id para buscar un Ingreso Económico", response = IngresoEconomico.class)
    public IngresoEconomico retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Ingreso económico no encontrado", ex);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de Ingreso Económico", notes = "", response = IngresoEconomico.class)
    public List<IngresoEconomico> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Ingreso Económico", notes = "Se guardará los datos de Ingreso Económico", response = IngresoEconomico.class)
    public IngresoEconomico save(@Valid @RequestBody IngresoEconomico ingresoEconomico) {
        return service.save(ingresoEconomico);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Ingreso Económico", notes = "Debe proporcionar un id para eliminar un Ingreso Económico", response = IngresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar Ingreso Económico por id", notes = "Se debe enviar el body y el id a actualizar", response = IngresoEconomico.class)
    public IngresoEconomico update(@PathVariable Long idPaciente, @Valid @RequestBody IngresoEconomico ingresoEconomico, @PathVariable Long id){
        IngresoEconomico newIngresoEconomico= service.findById(id);
        newIngresoEconomico= ingresoEconomico;
        return (service.save(newIngresoEconomico));
    }


}
